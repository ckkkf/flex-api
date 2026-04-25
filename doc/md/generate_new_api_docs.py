import json
import re
from pathlib import Path
from collections import defaultdict, OrderedDict

ROOT = Path('/Users/ckkk/dev/code/Java/flex-api')
DOC = ROOT / 'doc'
API = json.loads((ROOT / 'new-api-main/docs/openapi/api.json').read_text())
RELAY = json.loads((ROOT / 'new-api-main/docs/openapi/relay.json').read_text())

# ---------------------------- helpers ----------------------------

def slug(s: str) -> str:
    s = s.replace('/', '-').replace('(', '-').replace(')', '').replace(' ', '-')
    s = re.sub(r'[^0-9A-Za-z\-\u4e00-\u9fff]+', '-', s)
    s = re.sub(r'-+', '-', s).strip('-')
    return s


def norm_ref_name(ref: str) -> str:
    return ref.split('/')[-1]


def json_type(schema: dict) -> str:
    if '$ref' in schema:
        return norm_ref_name(schema['$ref'])
    t = schema.get('type', 'object')
    if t == 'array':
        return f"array<{json_type(schema.get('items', {}))}>"
    return t


def table(rows):
    out = ['| 字段 | 类型 | 含义 | 取值范围 |', '|---|---|---|---|']
    for name, typ, desc, rng in rows:
        out.append(f'| {name} | {typ} | {desc} | {rng or "-"} |')
    return out


def parse_go_struct(struct_name: str):
    files = list((ROOT / 'new-api-main/model').glob('*.go')) + list((ROOT / 'new-api-main/controller').glob('*.go')) + list((ROOT / 'new-api-main/dto').glob('*.go'))
    pat = re.compile(r'type\s+' + re.escape(struct_name) + r'\s+struct\s*\{')
    for path in files:
        txt = path.read_text()
        m = pat.search(txt)
        if not m:
            continue
        i = m.end()
        depth = 1
        body = []
        while i < len(txt):
            c = txt[i]
            if c == '{':
                depth += 1
            elif c == '}':
                depth -= 1
                if depth == 0:
                    break
            body.append(c)
            i += 1
        fields = []
        for raw in ''.join(body).splitlines():
            s = raw.strip()
            if not s or s.startswith('//') or '`' not in s:
                continue
            code_part, comment = s.split('//', 1) if '//' in s else (s, '')
            comment = comment.strip()
            prefix, tags = code_part.split('`', 1)
            tags = tags.rsplit('`', 1)[0]
            parts = prefix.strip().split()
            if len(parts) < 2:
                continue
            go_name, go_type = parts[0], parts[1]
            tag_map = dict(re.findall(r'(json|gorm):"([^"]*)"', tags))
            json_name = tag_map.get('json', '').split(',')[0]
            if json_name in ('', '-'):
                gorm = tag_map.get('gorm', '')
                mcol = re.search(r'column:([A-Za-z0-9_]+)', gorm)
                if mcol:
                    json_name = mcol.group(1)
                else:
                    json_name = re.sub(r'([a-z0-9])([A-Z])', r'\1_\2', go_name).lower()
            fields.append((json_name, go_type, comment or '-'))
        return path, fields
    return None, []


def resolve_schema(schema: dict, pool: dict):
    if not schema:
        return [('(body)', 'object', '请求体', '-')], 'object'
    if '$ref' in schema:
        name = norm_ref_name(schema['$ref'])
        props = pool.get(name, {}).get('properties', {})
        if props:
            rows = []
            for key, prop in props.items():
                rng = ' / '.join(map(str, prop.get('enum', []))) if prop.get('enum') else '-'
                rows.append((key, json_type(prop), '请求体字段', rng))
            return rows, name
        return [('(root)', name, f'引用组件 {name}', '-')], name
    if schema.get('type') == 'object':
        rows = []
        for key, prop in schema.get('properties', {}).items():
            rng = ' / '.join(map(str, prop.get('enum', []))) if prop.get('enum') else '-'
            rows.append((key, json_type(prop), '请求体字段', rng))
        return rows or [('(body)', 'object', '请求体', '-')], 'object'
    return [('(body)', json_type(schema), '请求体', '-')], json_type(schema)


COMMON_RESPONSE = [
    ('success', 'boolean', '请求是否成功', 'true / false'),
    ('message', 'string', '提示信息或错误原因；成功时通常为空字符串', '任意字符串'),
    ('data', 'any', '业务数据载荷', '对象 / 数组 / 分页对象 / 标量'),
]

PAGE_INFO = [
    ('page', 'integer', '当前页码', '>= 1'),
    ('page_size', 'integer', '每页条数', '1 ~ 100（默认值由后端决定）'),
    ('total', 'integer', '总记录数', '>= 0'),
    ('items', 'array', '当前页数据列表', '数组'),
]

API_ORDER = ['系统','用户登陆注册','OAuth','用户管理','充值','两步验证','安全验证','渠道管理','令牌管理','兑换码','日志','数据统计','分组','任务','供应商','模型管理','系统设置']
RELAY_ORDER = ['获取模型列表','OpenAI格式(Chat)','OpenAI格式(Responses)','图片生成/Qwen千问','视频生成/Sora兼容格式','视频生成/Kling格式','视频生成/即梦格式','视频生成','Claude格式(Messages)','Gemini格式','OpenAI格式(Embeddings)','文本补全(Completions)','OpenAI音频(Audio)','重排序(Rerank)','Moderations','Realtime','未实现/Fine-tunes)','未实现/Files']

MODULE_MODELS = {
    '系统': ['Setup'],
    '用户管理': ['User'],
    '用户登陆注册': ['User'],
    '渠道管理': ['Channel', 'Ability'],
    '令牌管理': ['Token'],
    '兑换码': ['Redemption'],
    '日志': ['Log'],
    '数据统计': ['QuotaData'],
    '分组': ['PrefillGroup'],
    '任务': ['Task', 'Midjourney'],
    '供应商': ['Vendor'],
    '模型管理': ['Model'],
    '系统设置': ['Option'],
    '订阅计费': ['SubscriptionPlan', 'SubscriptionOrder', 'UserSubscription', 'SubscriptionPreConsumeRecord'],
    '自定义OAuth提供商': ['CustomOAuthProvider', 'UserOAuthBinding'],
}

EXTRA_OBJECTS = {
    '自定义OAuth提供商': {
        'CustomOAuthProviderResponse': [
            ('id', 'int', '提供商 ID'), ('name', 'string', '显示名称'), ('slug', 'string', 'URL 标识'), ('icon', 'string', '图标名'),
            ('enabled', 'bool', '是否启用'), ('client_id', 'string', 'OAuth Client ID'), ('authorization_endpoint', 'string', '授权地址'),
            ('token_endpoint', 'string', 'Token 地址'), ('user_info_endpoint', 'string', '用户信息地址'), ('scopes', 'string', '授权范围'),
            ('user_id_field', 'string', '用户 ID 字段路径'), ('username_field', 'string', '用户名字段路径'), ('display_name_field', 'string', '显示名称字段路径'),
            ('email_field', 'string', '邮箱字段路径'), ('well_known', 'string', 'OIDC Discovery 地址'), ('auth_style', 'int', '认证样式'),
            ('access_policy', 'string', '访问控制策略 JSON'), ('access_denied_message', 'string', '访问拒绝提示'),
        ],
        'UserOAuthBindingResponse': [
            ('provider_id', 'int', '提供商 ID'), ('provider_name', 'string', '提供商名称'), ('provider_slug', 'string', '提供商 slug'),
            ('provider_icon', 'string', '提供商图标'), ('provider_user_id', 'string', '第三方平台用户 ID'),
        ],
    },
}

ENUMS = {
    '用户管理': {
        'role': OrderedDict([('0', '访客/未登录上下文'), ('1', '普通用户'), ('10', '管理员'), ('100', 'Root 超级管理员')]),
        'status': OrderedDict([('1', '启用'), ('2', '禁用')]),
    },
    '用户登陆注册': {
        'role': OrderedDict([('0', '访客/未登录上下文'), ('1', '普通用户'), ('10', '管理员'), ('100', 'Root 超级管理员')]),
        'status': OrderedDict([('1', '启用'), ('2', '禁用')]),
    },
    '令牌管理': {
        'status': OrderedDict([('1', '启用'), ('2', '禁用'), ('3', '已过期'), ('4', '额度耗尽')]),
    },
    '兑换码': {
        'status': OrderedDict([('1', '可用'), ('2', '禁用'), ('3', '已使用')]),
    },
    '渠道管理': {
        'status': OrderedDict([('0', '未知'), ('1', '启用'), ('2', '手动禁用'), ('3', '自动禁用')]),
    },
    '日志': {
        'type': OrderedDict([('0', '未知'), ('1', '充值'), ('2', '消费'), ('3', '管理操作'), ('4', '系统事件'), ('5', '错误'), ('6', '退款')]),
    },
    '充值': {
        'status': OrderedDict([('pending', '待支付'), ('success', '支付成功'), ('failed', '支付失败'), ('expired', '已过期')]),
    },
    '任务': {
        'status': OrderedDict([('NOT_START', '未开始'), ('SUBMITTED', '已提交'), ('QUEUED', '排队中'), ('IN_PROGRESS', '处理中'), ('FAILURE', '失败'), ('SUCCESS', '成功'), ('UNKNOWN', '未知')]),
        'platform': OrderedDict([('suno', 'Suno 任务'), ('mj', 'Midjourney 任务')]),
    },
    '订阅计费': {
        'duration_unit': OrderedDict([('year', '按年'), ('month', '按月'), ('day', '按天'), ('hour', '按小时'), ('custom', '按自定义秒数')]),
        'quota_reset_period': OrderedDict([('never', '不重置'), ('daily', '每天重置'), ('weekly', '每周重置'), ('monthly', '每月重置'), ('custom', '按自定义秒数重置')]),
        'status': OrderedDict([('pending', '订单待支付'), ('success', '订单支付成功'), ('failed', '订单支付失败'), ('expired', '订单或订阅已过期'), ('active', '订阅生效中'), ('cancelled', '订阅已取消'), ('consumed', '预扣费已结算'), ('refunded', '预扣费已退款')]),
        'source': OrderedDict([('order', '订单创建'), ('admin', '管理员手动创建')]),
    },
    '模型部署': {
        'status': OrderedDict([('running', '运行中'), ('completed', '已完成'), ('failed', '失败'), ('deployment requested', '已申请部署'), ('termination requested', '已申请终止'), ('destroyed', '已销毁')]),
    },
    '自定义OAuth提供商': {
        'auth_style': OrderedDict([('0', '自动选择'), ('1', '参数模式'), ('2', 'Header Basic Auth 模式')]),
    }
}

# 渠道类型补充
channel_const = (ROOT / 'new-api-main/constant/channel.go').read_text()
channel_types = OrderedDict()
for m in re.finditer(r'ChannelType([A-Za-z0-9_]+)\s*=\s*(\d+)', channel_const):
    channel_types[m.group(2)] = m.group(1)
ENUMS['渠道管理']['type'] = channel_types

PARAM_DESC = {
    'p': ('页码', '>= 1'), 'page_size': ('每页条数', '1 ~ 100'), 'id': ('资源 ID', '整数或字符串 ID'), 'keyword': ('搜索关键字', '任意字符串'),
    'status': ('状态筛选条件', '见模块枚举说明'), 'type': ('类型筛选条件', '见模块枚举说明'), 'query': ('搜索关键字', '任意字符串'),
    'tag_mode': ('是否启用标签聚合模式', 'true / false'), 'id_sort': ('是否按 ID 排序', 'true / false'), 'provider_id': ('OAuth 提供商 ID', '>= 1'),
    'task_id': ('任务 ID', '字符串'), 'file_id': ('文件 ID', '字符串'), 'fine_tune_id': ('微调任务 ID', '字符串'),
}

ROUTE_REQUEST_OVERRIDES = {
    ('POST', '/api/custom-oauth-provider/discovery'): [
        ('well_known_url', 'string', 'OIDC Discovery 完整 URL', 'http/https URL；与 issuer_url 二选一至少填一个'),
        ('issuer_url', 'string', 'OIDC Issuer URL；后端会自动补齐 /.well-known/openid-configuration', 'http/https URL；与 well_known_url 二选一至少填一个'),
    ],
    ('POST', '/api/custom-oauth-provider/'): [
        ('name', 'string', '显示名称', '必填，非空字符串'),
        ('slug', 'string', 'URL 标识', '必填；且不能与内置 OAuth 提供商冲突'),
        ('icon', 'string', '图标名称', '可选'),
        ('enabled', 'boolean', '是否启用', 'true / false'),
        ('client_id', 'string', 'OAuth Client ID', '必填'),
        ('client_secret', 'string', 'OAuth Client Secret', '必填'),
        ('authorization_endpoint', 'string', '授权地址', '必填，URL'),
        ('token_endpoint', 'string', '令牌交换地址', '必填，URL'),
        ('user_info_endpoint', 'string', '用户信息地址', '必填，URL'),
        ('scopes', 'string', '授权范围', '如 openid profile email'),
        ('user_id_field', 'string', '用户 ID 字段路径', '支持 JSONPath 风格路径'),
        ('username_field', 'string', '用户名字段路径', '支持 JSONPath 风格路径'),
        ('display_name_field', 'string', '显示名称字段路径', '支持 JSONPath 风格路径'),
        ('email_field', 'string', '邮箱字段路径', '支持 JSONPath 风格路径'),
        ('well_known', 'string', 'OIDC discovery 地址', '可选 URL'),
        ('auth_style', 'integer', '认证样式', '0 / 1 / 2'),
        ('access_policy', 'string', '访问控制策略 JSON', 'JSON 字符串'),
        ('access_denied_message', 'string', '访问拒绝提示', '字符串'),
    ],
    ('PUT', '/api/custom-oauth-provider/{id}'): [
        ('name', 'string', '显示名称', '可选，非空字符串'),
        ('slug', 'string', 'URL 标识', '可选；不能与其他 provider 或内置 OAuth 冲突'),
        ('icon', 'string|null', '图标名称', '传 null 表示保持现有值'),
        ('enabled', 'boolean|null', '是否启用', 'true / false / null'),
        ('client_id', 'string', 'OAuth Client ID', '可选'),
        ('client_secret', 'string', 'OAuth Client Secret', '空字符串表示不变'),
        ('authorization_endpoint', 'string', '授权地址', '可选 URL'),
        ('token_endpoint', 'string', '令牌交换地址', '可选 URL'),
        ('user_info_endpoint', 'string', '用户信息地址', '可选 URL'),
        ('scopes', 'string', '授权范围', '可选'),
        ('user_id_field', 'string', '用户 ID 字段路径', '可选'),
        ('username_field', 'string', '用户名字段路径', '可选'),
        ('display_name_field', 'string', '显示名称字段路径', '可选'),
        ('email_field', 'string', '邮箱字段路径', '可选'),
        ('well_known', 'string|null', 'OIDC discovery 地址', '可选 / null'),
        ('auth_style', 'integer|null', '认证样式', '0 / 1 / 2 / null'),
        ('access_policy', 'string|null', '访问控制策略 JSON', 'JSON 字符串 / null'),
        ('access_denied_message', 'string|null', '访问拒绝提示', '字符串 / null'),
    ],
    ('PUT', '/api/subscription/self/preference'): [
        ('billing_preference', 'string', '计费偏好', 'wallet / subscription 等实现支持值'),
    ],
    ('PATCH', '/api/subscription/admin/plans/{id}'): [
        ('enabled', 'boolean', '是否启用套餐', 'true / false'),
    ],
    ('POST', '/api/subscription/admin/bind'): [
        ('user_id', 'integer', '用户 ID', '>= 1'),
        ('plan_id', 'integer', '套餐 ID', '>= 1'),
    ],
    ('POST', '/api/subscription/admin/users/{id}/subscriptions'): [
        ('plan_id', 'integer', '套餐 ID', '>= 1'),
    ],
    ('POST', '/api/deployments/settings/test-connection'): [
        ('api_key', 'string', 'io.net API Key；不传则尝试读取系统配置', '可选'),
    ],
    ('POST', '/api/deployments/price-estimation'): [
        ('hardware_id', 'integer', '硬件 ID', '>= 1'),
        ('gpu_count', 'integer', 'GPU 数量', '>= 1'),
        ('duration_minutes', 'integer', '时长（分钟）', '>= 1'),
    ],
    ('PUT', '/api/deployments/{id}/name'): [
        ('name', 'string', '新部署名称', '必填；需通过可用性检查'),
    ],
}

ROUTE_RESPONSE_OVERRIDES = {
    ('POST', '/api/user/login'): [
        ('success', 'boolean', '登录是否成功', 'true / false'),
        ('message', 'string', '错误信息；要求 2FA 时为提示文案', '任意字符串'),
        ('data.require_2fa', 'boolean', '是否需要继续进行 2FA 验证', 'true / false'),
        ('data.id', 'integer', '登录成功后的用户 ID', '>= 1'),
        ('data.username', 'string', '用户名', '非空字符串'),
        ('data.display_name', 'string', '显示名称', '字符串'),
        ('data.role', 'integer', '用户角色', '0 / 1 / 10 / 100'),
        ('data.status', 'integer', '用户状态', '1 / 2'),
        ('data.group', 'string', '用户分组', '字符串'),
    ],
    ('GET', '/api/user/logout'): [
        ('success', 'boolean', '登出是否成功', 'true / false'),
        ('message', 'string', '错误信息；成功时为空', '任意字符串'),
    ],
    ('GET', '/api/user/self'): [
        ('success', 'boolean', '请求是否成功', 'true / false'),
        ('message', 'string', '错误信息；成功时为空', '任意字符串'),
        ('data.id', 'integer', '用户 ID', '>= 1'),
        ('data.username', 'string', '用户名', '非空字符串'),
        ('data.display_name', 'string', '显示名称', '字符串'),
        ('data.role', 'integer', '用户角色', '0 / 1 / 10 / 100'),
        ('data.status', 'integer', '用户状态', '1 / 2'),
        ('data.group', 'string', '所属分组', '字符串'),
        ('data.quota', 'integer', '总额度', '>= 0'),
        ('data.used_quota', 'integer', '已使用额度', '>= 0'),
        ('data.request_count', 'integer', '请求次数', '>= 0'),
        ('data.sidebar_modules', 'object', '用户侧边栏模块配置', '对象'),
        ('data.permissions', 'object', '基于角色计算出的权限集合', '对象'),
    ],
    ('GET', '/api/token/'): [
        ('success', 'boolean', '请求是否成功', 'true / false'),
        ('message', 'string', '错误信息；成功时为空', '任意字符串'),
        ('data.page', 'integer', '当前页码', '>= 1'),
        ('data.page_size', 'integer', '每页条数', '1 ~ 100'),
        ('data.total', 'integer', '总记录数', '>= 0'),
        ('data.items[]', 'Token', '脱敏后的令牌列表；key 字段为掩码值', '数组'),
    ],
    ('GET', '/api/token/{id}'): [
        ('success', 'boolean', '请求是否成功', 'true / false'),
        ('message', 'string', '错误信息；成功时为空', '任意字符串'),
        ('data', 'Token', '脱敏后的单个令牌对象', '对象'),
    ],
    ('POST', '/api/token/{id}/key'): [
        ('success', 'boolean', '请求是否成功', 'true / false'),
        ('message', 'string', '错误信息；成功时为空', '任意字符串'),
        ('data.key', 'string', '令牌完整 Key', 'sk- 开头或完整 token 字符串'),
    ],
    ('GET', '/api/usage/token/'): [
        ('object', 'string', '固定对象类型', 'credit_summary'),
        ('total_granted', 'integer', '授予总额度', '>= 0'),
        ('total_used', 'integer', '已使用额度（当前实现常为 0）', '>= 0'),
        ('total_available', 'integer', '剩余额度', '>= 0'),
        ('expires_at', 'integer', '过期时间毫秒时间戳；0 表示永不过期', '>= 0'),
    ],
    ('PUT', '/api/subscription/self/preference'): [
        ('success', 'boolean', '请求是否成功', 'true / false'),
        ('message', 'string', '错误信息；成功时为空', '任意字符串'),
        ('data.billing_preference', 'string', '更新后的计费偏好', 'wallet / subscription 等实现支持值'),
    ],
    ('POST', '/api/subscription/admin/bind'): [
        ('success', 'boolean', '请求是否成功', 'true / false'),
        ('message', 'string', '错误信息；成功时为空', '任意字符串'),
        ('data.message', 'string', '绑定成功时的附加提示；无提示时 data 可能为 null', '字符串'),
    ],
    ('GET', '/api/subscription/admin/users/{id}/subscriptions'): [
        ('success', 'boolean', '请求是否成功', 'true / false'),
        ('message', 'string', '错误信息；成功时为空', '任意字符串'),
        ('data[]', 'SubscriptionSummary', '指定用户的全部订阅列表', '数组'),
    ],
    ('POST', '/api/subscription/admin/users/{id}/subscriptions'): [
        ('success', 'boolean', '请求是否成功', 'true / false'),
        ('message', 'string', '错误信息；成功时为空', '任意字符串'),
        ('data.message', 'string', '创建成功时的附加提示；无提示时 data 可能为 null', '字符串'),
    ],
    ('POST', '/api/subscription/admin/user_subscriptions/{id}/invalidate'): [
        ('success', 'boolean', '请求是否成功', 'true / false'),
        ('message', 'string', '错误信息；成功时为空', '任意字符串'),
        ('data.message', 'string', '失效成功时的附加提示；无提示时 data 可能为 null', '字符串'),
    ],
    ('DELETE', '/api/subscription/admin/user_subscriptions/{id}'): [
        ('success', 'boolean', '请求是否成功', 'true / false'),
        ('message', 'string', '错误信息；成功时为空', '任意字符串'),
        ('data.message', 'string', '删除成功时的附加提示；无提示时 data 可能为 null', '字符串'),
    ],
    ('GET', '/api/subscription/self'): [
        ('success', 'boolean', '请求是否成功', 'true / false'),
        ('message', 'string', '错误信息；成功时为空', '任意字符串'),
        ('data.billing_preference', 'string', '计费偏好', 'wallet / subscription 等实现支持值'),
        ('data.subscriptions[]', 'SubscriptionSummary', '当前生效中的订阅列表', '数组'),
        ('data.all_subscriptions[]', 'SubscriptionSummary', '包含过期记录的全部订阅列表', '数组'),
    ],
    ('GET', '/api/deployments/settings'): [
        ('success', 'boolean', '请求是否成功', 'true / false'),
        ('message', 'string', '错误信息；成功时为空', '任意字符串'),
        ('data.provider', 'string', '部署提供商', '当前固定为 io.net'),
        ('data.enabled', 'boolean', '是否启用部署功能', 'true / false'),
        ('data.configured', 'boolean', '是否已配置 API Key', 'true / false'),
        ('data.can_connect', 'boolean', '是否具备连接条件', 'true / false'),
    ],
    ('GET', '/api/channel/'): [
        ('success', 'boolean', '请求是否成功', 'true / false'),
        ('message', 'string', '错误信息；成功时为空', '任意字符串'),
        ('data.page', 'integer', '当前页码', '>= 1'),
        ('data.page_size', 'integer', '每页条数', '1 ~ 100'),
        ('data.total', 'integer', '总记录数', '>= 0'),
        ('data.items[]', 'Channel', '渠道列表（已清除敏感 channel_info）', '数组'),
        ('data.type_counts', 'object', '按渠道类型聚合的统计结果', 'key 为渠道类型枚举值'),
    ],
    ('GET', '/api/channel/search'): [
        ('success', 'boolean', '请求是否成功', 'true / false'),
        ('message', 'string', '错误信息；成功时为空', '任意字符串'),
        ('data.items[]', 'Channel', '搜索结果渠道列表', '数组'),
        ('data.total', 'integer', '搜索结果总数', '>= 0'),
        ('data.type_counts', 'object', '按渠道类型聚合的统计结果', 'key 为渠道类型枚举值'),
    ],
    ('GET', '/api/channel/{id}'): [
        ('success', 'boolean', '请求是否成功', 'true / false'),
        ('message', 'string', '错误信息；成功时为空', '任意字符串'),
        ('data', 'Channel', '单个渠道对象（不含敏感 key）', '对象'),
    ],
    ('POST', '/api/channel/{id}/key'): [
        ('success', 'boolean', '请求是否成功', 'true / false'),
        ('message', 'string', '成功时通常为“获取成功”', '任意字符串'),
        ('data.key', 'string', '渠道完整密钥', '字符串'),
    ],
    ('GET', '/api/custom-oauth-provider/'): [
        ('success', 'boolean', '请求是否成功', 'true / false'),
        ('message', 'string', '错误信息；成功时为空', '任意字符串'),
        ('data[]', 'CustomOAuthProviderResponse', '自定义 OAuth 提供商列表（已排除 client_secret）', '数组'),
    ],
    ('GET', '/api/custom-oauth-provider/{id}'): [
        ('success', 'boolean', '请求是否成功', 'true / false'),
        ('message', 'string', '错误信息；成功时为空', '任意字符串'),
        ('data', 'CustomOAuthProviderResponse', '单个自定义 OAuth 提供商对象', '对象'),
    ],
    ('POST', '/api/custom-oauth-provider/'): [
        ('success', 'boolean', '请求是否成功', 'true / false'),
        ('message', 'string', '成功时为“创建成功”', '任意字符串'),
        ('data', 'CustomOAuthProviderResponse', '创建后的提供商对象', '对象'),
    ],
    ('PUT', '/api/custom-oauth-provider/{id}'): [
        ('success', 'boolean', '请求是否成功', 'true / false'),
        ('message', 'string', '成功时为“更新成功”', '任意字符串'),
        ('data', 'CustomOAuthProviderResponse', '更新后的提供商对象', '对象'),
    ],
    ('GET', '/api/user/oauth/bindings'): [
        ('success', 'boolean', '请求是否成功', 'true / false'),
        ('message', 'string', '错误信息；成功时为空', '任意字符串'),
        ('data[]', 'UserOAuthBindingResponse', '当前用户的 OAuth 绑定列表', '数组'),
    ],
    ('GET', '/api/user/{id}/oauth/bindings'): [
        ('success', 'boolean', '请求是否成功', 'true / false'),
        ('message', 'string', '错误信息；成功时为空', '任意字符串'),
        ('data[]', 'UserOAuthBindingResponse', '管理员视角下指定用户的 OAuth 绑定列表', '数组'),
    ],
    ('DELETE', '/api/user/oauth/bindings/{provider_id}'): [
        ('success', 'boolean', '请求是否成功', 'true / false'),
        ('message', 'string', '成功时为“解绑成功”', '任意字符串'),
    ],
    ('GET', '/api/deployments/'): [
        ('success', 'boolean', '请求是否成功', 'true / false'),
        ('message', 'string', '错误信息；成功时为空', '任意字符串'),
        ('data.page', 'integer', '当前页码', '>= 1'),
        ('data.page_size', 'integer', '每页条数', '1 ~ 100'),
        ('data.total', 'integer', '部署总数', '>= 0'),
        ('data.items[]', 'Deployment', '部署列表', '数组'),
        ('data.status_counts', 'object', '按状态统计的部署数量', 'key 为部署状态字符串'),
    ],
    ('GET', '/api/deployments/search'): [
        ('success', 'boolean', '请求是否成功', 'true / false'),
        ('message', 'string', '错误信息；成功时为空', '任意字符串'),
        ('data.page', 'integer', '当前页码', '>= 1'),
        ('data.page_size', 'integer', '每页条数', '1 ~ 100'),
        ('data.total', 'integer', '搜索后的部署总数', '>= 0'),
        ('data.items[]', 'Deployment', '搜索命中的部署列表', '数组'),
    ],
    ('GET', '/api/deployments/{id}'): [
        ('success', 'boolean', '请求是否成功', 'true / false'),
        ('message', 'string', '错误信息；成功时为空', '任意字符串'),
        ('data.id', 'string', '部署 ID', '字符串'),
        ('data.status', 'string', '部署状态', '见模型部署状态枚举'),
        ('data.instance_count', 'integer', '实例数', '>= 0'),
        ('data.hardware_id', 'integer', '硬件 ID', '>= 1'),
        ('data.amount_paid', 'number', '已支付金额', '>= 0'),
        ('data.total_gpus', 'integer', '总 GPU 数', '>= 0'),
        ('data.locations', 'array', '地域列表', '数组'),
        ('data.container_config', 'object', '容器配置', '对象'),
    ],
    ('GET', '/api/deployments/check-name'): [
        ('success', 'boolean', '请求是否成功', 'true / false'),
        ('message', 'string', '错误信息；成功时为空', '任意字符串'),
        ('data.available', 'boolean', '名称是否可用', 'true / false'),
        ('data.name', 'string', '待检查的名称', '非空字符串'),
    ],
    ('POST', '/api/deployments/'): [
        ('success', 'boolean', '请求是否成功', 'true / false'),
        ('message', 'string', '错误信息；成功时为空', '任意字符串'),
        ('data.deployment_id', 'string', '新建部署 ID', '字符串'),
        ('data.status', 'string', '创建结果状态', '字符串'),
        ('data.message', 'string', '成功提示', 'Deployment created successfully'),
    ],
    ('PUT', '/api/deployments/{id}'): [
        ('success', 'boolean', '请求是否成功', 'true / false'),
        ('message', 'string', '错误信息；成功时为空', '任意字符串'),
        ('data.status', 'string', '更新结果状态', '字符串'),
        ('data.deployment_id', 'string', '部署 ID', '字符串'),
    ],
    ('PUT', '/api/deployments/{id}/name'): [
        ('success', 'boolean', '请求是否成功', 'true / false'),
        ('message', 'string', '外层错误信息；成功时为空', '任意字符串'),
        ('data.status', 'string', '更新结果状态', '字符串'),
        ('data.message', 'string', '底层接口返回消息', '字符串'),
        ('data.id', 'string', '部署 ID', '字符串'),
        ('data.name', 'string', '更新后的部署名称', '非空字符串'),
    ],
    ('POST', '/api/deployments/{id}/extend'): [
        ('success', 'boolean', '请求是否成功', 'true / false'),
        ('message', 'string', '错误信息；成功时为空', '任意字符串'),
        ('data', 'Deployment', '续期后的部署摘要对象', '对象'),
    ],
    ('DELETE', '/api/deployments/{id}'): [
        ('success', 'boolean', '请求是否成功', 'true / false'),
        ('message', 'string', '外层错误信息；成功时为空', '任意字符串'),
        ('data.status', 'string', '删除请求状态', '字符串'),
        ('data.deployment_id', 'string', '部署 ID', '字符串'),
        ('data.message', 'string', '固定成功提示', 'Deployment termination requested successfully'),
    ],
    ('GET', '/api/deployments/hardware-types'): [
        ('success', 'boolean', '请求是否成功', 'true / false'),
        ('message', 'string', '错误信息；成功时为空', '任意字符串'),
        ('data.hardware_types[]', 'object', '硬件类型列表', '数组'),
        ('data.total', 'integer', '硬件类型数量', '>= 0'),
        ('data.total_available', 'integer', '总可用资源数', '>= 0'),
    ],
    ('GET', '/api/deployments/locations'): [
        ('success', 'boolean', '请求是否成功', 'true / false'),
        ('message', 'string', '错误信息；成功时为空', '任意字符串'),
        ('data.locations[]', 'object', '地域列表', '数组'),
        ('data.total', 'integer', '地域总数', '>= 0'),
    ],
    ('GET', '/api/deployments/available-replicas'): [
        ('success', 'boolean', '请求是否成功', 'true / false'),
        ('message', 'string', '错误信息；成功时为空', '任意字符串'),
        ('data', 'object', '可用副本响应对象', '由 io.net 原样返回'),
    ],
    ('POST', '/api/deployments/price-estimation'): [
        ('success', 'boolean', '请求是否成功', 'true / false'),
        ('message', 'string', '错误信息；成功时为空', '任意字符串'),
        ('data', 'object', '价格预估响应对象', '由 io.net 原样返回'),
    ],
    ('GET', '/api/deployments/{id}/containers/{container_id}'): [
        ('success', 'boolean', '请求是否成功', 'true / false'),
        ('message', 'string', '错误信息；成功时为空', '任意字符串'),
        ('data', 'object', '单个容器详情对象', '对象'),
    ],
    ('GET', '/api/deployments/{id}/containers'): [
        ('success', 'boolean', '请求是否成功', 'true / false'),
        ('message', 'string', '错误信息；成功时为空', '任意字符串'),
        ('data.total', 'integer', '容器总数', '>= 0'),
        ('data.containers[]', 'object', '容器列表', '数组'),
        ('data.containers[].container_id', 'string', '容器 ID', '字符串'),
        ('data.containers[].status', 'string', '容器状态', '字符串'),
        ('data.containers[].events[]', 'object', '容器事件列表', '数组'),
    ],
    ('GET', '/api/deployments/{id}/logs'): [
        ('success', 'boolean', '请求是否成功', 'true / false'),
        ('message', 'string', '错误信息；成功时为空', '任意字符串'),
        ('data', 'string|object', '原始容器日志内容', '由 io.net 接口返回'),
    ],
}

SUPPLEMENTAL_PARAM_OVERRIDES = {
    ('GET', '/api/custom-oauth-provider/{id}'): [('id', 'path / integer / 必填', '提供商 ID', '>= 1')],
    ('PUT', '/api/custom-oauth-provider/{id}'): [('id', 'path / integer / 必填', '提供商 ID', '>= 1')],
    ('DELETE', '/api/custom-oauth-provider/{id}'): [('id', 'path / integer / 必填', '提供商 ID', '>= 1')],
    ('GET', '/api/subscription/admin/users/{id}/subscriptions'): [('id', 'path / integer / 必填', '用户 ID', '>= 1')],
    ('POST', '/api/subscription/admin/users/{id}/subscriptions'): [('id', 'path / integer / 必填', '用户 ID', '>= 1')],
    ('POST', '/api/subscription/admin/plans/{id}'): [('id', 'path / integer / 必填', '套餐 ID', '>= 1')],
    ('PUT', '/api/subscription/admin/plans/{id}'): [('id', 'path / integer / 必填', '套餐 ID', '>= 1')],
    ('PATCH', '/api/subscription/admin/plans/{id}'): [('id', 'path / integer / 必填', '套餐 ID', '>= 1')],
    ('POST', '/api/subscription/admin/user_subscriptions/{id}/invalidate'): [('id', 'path / integer / 必填', '订阅实例 ID', '>= 1')],
    ('DELETE', '/api/subscription/admin/user_subscriptions/{id}'): [('id', 'path / integer / 必填', '订阅实例 ID', '>= 1')],
    ('GET', '/api/deployments/'): [('status', 'query / string / 选填', '按部署状态筛选', '见模型部署状态枚举')],
    ('GET', '/api/deployments/search'): [('status', 'query / string / 选填', '按部署状态筛选', '见模型部署状态枚举'), ('keyword', 'query / string / 选填', '按部署名称关键字搜索', '任意字符串')],
    ('GET', '/api/deployments/check-name'): [('name', 'query / string / 必填', '待检查的部署名称', '非空字符串')],
    ('GET', '/api/deployments/available-replicas'): [('hardware_id', 'query / integer / 必填', '硬件 ID', '>= 1'), ('gpu_count', 'query / integer / 选填', 'GPU 数量', '>= 1，默认 1')],
    ('GET', '/api/deployments/{id}'): [('id', 'path / string / 必填', '部署 ID', '字符串')],
    ('PUT', '/api/deployments/{id}'): [('id', 'path / string / 必填', '部署 ID', '字符串')],
    ('PUT', '/api/deployments/{id}/name'): [('id', 'path / string / 必填', '部署 ID', '字符串')],
    ('POST', '/api/deployments/{id}/extend'): [('id', 'path / string / 必填', '部署 ID', '字符串')],
    ('DELETE', '/api/deployments/{id}'): [('id', 'path / string / 必填', '部署 ID', '字符串')],
    ('GET', '/api/deployments/{id}/logs'): [('id', 'path / string / 必填', '部署 ID', '字符串'), ('container_id', 'query / string / 必填', '容器 ID', '字符串'), ('level', 'query / string / 选填', '日志级别', '字符串'), ('stream', 'query / string / 选填', '日志流', 'stdout / stderr 等'), ('cursor', 'query / string / 选填', '分页游标', '字符串'), ('limit', 'query / integer / 选填', '返回条数', '1 ~ 1000'), ('follow', 'query / boolean / 选填', '是否持续追踪', 'true / false'), ('start_time', 'query / string / 选填', '开始时间', 'RFC3339 时间'), ('end_time', 'query / string / 选填', '结束时间', 'RFC3339 时间')],
    ('GET', '/api/deployments/{id}/containers'): [('id', 'path / string / 必填', '部署 ID', '字符串')],
    ('GET', '/api/deployments/{id}/containers/{container_id}'): [('id', 'path / string / 必填', '部署 ID', '字符串'), ('container_id', 'path / string / 必填', '容器 ID', '字符串')],
}

SUPPLEMENTAL = {
    '订阅计费': [('GET','/api/subscription/plans','获取订阅套餐列表'),('GET','/api/subscription/self','获取当前用户订阅信息'),('PUT','/api/subscription/self/preference','更新订阅计费偏好'),('POST','/api/subscription/epay/pay','发起订阅易支付'),('POST','/api/subscription/stripe/pay','发起订阅 Stripe 支付'),('POST','/api/subscription/creem/pay','发起订阅 Creem 支付'),('GET','/api/subscription/admin/plans','管理员获取订阅套餐'),('POST','/api/subscription/admin/plans','管理员创建订阅套餐'),('PUT','/api/subscription/admin/plans/{id}','管理员更新订阅套餐'),('PATCH','/api/subscription/admin/plans/{id}','管理员更新订阅套餐状态'),('POST','/api/subscription/admin/bind','管理员绑定订阅'),('GET','/api/subscription/admin/users/{id}/subscriptions','管理员获取用户订阅列表'),('POST','/api/subscription/admin/users/{id}/subscriptions','管理员创建用户订阅'),('POST','/api/subscription/admin/user_subscriptions/{id}/invalidate','管理员使订阅失效'),('DELETE','/api/subscription/admin/user_subscriptions/{id}','管理员删除用户订阅'),('GET','/api/subscription/epay/notify','订阅易支付回调(GET)'),('POST','/api/subscription/epay/notify','订阅易支付回调(POST)'),('GET','/api/subscription/epay/return','订阅易支付同步返回(GET)'),('POST','/api/subscription/epay/return','订阅易支付同步返回(POST)')],
    '自定义OAuth提供商': [('POST','/api/custom-oauth-provider/discovery','获取 OIDC Discovery 配置'),('GET','/api/custom-oauth-provider/','获取自定义 OAuth 提供商列表'),('GET','/api/custom-oauth-provider/{id}','获取自定义 OAuth 提供商详情'),('POST','/api/custom-oauth-provider/','创建自定义 OAuth 提供商'),('PUT','/api/custom-oauth-provider/{id}','更新自定义 OAuth 提供商'),('DELETE','/api/custom-oauth-provider/{id}','删除自定义 OAuth 提供商')],
    '模型部署': [('GET','/api/deployments/settings','获取部署设置'),('POST','/api/deployments/settings/test-connection','测试 io.net 连接'),('GET','/api/deployments/','获取部署列表'),('GET','/api/deployments/search','搜索部署'),('POST','/api/deployments/test-connection','测试 io.net 连接'),('GET','/api/deployments/hardware-types','获取硬件类型'),('GET','/api/deployments/locations','获取可用地域'),('GET','/api/deployments/available-replicas','获取可用副本'),('POST','/api/deployments/price-estimation','获取价格预估'),('GET','/api/deployments/check-name','检查集群名称可用性'),('POST','/api/deployments/','创建部署'),('GET','/api/deployments/{id}','获取部署详情'),('GET','/api/deployments/{id}/logs','获取部署日志'),('GET','/api/deployments/{id}/containers','获取部署容器列表'),('GET','/api/deployments/{id}/containers/{container_id}','获取容器详情'),('PUT','/api/deployments/{id}','更新部署'),('PUT','/api/deployments/{id}/name','更新部署名称'),('POST','/api/deployments/{id}/extend','续期部署'),('DELETE','/api/deployments/{id}','删除部署')],
    '性能运维': [('GET','/api/performance/stats','获取性能统计'),('DELETE','/api/performance/disk_cache','清理磁盘缓存'),('POST','/api/performance/reset_stats','重置性能统计'),('POST','/api/performance/gc','触发 GC'),('GET','/api/performance/logs','获取日志文件列表'),('DELETE','/api/performance/logs','清理日志文件')],
    '旧版Dashboard Billing': [('GET','/dashboard/billing/subscription','旧版 Dashboard 订阅账单'),('GET','/v1/dashboard/billing/subscription','OpenAI 兼容订阅账单'),('GET','/dashboard/billing/usage','旧版 Dashboard 用量统计'),('GET','/v1/dashboard/billing/usage','OpenAI 兼容用量统计')],
}

UNUSED_RELAY_SUPPLEMENTAL_PARAM_OVERRIDES = {
    ('GET', '/api/custom-oauth-provider/{id}'): [('id', 'path / integer / 必填', '提供商 ID', '>= 1')],
    ('PUT', '/api/custom-oauth-provider/{id}'): [('id', 'path / integer / 必填', '提供商 ID', '>= 1')],
    ('DELETE', '/api/custom-oauth-provider/{id}'): [('id', 'path / integer / 必填', '提供商 ID', '>= 1')],
    ('GET', '/api/subscription/admin/users/{id}/subscriptions'): [('id', 'path / integer / 必填', '用户 ID', '>= 1')],
    ('POST', '/api/subscription/admin/users/{id}/subscriptions'): [('id', 'path / integer / 必填', '用户 ID', '>= 1')],
    ('POST', '/api/subscription/admin/plans/{id}'): [('id', 'path / integer / 必填', '套餐 ID', '>= 1')],
    ('PUT', '/api/subscription/admin/plans/{id}'): [('id', 'path / integer / 必填', '套餐 ID', '>= 1')],
    ('PATCH', '/api/subscription/admin/plans/{id}'): [('id', 'path / integer / 必填', '套餐 ID', '>= 1')],
    ('POST', '/api/subscription/admin/user_subscriptions/{id}/invalidate'): [('id', 'path / integer / 必填', '订阅实例 ID', '>= 1')],
    ('DELETE', '/api/subscription/admin/user_subscriptions/{id}'): [('id', 'path / integer / 必填', '订阅实例 ID', '>= 1')],
    ('GET', '/api/deployments/'): [('status', 'query / string / 选填', '按部署状态筛选', '见模型部署状态枚举')],
    ('GET', '/api/deployments/search'): [('status', 'query / string / 选填', '按部署状态筛选', '见模型部署状态枚举'), ('keyword', 'query / string / 选填', '按部署名称关键字搜索', '任意字符串')],
    ('GET', '/api/deployments/check-name'): [('name', 'query / string / 必填', '待检查的部署名称', '非空字符串')],
    ('GET', '/api/deployments/available-replicas'): [('hardware_id', 'query / integer / 必填', '硬件 ID', '>= 1'), ('gpu_count', 'query / integer / 选填', 'GPU 数量', '>= 1，默认 1')],
    ('GET', '/api/deployments/{id}'): [('id', 'path / string / 必填', '部署 ID', '字符串')],
    ('PUT', '/api/deployments/{id}'): [('id', 'path / string / 必填', '部署 ID', '字符串')],
    ('PUT', '/api/deployments/{id}/name'): [('id', 'path / string / 必填', '部署 ID', '字符串')],
    ('POST', '/api/deployments/{id}/extend'): [('id', 'path / string / 必填', '部署 ID', '字符串')],
    ('DELETE', '/api/deployments/{id}'): [('id', 'path / string / 必填', '部署 ID', '字符串')],
    ('GET', '/api/deployments/{id}/logs'): [('id', 'path / string / 必填', '部署 ID', '字符串'), ('container_id', 'query / string / 必填', '容器 ID', '字符串'), ('level', 'query / string / 选填', '日志级别', '字符串'), ('stream', 'query / string / 选填', '日志流', 'stdout / stderr 等'), ('cursor', 'query / string / 选填', '分页游标', '字符串'), ('limit', 'query / integer / 选填', '返回条数', '1 ~ 1000'), ('follow', 'query / boolean / 选填', '是否持续追踪', 'true / false'), ('start_time', 'query / string / 选填', '开始时间', 'RFC3339 时间'), ('end_time', 'query / string / 选填', '结束时间', 'RFC3339 时间')],
    ('GET', '/api/deployments/{id}/containers'): [('id', 'path / string / 必填', '部署 ID', '字符串')],
    ('GET', '/api/deployments/{id}/containers/{container_id}'): [('id', 'path / string / 必填', '部署 ID', '字符串'), ('container_id', 'path / string / 必填', '容器 ID', '字符串')],
}

RELAY_SUPPLEMENTAL = {
    '获取模型列表': [('GET','/v1/models/{model}','获取指定模型详情'),('GET','/v1beta/openai/models','Gemini OpenAI 兼容模型列表')],
    'OpenAI格式(Chat)': [('POST','/pg/chat/completions','Playground 聊天补全')],
    '视频生成/Sora兼容格式': [('POST','/v1/videos/{video_id}/remix','视频重混')],
    '中继-Midjourney': [('GET','/mj/image/{id}','获取 Midjourney 图片'),('POST','/mj/submit/action','提交 Midjourney 动作任务'),('POST','/mj/submit/shorten','提交 Midjourney shorten 任务'),('POST','/mj/submit/modal','提交 Midjourney modal 任务'),('POST','/mj/submit/imagine','提交 Midjourney imagine 任务'),('POST','/mj/submit/change','提交 Midjourney change 任务'),('POST','/mj/submit/simple-change','提交 Midjourney simple-change 任务'),('POST','/mj/submit/describe','提交 Midjourney describe 任务'),('POST','/mj/submit/blend','提交 Midjourney blend 任务'),('POST','/mj/submit/edits','提交 Midjourney edits 任务'),('POST','/mj/submit/video','提交 Midjourney video 任务'),('GET','/mj/task/{id}/fetch','获取 Midjourney 任务状态'),('GET','/mj/task/{id}/image-seed','获取 Midjourney image seed'),('POST','/mj/task/list-by-condition','按条件查询 Midjourney 任务'),('POST','/mj/insight-face/swap','Midjourney 人脸替换'),('POST','/mj/submit/upload-discord-images','上传 Discord 图片'),('GET','/:mode/mj/image/{id}','带 mode 的 Midjourney 图片获取')],
    '中继-Suno': [('POST','/suno/submit/{action}','提交 Suno 任务'),('POST','/suno/fetch','查询 Suno 任务'),('GET','/suno/fetch/{id}','查询 Suno 任务(GET)')],
}

API_MODULES = defaultdict(list)
for path, ops in API['paths'].items():
    for method, detail in ops.items():
        for tag in detail.get('tags', ['未分类']):
            API_MODULES[tag].append((method.upper(), path, detail))
for k in API_MODULES:
    API_MODULES[k].sort(key=lambda x: (x[1], x[0]))

RELAY_MODULES = defaultdict(list)
for path, ops in RELAY['paths'].items():
    for method, detail in ops.items():
        for tag in detail.get('tags', ['未分类']):
            RELAY_MODULES[tag].append((method.upper(), path, detail))
for k in RELAY_MODULES:
    RELAY_MODULES[k].sort(key=lambda x: (x[1], x[0]))


def generic_response_text(route, is_relay=False):
    if is_relay:
        return '透传上游兼容协议响应，不再套用后台 `ApiResponse` 外层。'
    method, path = route
    if (method, path) in ROUTE_RESPONSE_OVERRIDES:
        return '已在下方给出字段级响应结构。'
    if '/search' in path or path.endswith('/') and method == 'GET':
        return '通常为 `ApiResponse<PageInfo<T>>`。'
    return '通常为 `ApiResponse<T>` 统一 JSON 包装。'


def request_body_block(route, detail, schema_pool):
    if route in ROUTE_REQUEST_OVERRIDES:
        return ['#### 请求体', ''] + table(ROUTE_REQUEST_OVERRIDES[route]) + ['']
    body = detail.get('requestBody', {}).get('content', {})
    if not body:
        return ['#### 请求体', '', '- 无请求体。', '']
    ctype, content = next(iter(body.items()))
    rows, shape = resolve_schema(content.get('schema', {}), schema_pool)
    out = ['#### 请求体', '', f'- Content-Type：`{ctype}`', f'- 请求体结构：`{shape}`', '']
    out += table(rows)
    out += ['']
    return out


def param_block(detail):
    params = detail.get('parameters', [])
    if not params:
        return ['#### 路径 / Query 参数', '', '- 无路径参数 / Query 参数。', '']
    rows = []
    for p in params:
        name = p['name']
        desc, rng = PARAM_DESC.get(name, (p.get('description') or '-', '-'))
        if p.get('schema', {}).get('enum'):
            rng = ' / '.join(map(str, p['schema']['enum']))
        rows.append((name, f"{p.get('in','-')} / {json_type(p.get('schema', {}))}{' / 必填' if p.get('required') else ' / 选填'}", desc, rng))
    return ['#### 路径 / Query 参数', ''] + table(rows) + ['']



def supplemental_param_block(route):
    rows = SUPPLEMENTAL_PARAM_OVERRIDES.get(route)
    if rows:
        return ['#### 路径 / Query 参数', ''] + table(rows) + ['']
    return ['#### 路径 / Query 参数', '', '- 无路径参数 / Query 参数，或源码未显式声明。', '']

def supplemental_request_block(route):
    rows = ROUTE_REQUEST_OVERRIDES.get(route)
    if rows:
        return ['#### 请求体', ''] + table(rows) + ['']
    return ['#### 请求体', '', '- 未在 OpenAPI 中声明；通常为 JSON 请求，具体字段需以对应 Controller 为准。', '']

def response_block(route, detail=None, module='', relay=False):
    method, path = route
    if relay:
        return ['#### 响应格式', '', f'- {generic_response_text(route, True)}', '']
    rows = ROUTE_RESPONSE_OVERRIDES.get((method, path))
    if rows:
        return ['#### 响应格式', '', f'- {generic_response_text(route)}', ''] + table(rows) + ['']
    return ['#### 响应格式', '', f'- {generic_response_text(route)}', ''] + table(COMMON_RESPONSE) + ['']


def object_section(module):
    out = []
    for extra_name, extra_fields in EXTRA_OBJECTS.get(module, {}).items():
        out += [f'## 核心数据对象：{extra_name}', '']
        rows = [(n, t, d, '-') for n, t, d in extra_fields]
        if module in ENUMS:
            enum_map = ENUMS[module]
            rows = [(n, t, d, '；'.join([f'{k}={v}' for k, v in enum_map.get(n, {}).items()]) if n in enum_map else '-') for n, t, d in extra_fields]
        out += table(rows) + ['']
    for name in MODULE_MODELS.get(module, []):
        src, fields = parse_go_struct(name)
        if not fields:
            continue
        out += [f'## 核心数据对象：{name}', '']
        if src:
            rel = src.relative_to(ROOT / 'new-api-main')
            out += [f'- 来源：`new-api-main/{rel}`', '']
        rows = []
        enums = ENUMS.get(module, {})
        for key, typ, desc in fields:
            rng = '；'.join([f'{k}={v}' for k, v in enums.get(key, {}).items()]) if key in enums else '-'
            rows.append((key, typ, desc, rng))
        out += table(rows) + ['']
    return out


def enum_section(module):
    enums = ENUMS.get(module, {})
    if not enums:
        return []
    out = ['## 状态/枚举字段说明', '']
    for field, mapping in enums.items():
        out += [f'### {field}', '', '| 取值 | 含义 |', '|---|---|']
        for k, v in mapping.items():
            out.append(f'| {k} | {v} |')
        out += ['']
    return out

# ---------------------------- generate docs ----------------------------
created = []
index = ['# new-api-main 接口文档索引', '', '生成时间：2026-04-23', '', '## API 管理面模块', '']

for i, module in enumerate(API_ORDER, 1):
    ops = API_MODULES.get(module, [])
    if not ops:
        continue
    filename = f'new-api-main-api-{i:02d}-{slug(module)}.md'
    created.append(filename)
    index.append(f'- [{module}]({filename})')
    lines = [f'# {module} 模块接口文档', '', f'- 来源：`new-api-main/docs/openapi/api.json`', f'- 接口数量：{len(ops)}', '', '## 模块说明', '', f'- 本模块文档按“接口总览 → 核心数据对象 → 状态枚举 → 接口明细”的固定模板整理。', '- 若 OpenAPI 缺失精确响应 schema，则结合源码统一返回方式补充说明。', '']
    lines += ['## 统一响应结构', ''] + table(COMMON_RESPONSE) + ['']
    lines += ['## 分页结构', ''] + table(PAGE_INFO) + ['']
    lines += object_section(module)
    lines += enum_section(module)
    lines += ['## 接口明细', '']
    for method, path, detail in ops:
        lines += [f'### {method} {path}', '', f'- 摘要：{detail.get("summary", "-")}', f'- 说明：{detail.get("description", "-")}', f'- 请求方法：`{method}`', f'- 路径：`{path}`', '']
        lines += param_block(detail)
        lines += request_body_block((method, path), detail, API.get('components', {}).get('schemas', {}))
        lines += response_block((method, path), detail, module, False)
    (DOC / filename).write_text('\n'.join(lines))

index += ['', '## API 管理面补充模块', '']
for module in ['订阅计费', '自定义OAuth提供商', '模型部署', '性能运维', '旧版Dashboard Billing']:
    filename = f'new-api-main-api-extra-{slug(module)}.md'
    created.append(filename)
    index.append(f'- [{module}]({filename})')
    lines = [f'# {module} 模块接口文档', '', '- 来源：`new-api-main/router/*.go` + `new-api-main/controller/*.go`', f'- 接口数量：{len(SUPPLEMENTAL[module])}', '', '## 模块说明', '', '- 该模块在 OpenAPI 中未完整覆盖，因此主要根据 Router + Controller 源码整理。', '']
    lines += ['## 统一响应结构', ''] + table(COMMON_RESPONSE) + ['']
    lines += object_section(module)
    lines += enum_section(module)
    if module == '模型部署':
        lines += ['## 关键响应对象：Deployment（由 `mapIoNetDeployment` 组装）', '']
        lines += table([
            ('id', 'string', '部署 ID', 'io.net 返回值'),
            ('deployment_name', 'string', '部署名称', '非空字符串'),
            ('status', 'string', '部署状态', '见本模块状态枚举'),
            ('type', 'string', '资源类型', '当前固定为 Container'),
            ('time_remaining_minutes', 'integer', '剩余运行分钟数', '>= 0'),
            ('hardware_info', 'string', '硬件摘要', '品牌 + 型号 + 数量'),
            ('completed_percent', 'integer', '完成百分比', '0 ~ 100'),
            ('resource_config', 'object', '资源配置', 'cpu/memory/gpu'),
        ]) + ['']
    lines += ['## 接口明细', '']
    for method, path, summary in SUPPLEMENTAL[module]:
        lines += [f'### {method} {path}', '', f'- 摘要：{summary}', f'- 请求方法：`{method}`', f'- 路径：`{path}`', '']
        lines += supplemental_param_block((method, path))
        lines += supplemental_request_block((method, path))
        lines += response_block((method, path), module=module)
    (DOC / filename).write_text('\n'.join(lines))

index += ['', '## Relay / 兼容协议模块', '']
relay_order_actual = ['获取模型列表','OpenAI格式(Chat)','OpenAI格式(Responses)','图片生成/Qwen千问','视频生成/Sora兼容格式','视频生成/Kling格式','视频生成/即梦格式','视频生成','Claude格式(Messages)','Gemini格式','OpenAI格式(Embeddings)','文本补全(Completions)','OpenAI音频(Audio)','重排序(Rerank)','Moderations','Realtime','未实现/Fine-tunes','未实现/Files']
for i, module in enumerate(relay_order_actual, 1):
    ops = RELAY_MODULES.get(module, [])
    if not ops and module not in RELAY_SUPPLEMENTAL:
        continue
    filename = f'new-api-main-relay-{i:02d}-{slug(module)}.md'
    created.append(filename)
    index.append(f'- [{module}]({filename})')
    lines = [f'# {module} 模块接口文档', '', '- 来源：`new-api-main/docs/openapi/relay.json` + `new-api-main/router/relay-router.go` / `video-router.go`', f'- OpenAPI 覆盖接口数量：{len(ops)}', '', '## 模块说明', '', '- Relay 接口通常直接透传 OpenAI / Claude / Gemini / 视频平台兼容协议。', '- 绝大多数接口需要令牌认证；少数下载类接口支持用户会话或令牌二选一。', '']
    if module in RELAY_SUPPLEMENTAL:
        lines += ['## 路由补充', '']
        for method, path, summary in RELAY_SUPPLEMENTAL[module]:
            lines.append(f'- `{method} {path}`：{summary}')
        lines += ['']
    lines += ['## 接口明细', '']
    for method, path, detail in ops:
        lines += [f'### {method} {path}', '', f'- 摘要：{detail.get("summary", "-")}', f'- 请求方法：`{method}`', f'- 路径：`{path}`', '']
        lines += param_block(detail)
        lines += request_body_block((method, path), detail, RELAY.get('components', {}).get('schemas', {}))
        lines += response_block((method, path), relay=True)
    (DOC / filename).write_text('\n'.join(lines))

for module in ['中继-Midjourney', '中继-Suno']:
    filename = f'new-api-main-relay-extra-{slug(module)}.md'
    created.append(filename)
    index.append(f'- [{module}]({filename})')
    lines = [f'# {module} 模块接口文档', '', '- 来源：`new-api-main/router/relay-router.go`', f'- 接口数量：{len(RELAY_SUPPLEMENTAL[module])}', '', '## 模块说明', '', '- 当前文档根据路由层整理，响应主要透传上游任务创建与查询结果。', '']
    lines += ['## 接口明细', '']
    for method, path, summary in RELAY_SUPPLEMENTAL[module]:
        lines += [f'### {method} {path}', '', f'- 摘要：{summary}', f'- 请求方法：`{method}`', f'- 路径：`{path}`', '', '#### 请求格式', '', '- 以 JSON 或 multipart/form-data 为主，具体取决于上游兼容协议。', '']
        lines += response_block((method, path), relay=True)
    (DOC / filename).write_text('\n'.join(lines))

index += ['', '## 说明', '', '- 管理面接口优先基于 `new-api-main/docs/openapi/api.json` 生成。', '- Relay 接口优先基于 `new-api-main/docs/openapi/relay.json` 生成，再补路由层未覆盖接口。', '- 文档生成脚本：`doc/generate_new_api_docs.py`。后续如需刷新文档，可直接运行该脚本。', '- 对于 OpenAPI 未给出精确响应 schema 的接口，文档会明确标注为统一 `ApiResponse<T>` 或分页结构，并对关键接口额外补充字段级响应说明。', '']
(DOC / 'new-api-main-接口文档索引.md').write_text('\n'.join(index))
print(f'generated {len(created)} docs')

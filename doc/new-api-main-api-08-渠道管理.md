# 渠道管理 模块接口文档

- 来源：`new-api-main/docs/openapi/api.json`
- 接口数量：25

## 模块说明

- 本模块文档按“接口总览 → 核心数据对象 → 状态枚举 → 接口明细”的固定模板整理。
- 若 OpenAPI 缺失精确响应 schema，则结合源码统一返回方式补充说明。

## 统一响应结构

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

## 分页结构

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| page | integer | 当前页码 | >= 1 |
| page_size | integer | 每页条数 | 1 ~ 100（默认值由后端决定） |
| total | integer | 总记录数 | >= 0 |
| items | array | 当前页数据列表 | 数组 |

## 核心数据对象：Channel

- 来源：`new-api-main/model/channel.go`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| id | int | - | - |
| type | int | - | 0=Unknown；1=OpenAI；2=Midjourney；3=Azure；4=Ollama；5=MidjourneyPlus；6=OpenAIMax；7=OhMyGPT；8=Custom；9=AILS；10=AIProxy；11=PaLM；12=API2GPT；13=AIGC2D；14=Anthropic；15=Baidu；16=Zhipu；17=Ali；18=Xunfei；19=360；20=OpenRouter；21=AIProxyLibrary；22=FastGPT；23=Tencent；24=Gemini；25=Moonshot；26=Zhipu_v4；27=Perplexity；31=LingYiWanWu；33=Aws；34=Cohere；35=MiniMax；36=SunoAPI；37=Dify；38=Jina；40=SiliconFlow；41=VertexAi；42=Mistral；43=DeepSeek；44=MokaAI；45=VolcEngine；46=BaiduV2；47=Xinference；48=Xai；49=Coze；50=Kling；51=Jimeng；52=Vidu；53=Submodel；54=DoubaoVideo；55=Sora；56=Replicate；57=Codex |
| key | string | - | - |
| openai_organization | *string | - | - |
| test_model | *string | - | - |
| status | int | - | 0=未知；1=启用；2=手动禁用；3=自动禁用 |
| name | string | - | - |
| weight | *uint | - | - |
| created_time | int64 | - | - |
| test_time | int64 | - | - |
| response_time | int | in milliseconds | - |
| base_url | *string | - | - |
| other | string | - | - |
| balance | float64 | in USD | - |
| balance_updated_time | int64 | - | - |
| models | string | - | - |
| group | string | - | - |
| used_quota | int64 | - | - |
| model_mapping | *string | - | - |
| status_code_mapping | *string | - | - |
| priority | *int64 | - | - |
| auto_ban | *int | - | - |
| other_info | string | - | - |
| tag | *string | - | - |
| setting | *string | 渠道额外设置 | - |
| param_override | *string | - | - |
| header_override | *string | - | - |
| remark | *string | - | - |
| channel_info | ChannelInfo | - | - |
| settings | string | 其他设置，存储azure版本等不需要检索的信息，详见dto.ChannelOtherSettings | - |
| keys | []string | - | - |

## 核心数据对象：Ability

- 来源：`new-api-main/model/ability.go`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| group | string | - | - |
| model | string | - | - |
| channel_id | int | - | - |
| enabled | bool | - | - |
| priority | *int64 | - | - |
| weight | uint | - | - |
| tag | *string | - | - |

## 状态/枚举字段说明

### status

| 取值 | 含义 |
|---|---|
| 0 | 未知 |
| 1 | 启用 |
| 2 | 手动禁用 |
| 3 | 自动禁用 |

### type

| 取值 | 含义 |
|---|---|
| 0 | Unknown |
| 1 | OpenAI |
| 2 | Midjourney |
| 3 | Azure |
| 4 | Ollama |
| 5 | MidjourneyPlus |
| 6 | OpenAIMax |
| 7 | OhMyGPT |
| 8 | Custom |
| 9 | AILS |
| 10 | AIProxy |
| 11 | PaLM |
| 12 | API2GPT |
| 13 | AIGC2D |
| 14 | Anthropic |
| 15 | Baidu |
| 16 | Zhipu |
| 17 | Ali |
| 18 | Xunfei |
| 19 | 360 |
| 20 | OpenRouter |
| 21 | AIProxyLibrary |
| 22 | FastGPT |
| 23 | Tencent |
| 24 | Gemini |
| 25 | Moonshot |
| 26 | Zhipu_v4 |
| 27 | Perplexity |
| 31 | LingYiWanWu |
| 33 | Aws |
| 34 | Cohere |
| 35 | MiniMax |
| 36 | SunoAPI |
| 37 | Dify |
| 38 | Jina |
| 40 | SiliconFlow |
| 41 | VertexAi |
| 42 | Mistral |
| 43 | DeepSeek |
| 44 | MokaAI |
| 45 | VolcEngine |
| 46 | BaiduV2 |
| 47 | Xinference |
| 48 | Xai |
| 49 | Coze |
| 50 | Kling |
| 51 | Jimeng |
| 52 | Vidu |
| 53 | Submodel |
| 54 | DoubaoVideo |
| 55 | Sora |
| 56 | Replicate |
| 57 | Codex |

## 接口明细

### GET /api/channel/

- 摘要：获取所有渠道
- 说明：👨‍💼 需要管理员权限（Admin）
- 请求方法：`GET`
- 路径：`/api/channel/`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| p | query / integer / 选填 | 页码 | >= 1 |
| page_size | query / integer / 选填 | 每页条数 | 1 ~ 100 |
| id_sort | query / boolean / 选填 | 是否按 ID 排序 | true / false |
| tag_mode | query / boolean / 选填 | 是否启用标签聚合模式 | true / false |
| status | query / string / 选填 | 状态筛选条件 | 见模块枚举说明 |
| type | query / integer / 选填 | 类型筛选条件 | 见模块枚举说明 |

#### 请求体

- 无请求体。

#### 响应格式

- 已在下方给出字段级响应结构。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 错误信息；成功时为空 | 任意字符串 |
| data.page | integer | 当前页码 | >= 1 |
| data.page_size | integer | 每页条数 | 1 ~ 100 |
| data.total | integer | 总记录数 | >= 0 |
| data.items[] | Channel | 渠道列表（已清除敏感 channel_info） | 数组 |
| data.type_counts | object | 按渠道类型聚合的统计结果 | key 为渠道类型枚举值 |

### POST /api/channel/

- 摘要：添加渠道
- 说明：👨‍💼 需要管理员权限（Admin）
- 请求方法：`POST`
- 路径：`/api/channel/`

#### 路径 / Query 参数

- 无路径参数 / Query 参数。

#### 请求体

- Content-Type：`application/json`
- 请求体结构：`object`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| mode | string | 请求体字段 | single / batch / multi_to_single |
| channel | Channel | 请求体字段 | - |

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### PUT /api/channel/

- 摘要：更新渠道
- 说明：👨‍💼 需要管理员权限（Admin）
- 请求方法：`PUT`
- 路径：`/api/channel/`

#### 路径 / Query 参数

- 无路径参数 / Query 参数。

#### 请求体

- Content-Type：`application/json`
- 请求体结构：`Channel`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| id | integer | 请求体字段 | - |
| name | string | 请求体字段 | - |
| type | integer | 请求体字段 | - |
| status | integer | 请求体字段 | - |
| models | string | 请求体字段 | - |
| groups | string | 请求体字段 | - |
| priority | integer | 请求体字段 | - |
| weight | integer | 请求体字段 | - |
| base_url | string | 请求体字段 | - |
| tag | string | 请求体字段 | - |

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### POST /api/channel/batch

- 摘要：批量删除渠道
- 说明：👨‍💼 需要管理员权限（Admin）
- 请求方法：`POST`
- 路径：`/api/channel/batch`

#### 路径 / Query 参数

- 无路径参数 / Query 参数。

#### 请求体

- Content-Type：`application/json`
- 请求体结构：`object`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| ids | array<integer> | 请求体字段 | - |

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### POST /api/channel/batch/tag

- 摘要：批量设置渠道标签
- 说明：👨‍💼 需要管理员权限（Admin）
- 请求方法：`POST`
- 路径：`/api/channel/batch/tag`

#### 路径 / Query 参数

- 无路径参数 / Query 参数。

#### 请求体

- Content-Type：`application/json`
- 请求体结构：`object`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| ids | array<integer> | 请求体字段 | - |
| tag | string | 请求体字段 | - |

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### POST /api/channel/copy/{id}

- 摘要：复制渠道
- 说明：👨‍💼 需要管理员权限（Admin）
- 请求方法：`POST`
- 路径：`/api/channel/copy/{id}`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| id | path / integer / 必填 | 资源 ID | 整数或字符串 ID |
| suffix | query / string / 选填 | - | - |
| reset_balance | query / boolean / 选填 | - | - |

#### 请求体

- 无请求体。

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### DELETE /api/channel/disabled

- 摘要：删除已禁用渠道
- 说明：👨‍💼 需要管理员权限（Admin）
- 请求方法：`DELETE`
- 路径：`/api/channel/disabled`

#### 路径 / Query 参数

- 无路径参数 / Query 参数。

#### 请求体

- 无请求体。

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### POST /api/channel/fetch_models

- 摘要：获取模型列表
- 说明：👨‍💼 需要管理员权限（Admin）
- 请求方法：`POST`
- 路径：`/api/channel/fetch_models`

#### 路径 / Query 参数

- 无路径参数 / Query 参数。

#### 请求体

- Content-Type：`application/json`
- 请求体结构：`object`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| base_url | string | 请求体字段 | - |
| type | integer | 请求体字段 | - |
| key | string | 请求体字段 | - |

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### GET /api/channel/fetch_models/{id}

- 摘要：获取上游模型列表
- 说明：👨‍💼 需要管理员权限（Admin）
- 请求方法：`GET`
- 路径：`/api/channel/fetch_models/{id}`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| id | path / integer / 必填 | 资源 ID | 整数或字符串 ID |

#### 请求体

- 无请求体。

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### POST /api/channel/fix

- 摘要：修复渠道能力
- 说明：👨‍💼 需要管理员权限（Admin）
- 请求方法：`POST`
- 路径：`/api/channel/fix`

#### 路径 / Query 参数

- 无路径参数 / Query 参数。

#### 请求体

- 无请求体。

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### GET /api/channel/models

- 摘要：获取渠道模型列表
- 说明：👨‍💼 需要管理员权限（Admin）
- 请求方法：`GET`
- 路径：`/api/channel/models`

#### 路径 / Query 参数

- 无路径参数 / Query 参数。

#### 请求体

- 无请求体。

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### GET /api/channel/models_enabled

- 摘要：获取已启用模型列表
- 说明：👨‍💼 需要管理员权限（Admin）
- 请求方法：`GET`
- 路径：`/api/channel/models_enabled`

#### 路径 / Query 参数

- 无路径参数 / Query 参数。

#### 请求体

- 无请求体。

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### POST /api/channel/multi_key/manage

- 摘要：管理多密钥
- 说明：👨‍💼 需要管理员权限（Admin）
- 请求方法：`POST`
- 路径：`/api/channel/multi_key/manage`

#### 路径 / Query 参数

- 无路径参数 / Query 参数。

#### 请求体

- Content-Type：`application/json`
- 请求体结构：`object`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| channel_id | integer | 请求体字段 | - |
| action | string | 请求体字段 | get_key_status / disable_key / enable_key / delete_key / delete_disabled_keys / enable_all_keys / disable_all_keys |
| key_index | integer | 请求体字段 | - |

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### GET /api/channel/search

- 摘要：搜索渠道
- 说明：👨‍💼 需要管理员权限（Admin）
- 请求方法：`GET`
- 路径：`/api/channel/search`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| keyword | query / string / 选填 | 搜索关键字 | 任意字符串 |
| group | query / string / 选填 | - | - |
| model | query / string / 选填 | - | - |

#### 请求体

- 无请求体。

#### 响应格式

- 已在下方给出字段级响应结构。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 错误信息；成功时为空 | 任意字符串 |
| data.items[] | Channel | 搜索结果渠道列表 | 数组 |
| data.total | integer | 搜索结果总数 | >= 0 |
| data.type_counts | object | 按渠道类型聚合的统计结果 | key 为渠道类型枚举值 |

### PUT /api/channel/tag

- 摘要：编辑标签渠道
- 说明：👨‍💼 需要管理员权限（Admin）
- 请求方法：`PUT`
- 路径：`/api/channel/tag`

#### 路径 / Query 参数

- 无路径参数 / Query 参数。

#### 请求体

- Content-Type：`application/json`
- 请求体结构：`object`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| tag | string | 请求体字段 | - |
| new_tag | string | 请求体字段 | - |
| priority | integer | 请求体字段 | - |
| weight | integer | 请求体字段 | - |

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### POST /api/channel/tag/disabled

- 摘要：禁用标签渠道
- 说明：👨‍💼 需要管理员权限（Admin）
- 请求方法：`POST`
- 路径：`/api/channel/tag/disabled`

#### 路径 / Query 参数

- 无路径参数 / Query 参数。

#### 请求体

- Content-Type：`application/json`
- 请求体结构：`object`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| tag | string | 请求体字段 | - |

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### POST /api/channel/tag/enabled

- 摘要：启用标签渠道
- 说明：👨‍💼 需要管理员权限（Admin）
- 请求方法：`POST`
- 路径：`/api/channel/tag/enabled`

#### 路径 / Query 参数

- 无路径参数 / Query 参数。

#### 请求体

- Content-Type：`application/json`
- 请求体结构：`object`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| tag | string | 请求体字段 | - |

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### GET /api/channel/tag/models

- 摘要：获取标签模型
- 说明：👨‍💼 需要管理员权限（Admin）
- 请求方法：`GET`
- 路径：`/api/channel/tag/models`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| tag | query / string / 必填 | - | - |

#### 请求体

- 无请求体。

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### GET /api/channel/test

- 摘要：测试所有渠道
- 说明：👨‍💼 需要管理员权限（Admin）
- 请求方法：`GET`
- 路径：`/api/channel/test`

#### 路径 / Query 参数

- 无路径参数 / Query 参数。

#### 请求体

- 无请求体。

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### GET /api/channel/test/{id}

- 摘要：测试指定渠道
- 说明：👨‍💼 需要管理员权限（Admin）
- 请求方法：`GET`
- 路径：`/api/channel/test/{id}`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| id | path / integer / 必填 | 资源 ID | 整数或字符串 ID |

#### 请求体

- 无请求体。

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### GET /api/channel/update_balance

- 摘要：更新所有渠道余额
- 说明：👨‍💼 需要管理员权限（Admin）
- 请求方法：`GET`
- 路径：`/api/channel/update_balance`

#### 路径 / Query 参数

- 无路径参数 / Query 参数。

#### 请求体

- 无请求体。

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### GET /api/channel/update_balance/{id}

- 摘要：更新指定渠道余额
- 说明：👨‍💼 需要管理员权限（Admin）
- 请求方法：`GET`
- 路径：`/api/channel/update_balance/{id}`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| id | path / integer / 必填 | 资源 ID | 整数或字符串 ID |

#### 请求体

- 无请求体。

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### DELETE /api/channel/{id}

- 摘要：删除渠道
- 说明：👨‍💼 需要管理员权限（Admin）
- 请求方法：`DELETE`
- 路径：`/api/channel/{id}`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| id | path / integer / 必填 | 资源 ID | 整数或字符串 ID |

#### 请求体

- 无请求体。

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### GET /api/channel/{id}

- 摘要：获取指定渠道
- 说明：👨‍💼 需要管理员权限（Admin）
- 请求方法：`GET`
- 路径：`/api/channel/{id}`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| id | path / integer / 必填 | 资源 ID | 整数或字符串 ID |

#### 请求体

- 无请求体。

#### 响应格式

- 已在下方给出字段级响应结构。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 错误信息；成功时为空 | 任意字符串 |
| data | Channel | 单个渠道对象（不含敏感 key） | 对象 |

### POST /api/channel/{id}/key

- 摘要：获取渠道密钥
- 说明：👑 需要超级管理员权限（Root）+ 安全验证
- 请求方法：`POST`
- 路径：`/api/channel/{id}/key`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| id | path / integer / 必填 | 资源 ID | 整数或字符串 ID |

#### 请求体

- 无请求体。

#### 响应格式

- 已在下方给出字段级响应结构。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 成功时通常为“获取成功” | 任意字符串 |
| data.key | string | 渠道完整密钥 | 字符串 |

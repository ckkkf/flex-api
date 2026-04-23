# new-api-main 接口文档维护说明

## 目的

本目录下的 `new-api-main-*.md` 文档用于沉淀 `new-api-main` 项目的接口说明，目标是：

- 按模块拆分
- 统一模板
- 尽量覆盖路径、请求方法、请求格式、响应格式
- 尽量补齐字段含义、取值范围、状态/枚举值说明
- 对 OpenAPI 未覆盖完整的接口，结合 Router / Controller / Model 源码补文档

---

## 主要文件

- `new-api-main-接口文档索引.md`
  - 所有接口文档的总索引
- `new-api-main-api-*.md`
  - 管理面 API 文档
- `new-api-main-api-extra-*.md`
  - OpenAPI 未完整覆盖的补充模块文档
- `new-api-main-relay-*.md`
  - Relay / 兼容协议接口文档
- `new-api-main-relay-extra-*.md`
  - Relay 补充路由文档
- `generate_new_api_docs.py`
  - 文档生成脚本

---

## 文档来源

生成脚本会综合以下来源：

1. `new-api-main/docs/openapi/api.json`
2. `new-api-main/docs/openapi/relay.json`
3. `new-api-main/router/*.go`
4. `new-api-main/controller/*.go`
5. `new-api-main/model/*.go`
6. `new-api-main/common/constants.go`
7. `new-api-main/constant/*.go`

---

## 如何重新生成

在项目根目录执行：

```bash
python3 doc/generate_new_api_docs.py
```

生成后会覆盖现有的 `new-api-main-*.md` 文档。

---

## 生成规则说明

### 1. OpenAPI 优先

如果接口在：

- `new-api-main/docs/openapi/api.json`
- `new-api-main/docs/openapi/relay.json`

中已声明，则优先使用其中的：

- 路径
- 请求方法
- tags / 模块归类
- requestBody / parameters

### 2. 源码补充

如果 OpenAPI 没有完整描述，则从：

- Router
- Controller
- Model

中补齐：

- 补充模块文档
- 请求字段
- 响应字段
- 状态枚举字段

### 3. 统一响应约定

管理面接口通常整理为：

```json
{
  "success": true,
  "message": "",
  "data": {}
}
```

分页接口通常整理为：

```json
{
  "success": true,
  "message": "",
  "data": {
    "page": 1,
    "page_size": 20,
    "total": 100,
    "items": []
  }
}
```
```

Relay 接口通常为：

- 透传上游兼容协议响应
- 不再包裹项目 `ApiResponse`

---

## 哪些内容是“源码推断”

以下情况通常属于整理口径或源码推断：

- OpenAPI 未声明精确 response schema
- Controller 直接返回 `gin.H`
- 同一个接口在不同分支返回结构略有差异
- Relay 接口的响应完全由上游兼容协议决定

这类文档内容一般会使用如下表述：

- “通常为 `ApiResponse<T>` 统一 JSON 包装”
- “已结合源码补充字段级说明”
- “透传上游兼容协议响应”

---

## 推荐维护方式

当 `new-api-main` 更新后，建议按下面顺序维护：

1. 先更新 `new-api-main`
2. 重新执行生成脚本
3. 抽查以下重点文档：
   - 用户登录注册
   - 用户管理
   - 渠道管理
   - 令牌管理
   - 订阅计费
   - 自定义 OAuth 提供商
   - 模型部署
   - Relay Chat / Responses / 视频生成
4. 如果有新增状态字段或枚举值：
   - 先补脚本中的状态枚举表
   - 再重新生成文档

---

## 当前已重点增强的模块

已经做过较多字段级增强的模块包括：

- 用户登录注册
- 用户管理
- 渠道管理
- 令牌管理
- 订阅计费
- 自定义 OAuth 提供商
- 模型部署

这些模块的关键接口已经不只是泛型说明，而是补到了：

- `data.xxx`
- `data.items[]`
- 关键响应对象字段

---

## 后续可继续增强的方向

如果后续还要继续细化，可以优先做：

1. 给更多补充模块接口补全字段级响应
2. 给更多 Query 参数补“取值范围 / 默认值”
3. 把部分 `gin.H` 响应提炼成专门的响应对象章节
4. 为常见错误响应增加统一错误码/错误信息表（如果源码后续形成统一规范）

# 文本补全(Completions) 模块接口文档

- 来源：`new-api-main/docs/openapi/relay.json` + `new-api-main/router/relay-router.go` / `video-router.go`
- OpenAPI 覆盖接口数量：1

## 模块说明

- Relay 接口通常直接透传 OpenAI / Claude / Gemini / 视频平台兼容协议。
- 绝大多数接口需要令牌认证；少数下载类接口支持用户会话或令牌二选一。

## 接口明细

### POST /v1/completions

- 摘要：创建文本补全
- 请求方法：`POST`
- 路径：`/v1/completions`

#### 路径 / Query 参数

- 无路径参数 / Query 参数。

#### 请求体

- Content-Type：`application/json`
- 请求体结构：`CompletionRequest`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| model | string | 请求体字段 | - |
| prompt | object | 请求体字段 | - |
| max_tokens | integer | 请求体字段 | - |
| temperature | number | 请求体字段 | - |
| top_p | number | 请求体字段 | - |
| n | integer | 请求体字段 | - |
| stream | boolean | 请求体字段 | - |
| stop | object | 请求体字段 | - |
| suffix | string | 请求体字段 | - |
| echo | boolean | 请求体字段 | - |

#### 响应格式

- 透传上游兼容协议响应，不再套用后台 `ApiResponse` 外层。

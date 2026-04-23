# OpenAI格式(Responses) 模块接口文档

- 来源：`new-api-main/docs/openapi/relay.json` + `new-api-main/router/relay-router.go` / `video-router.go`
- OpenAPI 覆盖接口数量：2

## 模块说明

- Relay 接口通常直接透传 OpenAI / Claude / Gemini / 视频平台兼容协议。
- 绝大多数接口需要令牌认证；少数下载类接口支持用户会话或令牌二选一。

## 接口明细

### POST /v1/responses

- 摘要：创建响应 (OpenAI Responses API)
- 请求方法：`POST`
- 路径：`/v1/responses`

#### 路径 / Query 参数

- 无路径参数 / Query 参数。

#### 请求体

- Content-Type：`application/json`
- 请求体结构：`ResponsesRequest`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| model | string | 请求体字段 | - |
| input | object | 请求体字段 | - |
| instructions | string | 请求体字段 | - |
| max_output_tokens | integer | 请求体字段 | - |
| temperature | number | 请求体字段 | - |
| top_p | number | 请求体字段 | - |
| stream | boolean | 请求体字段 | - |
| tools | array<object> | 请求体字段 | - |
| tool_choice | object | 请求体字段 | - |
| reasoning | object | 请求体字段 | - |
| previous_response_id | string | 请求体字段 | - |
| truncation | string | 请求体字段 | auto / disabled |

#### 响应格式

- 透传上游兼容协议响应，不再套用后台 `ApiResponse` 外层。

### POST /v1/responses/compact

- 摘要：压缩对话 (OpenAI Responses API)
- 请求方法：`POST`
- 路径：`/v1/responses/compact`

#### 路径 / Query 参数

- 无路径参数 / Query 参数。

#### 请求体

- Content-Type：`application/json`
- 请求体结构：`ResponsesCompactionRequest`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| model | string | 请求体字段 | - |
| input | object | 请求体字段 | - |
| instructions | string | 请求体字段 | - |
| previous_response_id | string | 请求体字段 | - |

#### 响应格式

- 透传上游兼容协议响应，不再套用后台 `ApiResponse` 外层。

# Claude格式(Messages) 模块接口文档

- 来源：`new-api-main/docs/openapi/relay.json` + `new-api-main/router/relay-router.go` / `video-router.go`
- OpenAPI 覆盖接口数量：1

## 模块说明

- Relay 接口通常直接透传 OpenAI / Claude / Gemini / 视频平台兼容协议。
- 绝大多数接口需要令牌认证；少数下载类接口支持用户会话或令牌二选一。

## 接口明细

### POST /v1/messages

- 摘要：Claude 聊天
- 请求方法：`POST`
- 路径：`/v1/messages`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| anthropic-version | header / string / 必填 | Anthropic API 版本 | - |
| x-api-key | header / string / 选填 | Anthropic API Key (可选，也可使用 Bearer Token) | - |

#### 请求体

- Content-Type：`application/json`
- 请求体结构：`ClaudeRequest`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| model | string | 请求体字段 | - |
| messages | array<ClaudeMessage> | 请求体字段 | - |
| system | object | 请求体字段 | - |
| cache_control | object | 请求体字段 | - |
| inference_geo | string | 请求体字段 | - |
| max_tokens | integer | 请求体字段 | - |
| temperature | number | 请求体字段 | - |
| top_p | number | 请求体字段 | - |
| top_k | integer | 请求体字段 | - |
| stream | boolean | 请求体字段 | - |
| stop_sequences | array<string> | 请求体字段 | - |
| tools | array<object> | 请求体字段 | - |
| tool_choice | object | 请求体字段 | - |
| thinking | object | 请求体字段 | - |
| context_management | object | 请求体字段 | - |
| output_config | object | 请求体字段 | - |
| output_format | object | 请求体字段 | - |
| container | object | 请求体字段 | - |
| mcp_servers | array<object> | 请求体字段 | - |
| metadata | object | 请求体字段 | - |
| speed | string | 请求体字段 | standard / fast |
| service_tier | string | 请求体字段 | auto / standard_only |

#### 响应格式

- 透传上游兼容协议响应，不再套用后台 `ApiResponse` 外层。

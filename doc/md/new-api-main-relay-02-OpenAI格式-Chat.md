# OpenAI格式(Chat) 模块接口文档

- 来源：`new-api-main/docs/openapi/relay.json` + `new-api-main/router/relay-router.go` / `video-router.go`
- OpenAPI 覆盖接口数量：1

## 模块说明

- Relay 接口通常直接透传 OpenAI / Claude / Gemini / 视频平台兼容协议。
- 绝大多数接口需要令牌认证；少数下载类接口支持用户会话或令牌二选一。

## 路由补充

- `POST /pg/chat/completions`：Playground 聊天补全

## 接口明细

### POST /v1/chat/completions

- 摘要：创建聊天对话
- 请求方法：`POST`
- 路径：`/v1/chat/completions`

#### 路径 / Query 参数

- 无路径参数 / Query 参数。

#### 请求体

- Content-Type：`application/json`
- 请求体结构：`ChatCompletionRequest`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| model | string | 请求体字段 | - |
| messages | array<Message> | 请求体字段 | - |
| temperature | number | 请求体字段 | - |
| top_p | number | 请求体字段 | - |
| n | integer | 请求体字段 | - |
| stream | boolean | 请求体字段 | - |
| stream_options | object | 请求体字段 | - |
| stop | object | 请求体字段 | - |
| max_tokens | integer | 请求体字段 | - |
| max_completion_tokens | integer | 请求体字段 | - |
| presence_penalty | number | 请求体字段 | - |
| frequency_penalty | number | 请求体字段 | - |
| logit_bias | object | 请求体字段 | - |
| user | string | 请求体字段 | - |
| tools | array<Tool> | 请求体字段 | - |
| tool_choice | object | 请求体字段 | - |
| response_format | ResponseFormat | 请求体字段 | - |
| seed | integer | 请求体字段 | - |
| reasoning_effort | string | 请求体字段 | low / medium / high |
| modalities | array<string> | 请求体字段 | - |
| audio | object | 请求体字段 | - |

#### 响应格式

- 透传上游兼容协议响应，不再套用后台 `ApiResponse` 外层。

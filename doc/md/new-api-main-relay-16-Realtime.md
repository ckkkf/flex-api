# Realtime 模块接口文档

- 来源：`new-api-main/docs/openapi/relay.json` + `new-api-main/router/relay-router.go` / `video-router.go`
- OpenAPI 覆盖接口数量：1

## 模块说明

- Relay 接口通常直接透传 OpenAI / Claude / Gemini / 视频平台兼容协议。
- 绝大多数接口需要令牌认证；少数下载类接口支持用户会话或令牌二选一。

## 接口明细

### GET /v1/realtime

- 摘要：实时 WebSocket 连接
- 请求方法：`GET`
- 路径：`/v1/realtime`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| model | query / string / 选填 | 要使用的模型 | - |

#### 请求体

- 无请求体。

#### 响应格式

- 透传上游兼容协议响应，不再套用后台 `ApiResponse` 外层。

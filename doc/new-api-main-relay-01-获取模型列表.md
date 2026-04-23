# 获取模型列表 模块接口文档

- 来源：`new-api-main/docs/openapi/relay.json` + `new-api-main/router/relay-router.go` / `video-router.go`
- OpenAPI 覆盖接口数量：2

## 模块说明

- Relay 接口通常直接透传 OpenAI / Claude / Gemini / 视频平台兼容协议。
- 绝大多数接口需要令牌认证；少数下载类接口支持用户会话或令牌二选一。

## 路由补充

- `GET /v1/models/{model}`：获取指定模型详情
- `GET /v1beta/openai/models`：Gemini OpenAI 兼容模型列表

## 接口明细

### GET /v1/models

- 摘要：获取模型列表
- 请求方法：`GET`
- 路径：`/v1/models`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| key | query / string / 选填 | Google API Key (用于 Gemini 格式) | - |
| x-api-key | header / string / 选填 | Anthropic API Key (用于 Claude 格式) | - |
| anthropic-version | header / string / 选填 | Anthropic API 版本 | - |
| x-goog-api-key | header / string / 选填 | Google API Key (用于 Gemini 格式) | - |

#### 请求体

- 无请求体。

#### 响应格式

- 透传上游兼容协议响应，不再套用后台 `ApiResponse` 外层。

### GET /v1beta/models

- 摘要：Gemini 格式获取
- 请求方法：`GET`
- 路径：`/v1beta/models`

#### 路径 / Query 参数

- 无路径参数 / Query 参数。

#### 请求体

- 无请求体。

#### 响应格式

- 透传上游兼容协议响应，不再套用后台 `ApiResponse` 外层。

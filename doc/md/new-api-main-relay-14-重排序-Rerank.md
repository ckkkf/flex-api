# 重排序(Rerank) 模块接口文档

- 来源：`new-api-main/docs/openapi/relay.json` + `new-api-main/router/relay-router.go` / `video-router.go`
- OpenAPI 覆盖接口数量：1

## 模块说明

- Relay 接口通常直接透传 OpenAI / Claude / Gemini / 视频平台兼容协议。
- 绝大多数接口需要令牌认证；少数下载类接口支持用户会话或令牌二选一。

## 接口明细

### POST /v1/rerank

- 摘要：文档重排序
- 请求方法：`POST`
- 路径：`/v1/rerank`

#### 路径 / Query 参数

- 无路径参数 / Query 参数。

#### 请求体

- Content-Type：`application/json`
- 请求体结构：`RerankRequest`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| model | string | 请求体字段 | - |
| query | string | 请求体字段 | - |
| documents | array<object> | 请求体字段 | - |
| top_n | integer | 请求体字段 | - |
| return_documents | boolean | 请求体字段 | - |

#### 响应格式

- 透传上游兼容协议响应，不再套用后台 `ApiResponse` 外层。

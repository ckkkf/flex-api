# 未实现/Fine-tunes 模块接口文档

- 来源：`new-api-main/docs/openapi/relay.json` + `new-api-main/router/relay-router.go` / `video-router.go`
- OpenAPI 覆盖接口数量：5

## 模块说明

- Relay 接口通常直接透传 OpenAI / Claude / Gemini / 视频平台兼容协议。
- 绝大多数接口需要令牌认证；少数下载类接口支持用户会话或令牌二选一。

## 接口明细

### GET /v1/fine-tunes

- 摘要：列出微调任务 (未实现)
- 请求方法：`GET`
- 路径：`/v1/fine-tunes`

#### 路径 / Query 参数

- 无路径参数 / Query 参数。

#### 请求体

- 无请求体。

#### 响应格式

- 透传上游兼容协议响应，不再套用后台 `ApiResponse` 外层。

### POST /v1/fine-tunes

- 摘要：创建微调任务 (未实现)
- 请求方法：`POST`
- 路径：`/v1/fine-tunes`

#### 路径 / Query 参数

- 无路径参数 / Query 参数。

#### 请求体

- Content-Type：`application/json`
- 请求体结构：`object`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| (body) | object | 请求体 | - |

#### 响应格式

- 透传上游兼容协议响应，不再套用后台 `ApiResponse` 外层。

### GET /v1/fine-tunes/{fine_tune_id}

- 摘要：获取微调任务详情 (未实现)
- 请求方法：`GET`
- 路径：`/v1/fine-tunes/{fine_tune_id}`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| fine_tune_id | path / string / 必填 | 微调任务 ID | 字符串 |

#### 请求体

- 无请求体。

#### 响应格式

- 透传上游兼容协议响应，不再套用后台 `ApiResponse` 外层。

### POST /v1/fine-tunes/{fine_tune_id}/cancel

- 摘要：取消微调任务 (未实现)
- 请求方法：`POST`
- 路径：`/v1/fine-tunes/{fine_tune_id}/cancel`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| fine_tune_id | path / string / 必填 | 微调任务 ID | 字符串 |

#### 请求体

- 无请求体。

#### 响应格式

- 透传上游兼容协议响应，不再套用后台 `ApiResponse` 外层。

### GET /v1/fine-tunes/{fine_tune_id}/events

- 摘要：获取微调任务事件 (未实现)
- 请求方法：`GET`
- 路径：`/v1/fine-tunes/{fine_tune_id}/events`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| fine_tune_id | path / string / 必填 | 微调任务 ID | 字符串 |

#### 请求体

- 无请求体。

#### 响应格式

- 透传上游兼容协议响应，不再套用后台 `ApiResponse` 外层。

# 视频生成 模块接口文档

- 来源：`new-api-main/docs/openapi/relay.json` + `new-api-main/router/relay-router.go` / `video-router.go`
- OpenAPI 覆盖接口数量：2

## 模块说明

- Relay 接口通常直接透传 OpenAI / Claude / Gemini / 视频平台兼容协议。
- 绝大多数接口需要令牌认证；少数下载类接口支持用户会话或令牌二选一。

## 接口明细

### POST /v1/video/generations

- 摘要：创建视频生成任务
- 请求方法：`POST`
- 路径：`/v1/video/generations`

#### 路径 / Query 参数

- 无路径参数 / Query 参数。

#### 请求体

- Content-Type：`application/json`
- 请求体结构：`VideoRequest`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| model | string | 请求体字段 | - |
| prompt | string | 请求体字段 | - |
| image | string | 请求体字段 | - |
| duration | number | 请求体字段 | - |
| width | integer | 请求体字段 | - |
| height | integer | 请求体字段 | - |
| fps | integer | 请求体字段 | - |
| seed | integer | 请求体字段 | - |
| n | integer | 请求体字段 | - |
| response_format | string | 请求体字段 | - |
| user | string | 请求体字段 | - |
| metadata | object | 请求体字段 | - |

#### 响应格式

- 透传上游兼容协议响应，不再套用后台 `ApiResponse` 外层。

### GET /v1/video/generations/{task_id}

- 摘要：获取视频生成任务状态
- 请求方法：`GET`
- 路径：`/v1/video/generations/{task_id}`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| task_id | path / string / 必填 | 任务 ID | 字符串 |

#### 请求体

- 无请求体。

#### 响应格式

- 透传上游兼容协议响应，不再套用后台 `ApiResponse` 外层。

# 未实现/Files 模块接口文档

- 来源：`new-api-main/docs/openapi/relay.json` + `new-api-main/router/relay-router.go` / `video-router.go`
- OpenAPI 覆盖接口数量：5

## 模块说明

- Relay 接口通常直接透传 OpenAI / Claude / Gemini / 视频平台兼容协议。
- 绝大多数接口需要令牌认证；少数下载类接口支持用户会话或令牌二选一。

## 接口明细

### GET /v1/files

- 摘要：列出文件 (未实现)
- 请求方法：`GET`
- 路径：`/v1/files`

#### 路径 / Query 参数

- 无路径参数 / Query 参数。

#### 请求体

- 无请求体。

#### 响应格式

- 透传上游兼容协议响应，不再套用后台 `ApiResponse` 外层。

### POST /v1/files

- 摘要：上传文件 (未实现)
- 请求方法：`POST`
- 路径：`/v1/files`

#### 路径 / Query 参数

- 无路径参数 / Query 参数。

#### 请求体

- Content-Type：`multipart/form-data`
- 请求体结构：`object`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| file | string | 请求体字段 | - |
| purpose | string | 请求体字段 | - |

#### 响应格式

- 透传上游兼容协议响应，不再套用后台 `ApiResponse` 外层。

### DELETE /v1/files/{file_id}

- 摘要：删除文件 (未实现)
- 请求方法：`DELETE`
- 路径：`/v1/files/{file_id}`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| file_id | path / string / 必填 | 文件 ID | 字符串 |

#### 请求体

- 无请求体。

#### 响应格式

- 透传上游兼容协议响应，不再套用后台 `ApiResponse` 外层。

### GET /v1/files/{file_id}

- 摘要：获取文件信息 (未实现)
- 请求方法：`GET`
- 路径：`/v1/files/{file_id}`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| file_id | path / string / 必填 | 文件 ID | 字符串 |

#### 请求体

- 无请求体。

#### 响应格式

- 透传上游兼容协议响应，不再套用后台 `ApiResponse` 外层。

### GET /v1/files/{file_id}/content

- 摘要：获取文件内容 (未实现)
- 请求方法：`GET`
- 路径：`/v1/files/{file_id}/content`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| file_id | path / string / 必填 | 文件 ID | 字符串 |

#### 请求体

- 无请求体。

#### 响应格式

- 透传上游兼容协议响应，不再套用后台 `ApiResponse` 外层。

# 中继-Suno 模块接口文档

- 来源：`new-api-main/router/relay-router.go`
- 接口数量：3

## 模块说明

- 当前文档根据路由层整理，响应主要透传上游任务创建与查询结果。

## 接口明细

### POST /suno/submit/{action}

- 摘要：提交 Suno 任务
- 请求方法：`POST`
- 路径：`/suno/submit/{action}`

#### 请求格式

- 以 JSON 或 multipart/form-data 为主，具体取决于上游兼容协议。

#### 响应格式

- 透传上游兼容协议响应，不再套用后台 `ApiResponse` 外层。

### POST /suno/fetch

- 摘要：查询 Suno 任务
- 请求方法：`POST`
- 路径：`/suno/fetch`

#### 请求格式

- 以 JSON 或 multipart/form-data 为主，具体取决于上游兼容协议。

#### 响应格式

- 透传上游兼容协议响应，不再套用后台 `ApiResponse` 外层。

### GET /suno/fetch/{id}

- 摘要：查询 Suno 任务(GET)
- 请求方法：`GET`
- 路径：`/suno/fetch/{id}`

#### 请求格式

- 以 JSON 或 multipart/form-data 为主，具体取决于上游兼容协议。

#### 响应格式

- 透传上游兼容协议响应，不再套用后台 `ApiResponse` 外层。

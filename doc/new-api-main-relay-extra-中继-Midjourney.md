# 中继-Midjourney 模块接口文档

- 来源：`new-api-main/router/relay-router.go`
- 接口数量：17

## 模块说明

- 当前文档根据路由层整理，响应主要透传上游任务创建与查询结果。

## 接口明细

### GET /mj/image/{id}

- 摘要：获取 Midjourney 图片
- 请求方法：`GET`
- 路径：`/mj/image/{id}`

#### 请求格式

- 以 JSON 或 multipart/form-data 为主，具体取决于上游兼容协议。

#### 响应格式

- 透传上游兼容协议响应，不再套用后台 `ApiResponse` 外层。

### POST /mj/submit/action

- 摘要：提交 Midjourney 动作任务
- 请求方法：`POST`
- 路径：`/mj/submit/action`

#### 请求格式

- 以 JSON 或 multipart/form-data 为主，具体取决于上游兼容协议。

#### 响应格式

- 透传上游兼容协议响应，不再套用后台 `ApiResponse` 外层。

### POST /mj/submit/shorten

- 摘要：提交 Midjourney shorten 任务
- 请求方法：`POST`
- 路径：`/mj/submit/shorten`

#### 请求格式

- 以 JSON 或 multipart/form-data 为主，具体取决于上游兼容协议。

#### 响应格式

- 透传上游兼容协议响应，不再套用后台 `ApiResponse` 外层。

### POST /mj/submit/modal

- 摘要：提交 Midjourney modal 任务
- 请求方法：`POST`
- 路径：`/mj/submit/modal`

#### 请求格式

- 以 JSON 或 multipart/form-data 为主，具体取决于上游兼容协议。

#### 响应格式

- 透传上游兼容协议响应，不再套用后台 `ApiResponse` 外层。

### POST /mj/submit/imagine

- 摘要：提交 Midjourney imagine 任务
- 请求方法：`POST`
- 路径：`/mj/submit/imagine`

#### 请求格式

- 以 JSON 或 multipart/form-data 为主，具体取决于上游兼容协议。

#### 响应格式

- 透传上游兼容协议响应，不再套用后台 `ApiResponse` 外层。

### POST /mj/submit/change

- 摘要：提交 Midjourney change 任务
- 请求方法：`POST`
- 路径：`/mj/submit/change`

#### 请求格式

- 以 JSON 或 multipart/form-data 为主，具体取决于上游兼容协议。

#### 响应格式

- 透传上游兼容协议响应，不再套用后台 `ApiResponse` 外层。

### POST /mj/submit/simple-change

- 摘要：提交 Midjourney simple-change 任务
- 请求方法：`POST`
- 路径：`/mj/submit/simple-change`

#### 请求格式

- 以 JSON 或 multipart/form-data 为主，具体取决于上游兼容协议。

#### 响应格式

- 透传上游兼容协议响应，不再套用后台 `ApiResponse` 外层。

### POST /mj/submit/describe

- 摘要：提交 Midjourney describe 任务
- 请求方法：`POST`
- 路径：`/mj/submit/describe`

#### 请求格式

- 以 JSON 或 multipart/form-data 为主，具体取决于上游兼容协议。

#### 响应格式

- 透传上游兼容协议响应，不再套用后台 `ApiResponse` 外层。

### POST /mj/submit/blend

- 摘要：提交 Midjourney blend 任务
- 请求方法：`POST`
- 路径：`/mj/submit/blend`

#### 请求格式

- 以 JSON 或 multipart/form-data 为主，具体取决于上游兼容协议。

#### 响应格式

- 透传上游兼容协议响应，不再套用后台 `ApiResponse` 外层。

### POST /mj/submit/edits

- 摘要：提交 Midjourney edits 任务
- 请求方法：`POST`
- 路径：`/mj/submit/edits`

#### 请求格式

- 以 JSON 或 multipart/form-data 为主，具体取决于上游兼容协议。

#### 响应格式

- 透传上游兼容协议响应，不再套用后台 `ApiResponse` 外层。

### POST /mj/submit/video

- 摘要：提交 Midjourney video 任务
- 请求方法：`POST`
- 路径：`/mj/submit/video`

#### 请求格式

- 以 JSON 或 multipart/form-data 为主，具体取决于上游兼容协议。

#### 响应格式

- 透传上游兼容协议响应，不再套用后台 `ApiResponse` 外层。

### GET /mj/task/{id}/fetch

- 摘要：获取 Midjourney 任务状态
- 请求方法：`GET`
- 路径：`/mj/task/{id}/fetch`

#### 请求格式

- 以 JSON 或 multipart/form-data 为主，具体取决于上游兼容协议。

#### 响应格式

- 透传上游兼容协议响应，不再套用后台 `ApiResponse` 外层。

### GET /mj/task/{id}/image-seed

- 摘要：获取 Midjourney image seed
- 请求方法：`GET`
- 路径：`/mj/task/{id}/image-seed`

#### 请求格式

- 以 JSON 或 multipart/form-data 为主，具体取决于上游兼容协议。

#### 响应格式

- 透传上游兼容协议响应，不再套用后台 `ApiResponse` 外层。

### POST /mj/task/list-by-condition

- 摘要：按条件查询 Midjourney 任务
- 请求方法：`POST`
- 路径：`/mj/task/list-by-condition`

#### 请求格式

- 以 JSON 或 multipart/form-data 为主，具体取决于上游兼容协议。

#### 响应格式

- 透传上游兼容协议响应，不再套用后台 `ApiResponse` 外层。

### POST /mj/insight-face/swap

- 摘要：Midjourney 人脸替换
- 请求方法：`POST`
- 路径：`/mj/insight-face/swap`

#### 请求格式

- 以 JSON 或 multipart/form-data 为主，具体取决于上游兼容协议。

#### 响应格式

- 透传上游兼容协议响应，不再套用后台 `ApiResponse` 外层。

### POST /mj/submit/upload-discord-images

- 摘要：上传 Discord 图片
- 请求方法：`POST`
- 路径：`/mj/submit/upload-discord-images`

#### 请求格式

- 以 JSON 或 multipart/form-data 为主，具体取决于上游兼容协议。

#### 响应格式

- 透传上游兼容协议响应，不再套用后台 `ApiResponse` 外层。

### GET /:mode/mj/image/{id}

- 摘要：带 mode 的 Midjourney 图片获取
- 请求方法：`GET`
- 路径：`/:mode/mj/image/{id}`

#### 请求格式

- 以 JSON 或 multipart/form-data 为主，具体取决于上游兼容协议。

#### 响应格式

- 透传上游兼容协议响应，不再套用后台 `ApiResponse` 外层。

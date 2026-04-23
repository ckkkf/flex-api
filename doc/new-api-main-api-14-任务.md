# 任务 模块接口文档

- 来源：`new-api-main/docs/openapi/api.json`
- 接口数量：4

## 模块说明

- 本模块文档按“接口总览 → 核心数据对象 → 状态枚举 → 接口明细”的固定模板整理。
- 若 OpenAPI 缺失精确响应 schema，则结合源码统一返回方式补充说明。

## 统一响应结构

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

## 分页结构

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| page | integer | 当前页码 | >= 1 |
| page_size | integer | 每页条数 | 1 ~ 100（默认值由后端决定） |
| total | integer | 总记录数 | >= 0 |
| items | array | 当前页数据列表 | 数组 |

## 核心数据对象：Task

- 来源：`new-api-main/model/task.go`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| id | int64 | - | - |
| created_at | int64 | - | - |
| updated_at | int64 | - | - |
| task_id | string | 第三方id，不一定有/ song id\ Task id | - |
| platform | constant.TaskPlatform | 平台 | suno=Suno 任务；mj=Midjourney 任务 |
| user_id | int | - | - |
| group | string | 修正计费用 | - |
| channel_id | int | - | - |
| quota | int | - | - |
| action | string | 任务类型, song, lyrics, description-mode | - |
| status | TaskStatus | 任务状态 | NOT_START=未开始；SUBMITTED=已提交；QUEUED=排队中；IN_PROGRESS=处理中；FAILURE=失败；SUCCESS=成功；UNKNOWN=未知 |
| fail_reason | string | - | - |
| submit_time | int64 | - | - |
| start_time | int64 | - | - |
| finish_time | int64 | - | - |
| progress | string | - | - |
| properties | Properties | - | - |
| username | string | - | - |
| private_data | TaskPrivateData | - | - |
| data | json.RawMessage | - | - |

## 核心数据对象：Midjourney

- 来源：`new-api-main/model/midjourney.go`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| id | int | - | - |
| code | int | - | - |
| user_id | int | - | - |
| action | string | - | - |
| mj_id | string | - | - |
| prompt | string | - | - |
| prompt_en | string | - | - |
| description | string | - | - |
| state | string | - | - |
| submit_time | int64 | - | - |
| start_time | int64 | - | - |
| finish_time | int64 | - | - |
| image_url | string | - | - |
| video_url | string | - | - |
| video_urls | string | - | - |
| status | string | - | NOT_START=未开始；SUBMITTED=已提交；QUEUED=排队中；IN_PROGRESS=处理中；FAILURE=失败；SUCCESS=成功；UNKNOWN=未知 |
| progress | string | - | - |
| fail_reason | string | - | - |
| channel_id | int | - | - |
| quota | int | - | - |
| buttons | string | - | - |
| properties | string | - | - |

## 状态/枚举字段说明

### status

| 取值 | 含义 |
|---|---|
| NOT_START | 未开始 |
| SUBMITTED | 已提交 |
| QUEUED | 排队中 |
| IN_PROGRESS | 处理中 |
| FAILURE | 失败 |
| SUCCESS | 成功 |
| UNKNOWN | 未知 |

### platform

| 取值 | 含义 |
|---|---|
| suno | Suno 任务 |
| mj | Midjourney 任务 |

## 接口明细

### GET /api/mj/

- 摘要：获取所有Midjourney任务
- 说明：👨‍💼 需要管理员权限（Admin）
- 请求方法：`GET`
- 路径：`/api/mj/`

#### 路径 / Query 参数

- 无路径参数 / Query 参数。

#### 请求体

- 无请求体。

#### 响应格式

- 通常为 `ApiResponse<PageInfo<T>>`。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### GET /api/mj/self

- 摘要：获取个人Midjourney任务
- 说明：🔐 需要登录（User权限）
- 请求方法：`GET`
- 路径：`/api/mj/self`

#### 路径 / Query 参数

- 无路径参数 / Query 参数。

#### 请求体

- 无请求体。

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### GET /api/task/

- 摘要：获取所有任务
- 说明：👨‍💼 需要管理员权限（Admin）
- 请求方法：`GET`
- 路径：`/api/task/`

#### 路径 / Query 参数

- 无路径参数 / Query 参数。

#### 请求体

- 无请求体。

#### 响应格式

- 通常为 `ApiResponse<PageInfo<T>>`。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### GET /api/task/self

- 摘要：获取个人任务
- 说明：🔐 需要登录（User权限）
- 请求方法：`GET`
- 路径：`/api/task/self`

#### 路径 / Query 参数

- 无路径参数 / Query 参数。

#### 请求体

- 无请求体。

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

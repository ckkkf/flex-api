# 兑换码 模块接口文档

- 来源：`new-api-main/docs/openapi/api.json`
- 接口数量：7

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

## 核心数据对象：Redemption

- 来源：`new-api-main/model/redemption.go`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| id | int | - | - |
| user_id | int | - | - |
| key | string | - | - |
| status | int | - | 1=可用；2=禁用；3=已使用 |
| name | string | - | - |
| quota | int | - | - |
| created_time | int64 | - | - |
| redeemed_time | int64 | - | - |
| count | int | only for api request | - |
| used_user_id | int | - | - |
| deleted_at | gorm.DeletedAt | - | - |
| expired_time | int64 | 过期时间，0 表示不过期 | - |

## 状态/枚举字段说明

### status

| 取值 | 含义 |
|---|---|
| 1 | 可用 |
| 2 | 禁用 |
| 3 | 已使用 |

## 接口明细

### GET /api/redemption/

- 摘要：获取所有兑换码
- 说明：👨‍💼 需要管理员权限（Admin）
- 请求方法：`GET`
- 路径：`/api/redemption/`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| p | query / integer / 选填 | 页码 | >= 1 |
| page_size | query / integer / 选填 | 每页条数 | 1 ~ 100 |

#### 请求体

- 无请求体。

#### 响应格式

- 通常为 `ApiResponse<PageInfo<T>>`。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### POST /api/redemption/

- 摘要：创建兑换码
- 说明：👨‍💼 需要管理员权限（Admin）
- 请求方法：`POST`
- 路径：`/api/redemption/`

#### 路径 / Query 参数

- 无路径参数 / Query 参数。

#### 请求体

- Content-Type：`application/json`
- 请求体结构：`Redemption`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| id | integer | 请求体字段 | - |
| name | string | 请求体字段 | - |
| key | string | 请求体字段 | - |
| status | integer | 请求体字段 | - |
| quota | integer | 请求体字段 | - |
| created_time | integer | 请求体字段 | - |
| redeemed_time | integer | 请求体字段 | - |

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### PUT /api/redemption/

- 摘要：更新兑换码
- 说明：👨‍💼 需要管理员权限（Admin）
- 请求方法：`PUT`
- 路径：`/api/redemption/`

#### 路径 / Query 参数

- 无路径参数 / Query 参数。

#### 请求体

- Content-Type：`application/json`
- 请求体结构：`Redemption`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| id | integer | 请求体字段 | - |
| name | string | 请求体字段 | - |
| key | string | 请求体字段 | - |
| status | integer | 请求体字段 | - |
| quota | integer | 请求体字段 | - |
| created_time | integer | 请求体字段 | - |
| redeemed_time | integer | 请求体字段 | - |

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### DELETE /api/redemption/invalid

- 摘要：删除无效兑换码
- 说明：👨‍💼 需要管理员权限（Admin）
- 请求方法：`DELETE`
- 路径：`/api/redemption/invalid`

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

### GET /api/redemption/search

- 摘要：搜索兑换码
- 说明：👨‍💼 需要管理员权限（Admin）
- 请求方法：`GET`
- 路径：`/api/redemption/search`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| keyword | query / string / 选填 | 搜索关键字 | 任意字符串 |

#### 请求体

- 无请求体。

#### 响应格式

- 通常为 `ApiResponse<PageInfo<T>>`。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### DELETE /api/redemption/{id}

- 摘要：删除兑换码
- 说明：👨‍💼 需要管理员权限（Admin）
- 请求方法：`DELETE`
- 路径：`/api/redemption/{id}`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| id | path / integer / 必填 | 资源 ID | 整数或字符串 ID |

#### 请求体

- 无请求体。

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### GET /api/redemption/{id}

- 摘要：获取指定兑换码
- 说明：👨‍💼 需要管理员权限（Admin）
- 请求方法：`GET`
- 路径：`/api/redemption/{id}`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| id | path / integer / 必填 | 资源 ID | 整数或字符串 ID |

#### 请求体

- 无请求体。

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

# 令牌管理 模块接口文档

- 来源：`new-api-main/docs/openapi/api.json`
- 接口数量：8

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

## 核心数据对象：Token

- 来源：`new-api-main/model/token.go`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| id | int | - | - |
| user_id | int | - | - |
| key | string | - | - |
| status | int | - | 1=启用；2=禁用；3=已过期；4=额度耗尽 |
| name | string | - | - |
| created_time | int64 | - | - |
| accessed_time | int64 | - | - |
| expired_time | int64 | -1 means never expired | - |
| remain_quota | int | - | - |
| unlimited_quota | bool | - | - |
| model_limits_enabled | bool | - | - |
| model_limits | string | - | - |
| allow_ips | *string | - | - |
| used_quota | int | used quota | - |
| group | string | - | - |
| cross_group_retry | bool | 跨分组重试，仅auto分组有效 | - |
| deleted_at | gorm.DeletedAt | - | - |

## 状态/枚举字段说明

### status

| 取值 | 含义 |
|---|---|
| 1 | 启用 |
| 2 | 禁用 |
| 3 | 已过期 |
| 4 | 额度耗尽 |

## 接口明细

### GET /api/token/

- 摘要：获取所有令牌
- 说明：🔐 需要登录（User权限）
- 请求方法：`GET`
- 路径：`/api/token/`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| p | query / integer / 选填 | 页码 | >= 1 |
| page_size | query / integer / 选填 | 每页条数 | 1 ~ 100 |

#### 请求体

- 无请求体。

#### 响应格式

- 已在下方给出字段级响应结构。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 错误信息；成功时为空 | 任意字符串 |
| data.page | integer | 当前页码 | >= 1 |
| data.page_size | integer | 每页条数 | 1 ~ 100 |
| data.total | integer | 总记录数 | >= 0 |
| data.items[] | Token | 脱敏后的令牌列表；key 字段为掩码值 | 数组 |

### POST /api/token/

- 摘要：创建令牌
- 说明：🔐 需要登录（User权限）
- 请求方法：`POST`
- 路径：`/api/token/`

#### 路径 / Query 参数

- 无路径参数 / Query 参数。

#### 请求体

- Content-Type：`application/json`
- 请求体结构：`Token`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| id | integer | 请求体字段 | - |
| user_id | integer | 请求体字段 | - |
| name | string | 请求体字段 | - |
| key | string | 请求体字段 | - |
| status | integer | 请求体字段 | - |
| expired_time | integer | 请求体字段 | - |
| remain_quota | integer | 请求体字段 | - |
| unlimited_quota | boolean | 请求体字段 | - |

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### PUT /api/token/

- 摘要：更新令牌
- 说明：🔐 需要登录（User权限）
- 请求方法：`PUT`
- 路径：`/api/token/`

#### 路径 / Query 参数

- 无路径参数 / Query 参数。

#### 请求体

- Content-Type：`application/json`
- 请求体结构：`Token`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| id | integer | 请求体字段 | - |
| user_id | integer | 请求体字段 | - |
| name | string | 请求体字段 | - |
| key | string | 请求体字段 | - |
| status | integer | 请求体字段 | - |
| expired_time | integer | 请求体字段 | - |
| remain_quota | integer | 请求体字段 | - |
| unlimited_quota | boolean | 请求体字段 | - |

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### POST /api/token/batch

- 摘要：批量删除令牌
- 说明：🔐 需要登录（User权限）
- 请求方法：`POST`
- 路径：`/api/token/batch`

#### 路径 / Query 参数

- 无路径参数 / Query 参数。

#### 请求体

- Content-Type：`application/json`
- 请求体结构：`object`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| ids | array<integer> | 请求体字段 | - |

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### GET /api/token/search

- 摘要：搜索令牌
- 说明：🔐 需要登录（User权限）
- 请求方法：`GET`
- 路径：`/api/token/search`

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

### DELETE /api/token/{id}

- 摘要：删除令牌
- 说明：🔐 需要登录（User权限）
- 请求方法：`DELETE`
- 路径：`/api/token/{id}`

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

### GET /api/token/{id}

- 摘要：获取指定令牌
- 说明：🔐 需要登录（User权限）
- 请求方法：`GET`
- 路径：`/api/token/{id}`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| id | path / integer / 必填 | 资源 ID | 整数或字符串 ID |

#### 请求体

- 无请求体。

#### 响应格式

- 已在下方给出字段级响应结构。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 错误信息；成功时为空 | 任意字符串 |
| data | Token | 脱敏后的单个令牌对象 | 对象 |

### GET /api/usage/token/

- 摘要：获取令牌使用情况
- 说明：🔑 需要令牌认证（TokenAuth）
- 请求方法：`GET`
- 路径：`/api/usage/token/`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| Authorization | header / string / 选填 | - | - |

#### 请求体

- 无请求体。

#### 响应格式

- 已在下方给出字段级响应结构。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| object | string | 固定对象类型 | credit_summary |
| total_granted | integer | 授予总额度 | >= 0 |
| total_used | integer | 已使用额度（当前实现常为 0） | >= 0 |
| total_available | integer | 剩余额度 | >= 0 |
| expires_at | integer | 过期时间毫秒时间戳；0 表示永不过期 | >= 0 |

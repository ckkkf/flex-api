# 用户管理 模块接口文档

- 来源：`new-api-main/docs/openapi/api.json`
- 接口数量：26

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

## 核心数据对象：User

- 来源：`new-api-main/model/user.go`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| id | int | - | - |
| username | string | - | - |
| password | string | - | - |
| original_password | string | this field is only for Password change verification, don't save it to database! | - |
| display_name | string | - | - |
| role | int | admin, common | 0=访客/未登录上下文；1=普通用户；10=管理员；100=Root 超级管理员 |
| status | int | enabled, disabled | 1=启用；2=禁用 |
| email | string | - | - |
| github_id | string | - | - |
| discord_id | string | - | - |
| oidc_id | string | - | - |
| wechat_id | string | - | - |
| telegram_id | string | - | - |
| verification_code | string | this field is only for Email verification, don't save it to database! | - |
| access_token | *string | this token is for system management | - |
| quota | int | - | - |
| used_quota | int | used quota | - |
| request_count | int | request number | - |
| group | string | - | - |
| aff_code | string | - | - |
| aff_count | int | - | - |
| aff_quota | int | 邀请剩余额度 | - |
| aff_history_quota | int | 邀请历史额度 | - |
| inviter_id | int | - | - |
| deleted_at | gorm.DeletedAt | - | - |
| linux_do_id | string | - | - |
| setting | string | - | - |
| remark | string | - | - |
| stripe_customer | string | - | - |

## 状态/枚举字段说明

### role

| 取值 | 含义 |
|---|---|
| 0 | 访客/未登录上下文 |
| 1 | 普通用户 |
| 10 | 管理员 |
| 100 | Root 超级管理员 |

### status

| 取值 | 含义 |
|---|---|
| 1 | 启用 |
| 2 | 禁用 |

## 接口明细

### GET /api/user/

- 摘要：获取所有用户
- 说明：👨‍💼 需要管理员权限（Admin）
- 请求方法：`GET`
- 路径：`/api/user/`

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

### POST /api/user/

- 摘要：创建用户
- 说明：👨‍💼 需要管理员权限（Admin）
- 请求方法：`POST`
- 路径：`/api/user/`

#### 路径 / Query 参数

- 无路径参数 / Query 参数。

#### 请求体

- Content-Type：`application/json`
- 请求体结构：`User`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| id | integer | 请求体字段 | - |
| username | string | 请求体字段 | - |
| display_name | string | 请求体字段 | - |
| role | integer | 请求体字段 | - |
| status | integer | 请求体字段 | - |
| email | string | 请求体字段 | - |
| group | string | 请求体字段 | - |
| quota | integer | 请求体字段 | - |
| used_quota | integer | 请求体字段 | - |
| request_count | integer | 请求体字段 | - |

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### PUT /api/user/

- 摘要：更新用户
- 说明：👨‍💼 需要管理员权限（Admin）
- 请求方法：`PUT`
- 路径：`/api/user/`

#### 路径 / Query 参数

- 无路径参数 / Query 参数。

#### 请求体

- Content-Type：`application/json`
- 请求体结构：`User`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| id | integer | 请求体字段 | - |
| username | string | 请求体字段 | - |
| display_name | string | 请求体字段 | - |
| role | integer | 请求体字段 | - |
| status | integer | 请求体字段 | - |
| email | string | 请求体字段 | - |
| group | string | 请求体字段 | - |
| quota | integer | 请求体字段 | - |
| used_quota | integer | 请求体字段 | - |
| request_count | integer | 请求体字段 | - |

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### GET /api/user/aff

- 摘要：获取邀请码
- 说明：🔐 需要登录（User权限）
- 请求方法：`GET`
- 路径：`/api/user/aff`

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

### POST /api/user/aff_transfer

- 摘要：转换邀请额度
- 说明：🔐 需要登录（User权限）
- 请求方法：`POST`
- 路径：`/api/user/aff_transfer`

#### 路径 / Query 参数

- 无路径参数 / Query 参数。

#### 请求体

- Content-Type：`application/json`
- 请求体结构：`object`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| quota | integer | 请求体字段 | - |

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### POST /api/user/manage

- 摘要：管理用户状态
- 说明：👨‍💼 需要管理员权限（Admin）
- 请求方法：`POST`
- 路径：`/api/user/manage`

#### 路径 / Query 参数

- 无路径参数 / Query 参数。

#### 请求体

- Content-Type：`application/json`
- 请求体结构：`object`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| id | integer | 请求体字段 | - |
| action | string | 请求体字段 | disable / enable / delete / promote / demote |

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### GET /api/user/models

- 摘要：获取用户可用模型
- 说明：🔐 需要登录（User权限）
- 请求方法：`GET`
- 路径：`/api/user/models`

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

### DELETE /api/user/passkey

- 摘要：删除Passkey
- 说明：🔐 需要登录（User权限）
- 请求方法：`DELETE`
- 路径：`/api/user/passkey`

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

### GET /api/user/passkey

- 摘要：获取Passkey状态
- 说明：🔐 需要登录（User权限）
- 请求方法：`GET`
- 路径：`/api/user/passkey`

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

### POST /api/user/passkey/register/begin

- 摘要：开始注册Passkey
- 说明：🔐 需要登录（User权限）
- 请求方法：`POST`
- 路径：`/api/user/passkey/register/begin`

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

### POST /api/user/passkey/register/finish

- 摘要：完成注册Passkey
- 说明：🔐 需要登录（User权限）
- 请求方法：`POST`
- 路径：`/api/user/passkey/register/finish`

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

### POST /api/user/passkey/verify/begin

- 摘要：开始验证Passkey
- 说明：🔐 需要登录（User权限）
- 请求方法：`POST`
- 路径：`/api/user/passkey/verify/begin`

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

### POST /api/user/passkey/verify/finish

- 摘要：完成验证Passkey
- 说明：🔐 需要登录（User权限）
- 请求方法：`POST`
- 路径：`/api/user/passkey/verify/finish`

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

### GET /api/user/search

- 摘要：搜索用户
- 说明：👨‍💼 需要管理员权限（Admin）
- 请求方法：`GET`
- 路径：`/api/user/search`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| keyword | query / string / 选填 | 搜索关键字 | 任意字符串 |
| group | query / string / 选填 | - | - |

#### 请求体

- 无请求体。

#### 响应格式

- 通常为 `ApiResponse<PageInfo<T>>`。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### DELETE /api/user/self

- 摘要：注销当前用户
- 说明：🔐 需要登录（User权限）
- 请求方法：`DELETE`
- 路径：`/api/user/self`

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

### GET /api/user/self

- 摘要：获取当前用户信息
- 说明：🔐 需要登录（User权限）
- 请求方法：`GET`
- 路径：`/api/user/self`

#### 路径 / Query 参数

- 无路径参数 / Query 参数。

#### 请求体

- 无请求体。

#### 响应格式

- 已在下方给出字段级响应结构。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 错误信息；成功时为空 | 任意字符串 |
| data.id | integer | 用户 ID | >= 1 |
| data.username | string | 用户名 | 非空字符串 |
| data.display_name | string | 显示名称 | 字符串 |
| data.role | integer | 用户角色 | 0 / 1 / 10 / 100 |
| data.status | integer | 用户状态 | 1 / 2 |
| data.group | string | 所属分组 | 字符串 |
| data.quota | integer | 总额度 | >= 0 |
| data.used_quota | integer | 已使用额度 | >= 0 |
| data.request_count | integer | 请求次数 | >= 0 |
| data.sidebar_modules | object | 用户侧边栏模块配置 | 对象 |
| data.permissions | object | 基于角色计算出的权限集合 | 对象 |

### PUT /api/user/self

- 摘要：更新当前用户信息
- 说明：🔐 需要登录（User权限）
- 请求方法：`PUT`
- 路径：`/api/user/self`

#### 路径 / Query 参数

- 无路径参数 / Query 参数。

#### 请求体

- Content-Type：`application/json`
- 请求体结构：`object`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| username | string | 请求体字段 | - |
| display_name | string | 请求体字段 | - |
| password | string | 请求体字段 | - |
| original_password | string | 请求体字段 | - |

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### GET /api/user/self/groups

- 摘要：获取当前用户分组
- 说明：🔐 需要登录（User权限）
- 请求方法：`GET`
- 路径：`/api/user/self/groups`

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

### PUT /api/user/setting

- 摘要：更新用户设置
- 说明：🔐 需要登录（User权限）
- 请求方法：`PUT`
- 路径：`/api/user/setting`

#### 路径 / Query 参数

- 无路径参数 / Query 参数。

#### 请求体

- Content-Type：`application/json`
- 请求体结构：`object`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| notify_type | string | 请求体字段 | - |
| quota_warning_threshold | number | 请求体字段 | - |
| webhook_url | string | 请求体字段 | - |
| notification_email | string | 请求体字段 | - |

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### GET /api/user/token

- 摘要：生成访问令牌
- 说明：🔐 需要登录（User权限）
- 请求方法：`GET`
- 路径：`/api/user/token`

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

### GET /api/user/topup

- 摘要：获取所有充值记录
- 说明：👨‍💼 需要管理员权限（Admin）
- 请求方法：`GET`
- 路径：`/api/user/topup`

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

### POST /api/user/topup/complete

- 摘要：管理员完成充值
- 说明：👨‍💼 需要管理员权限（Admin）
- 请求方法：`POST`
- 路径：`/api/user/topup/complete`

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

### DELETE /api/user/{id}

- 摘要：删除用户
- 说明：👨‍💼 需要管理员权限（Admin）
- 请求方法：`DELETE`
- 路径：`/api/user/{id}`

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

### GET /api/user/{id}

- 摘要：获取指定用户
- 说明：👨‍💼 需要管理员权限（Admin）
- 请求方法：`GET`
- 路径：`/api/user/{id}`

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

### DELETE /api/user/{id}/2fa

- 摘要：管理员禁用用户2FA
- 说明：👨‍💼 需要管理员权限（Admin）
- 请求方法：`DELETE`
- 路径：`/api/user/{id}/2fa`

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

### DELETE /api/user/{id}/reset_passkey

- 摘要：管理员重置用户Passkey
- 说明：👨‍💼 需要管理员权限（Admin）
- 请求方法：`DELETE`
- 路径：`/api/user/{id}/reset_passkey`

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

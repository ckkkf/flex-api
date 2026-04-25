# 用户登陆注册 模块接口文档

- 来源：`new-api-main/docs/openapi/api.json`
- 接口数量：10

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

### GET /api/reset_password

- 摘要：发送密码重置邮件
- 说明：🔓 无需鉴权
- 请求方法：`GET`
- 路径：`/api/reset_password`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| email | query / string / 必填 | - | - |

#### 请求体

- 无请求体。

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### GET /api/user/groups

- 摘要：获取用户分组列表
- 说明：🔓 无需鉴权
- 请求方法：`GET`
- 路径：`/api/user/groups`

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

### POST /api/user/login

- 摘要：用户登录
- 说明：🔓 无需鉴权
- 请求方法：`POST`
- 路径：`/api/user/login`

#### 路径 / Query 参数

- 无路径参数 / Query 参数。

#### 请求体

- Content-Type：`application/json`
- 请求体结构：`object`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| username | string | 请求体字段 | - |
| password | string | 请求体字段 | - |

#### 响应格式

- 已在下方给出字段级响应结构。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 登录是否成功 | true / false |
| message | string | 错误信息；要求 2FA 时为提示文案 | 任意字符串 |
| data.require_2fa | boolean | 是否需要继续进行 2FA 验证 | true / false |
| data.id | integer | 登录成功后的用户 ID | >= 1 |
| data.username | string | 用户名 | 非空字符串 |
| data.display_name | string | 显示名称 | 字符串 |
| data.role | integer | 用户角色 | 0 / 1 / 10 / 100 |
| data.status | integer | 用户状态 | 1 / 2 |
| data.group | string | 用户分组 | 字符串 |

### POST /api/user/login/2fa

- 摘要：两步验证登录
- 说明：🔓 无需鉴权（登录流程）
- 请求方法：`POST`
- 路径：`/api/user/login/2fa`

#### 路径 / Query 参数

- 无路径参数 / Query 参数。

#### 请求体

- Content-Type：`application/json`
- 请求体结构：`object`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| code | string | 请求体字段 | - |

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### GET /api/user/logout

- 摘要：用户登出
- 说明：🔓 无需鉴权
- 请求方法：`GET`
- 路径：`/api/user/logout`

#### 路径 / Query 参数

- 无路径参数 / Query 参数。

#### 请求体

- 无请求体。

#### 响应格式

- 已在下方给出字段级响应结构。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 登出是否成功 | true / false |
| message | string | 错误信息；成功时为空 | 任意字符串 |

### POST /api/user/passkey/login/begin

- 摘要：开始Passkey登录
- 说明：🔓 无需鉴权
- 请求方法：`POST`
- 路径：`/api/user/passkey/login/begin`

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

### POST /api/user/passkey/login/finish

- 摘要：完成Passkey登录
- 说明：🔓 无需鉴权
- 请求方法：`POST`
- 路径：`/api/user/passkey/login/finish`

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

### POST /api/user/register

- 摘要：用户注册
- 说明：🔓 无需鉴权
- 请求方法：`POST`
- 路径：`/api/user/register`

#### 路径 / Query 参数

- 无路径参数 / Query 参数。

#### 请求体

- Content-Type：`application/json`
- 请求体结构：`object`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| username | string | 请求体字段 | - |
| password | string | 请求体字段 | - |
| email | string | 请求体字段 | - |
| verification_code | string | 请求体字段 | - |
| aff_code | string | 请求体字段 | - |

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### POST /api/user/reset

- 摘要：重置密码
- 说明：🔓 无需鉴权
- 请求方法：`POST`
- 路径：`/api/user/reset`

#### 路径 / Query 参数

- 无路径参数 / Query 参数。

#### 请求体

- Content-Type：`application/json`
- 请求体结构：`object`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| email | string | 请求体字段 | - |
| token | string | 请求体字段 | - |
| password | string | 请求体字段 | - |

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### GET /api/verification

- 摘要：发送邮箱验证码
- 说明：🔓 无需鉴权
- 请求方法：`GET`
- 路径：`/api/verification`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| email | query / string / 必填 | - | - |

#### 请求体

- 无请求体。

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

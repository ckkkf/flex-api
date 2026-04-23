# 订阅计费 模块接口文档

- 来源：`new-api-main/router/*.go` + `new-api-main/controller/*.go`
- 接口数量：19

## 模块说明

- 该模块在 OpenAPI 中未完整覆盖，因此主要根据 Router + Controller 源码整理。

## 统一响应结构

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

## 核心数据对象：SubscriptionPlan

- 来源：`new-api-main/model/subscription.go`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| id | int | - | - |
| title | string | - | - |
| subtitle | string | - | - |
| price_amount | float64 | - | - |
| currency | string | - | - |
| duration_unit | string | - | year=按年；month=按月；day=按天；hour=按小时；custom=按自定义秒数 |
| duration_value | int | - | - |
| custom_seconds | int64 | - | - |
| enabled | bool | - | - |
| sort_order | int | - | - |
| stripe_price_id | string | - | - |
| creem_product_id | string | - | - |
| max_purchase_per_user | int | - | - |
| upgrade_group | string | - | - |
| total_amount | int64 | - | - |
| quota_reset_period | string | - | never=不重置；daily=每天重置；weekly=每周重置；monthly=每月重置；custom=按自定义秒数重置 |
| quota_reset_custom_seconds | int64 | - | - |
| created_at | int64 | - | - |
| updated_at | int64 | - | - |

## 核心数据对象：SubscriptionOrder

- 来源：`new-api-main/model/subscription.go`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| id | int | - | - |
| user_id | int | - | - |
| plan_id | int | - | - |
| money | float64 | - | - |
| trade_no | string | - | - |
| payment_method | string | - | - |
| status | string | - | pending=订单待支付；success=订单支付成功；failed=订单支付失败；expired=订单或订阅已过期；active=订阅生效中；cancelled=订阅已取消；consumed=预扣费已结算；refunded=预扣费已退款 |
| create_time | int64 | - | - |
| complete_time | int64 | - | - |
| provider_payload | string | - | - |

## 核心数据对象：UserSubscription

- 来源：`new-api-main/model/subscription.go`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| id | int | - | - |
| user_id | int | - | - |
| plan_id | int | - | - |
| amount_total | int64 | - | - |
| amount_used | int64 | - | - |
| start_time | int64 | - | - |
| end_time | int64 | - | - |
| status | string | active/expired/cancelled | pending=订单待支付；success=订单支付成功；failed=订单支付失败；expired=订单或订阅已过期；active=订阅生效中；cancelled=订阅已取消；consumed=预扣费已结算；refunded=预扣费已退款 |
| source | string | order/admin | order=订单创建；admin=管理员手动创建 |
| last_reset_time | int64 | - | - |
| next_reset_time | int64 | - | - |
| upgrade_group | string | - | - |
| prev_user_group | string | - | - |
| created_at | int64 | - | - |
| updated_at | int64 | - | - |

## 核心数据对象：SubscriptionPreConsumeRecord

- 来源：`new-api-main/model/subscription.go`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| id | int | - | - |
| request_id | string | - | - |
| user_id | int | - | - |
| user_subscription_id | int | - | - |
| pre_consumed | int64 | - | - |
| status | string | consumed/refunded | pending=订单待支付；success=订单支付成功；failed=订单支付失败；expired=订单或订阅已过期；active=订阅生效中；cancelled=订阅已取消；consumed=预扣费已结算；refunded=预扣费已退款 |
| created_at | int64 | - | - |
| updated_at | int64 | - | - |

## 状态/枚举字段说明

### duration_unit

| 取值 | 含义 |
|---|---|
| year | 按年 |
| month | 按月 |
| day | 按天 |
| hour | 按小时 |
| custom | 按自定义秒数 |

### quota_reset_period

| 取值 | 含义 |
|---|---|
| never | 不重置 |
| daily | 每天重置 |
| weekly | 每周重置 |
| monthly | 每月重置 |
| custom | 按自定义秒数重置 |

### status

| 取值 | 含义 |
|---|---|
| pending | 订单待支付 |
| success | 订单支付成功 |
| failed | 订单支付失败 |
| expired | 订单或订阅已过期 |
| active | 订阅生效中 |
| cancelled | 订阅已取消 |
| consumed | 预扣费已结算 |
| refunded | 预扣费已退款 |

### source

| 取值 | 含义 |
|---|---|
| order | 订单创建 |
| admin | 管理员手动创建 |

## 接口明细

### GET /api/subscription/plans

- 摘要：获取订阅套餐列表
- 请求方法：`GET`
- 路径：`/api/subscription/plans`

#### 路径 / Query 参数

- 无路径参数 / Query 参数，或源码未显式声明。

#### 请求体

- 未在 OpenAPI 中声明；通常为 JSON 请求，具体字段需以对应 Controller 为准。

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### GET /api/subscription/self

- 摘要：获取当前用户订阅信息
- 请求方法：`GET`
- 路径：`/api/subscription/self`

#### 路径 / Query 参数

- 无路径参数 / Query 参数，或源码未显式声明。

#### 请求体

- 未在 OpenAPI 中声明；通常为 JSON 请求，具体字段需以对应 Controller 为准。

#### 响应格式

- 已在下方给出字段级响应结构。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 错误信息；成功时为空 | 任意字符串 |
| data.billing_preference | string | 计费偏好 | wallet / subscription 等实现支持值 |
| data.subscriptions[] | SubscriptionSummary | 当前生效中的订阅列表 | 数组 |
| data.all_subscriptions[] | SubscriptionSummary | 包含过期记录的全部订阅列表 | 数组 |

### PUT /api/subscription/self/preference

- 摘要：更新订阅计费偏好
- 请求方法：`PUT`
- 路径：`/api/subscription/self/preference`

#### 路径 / Query 参数

- 无路径参数 / Query 参数，或源码未显式声明。

#### 请求体

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| billing_preference | string | 计费偏好 | wallet / subscription 等实现支持值 |

#### 响应格式

- 已在下方给出字段级响应结构。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 错误信息；成功时为空 | 任意字符串 |
| data.billing_preference | string | 更新后的计费偏好 | wallet / subscription 等实现支持值 |

### POST /api/subscription/epay/pay

- 摘要：发起订阅易支付
- 请求方法：`POST`
- 路径：`/api/subscription/epay/pay`

#### 路径 / Query 参数

- 无路径参数 / Query 参数，或源码未显式声明。

#### 请求体

- 未在 OpenAPI 中声明；通常为 JSON 请求，具体字段需以对应 Controller 为准。

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### POST /api/subscription/stripe/pay

- 摘要：发起订阅 Stripe 支付
- 请求方法：`POST`
- 路径：`/api/subscription/stripe/pay`

#### 路径 / Query 参数

- 无路径参数 / Query 参数，或源码未显式声明。

#### 请求体

- 未在 OpenAPI 中声明；通常为 JSON 请求，具体字段需以对应 Controller 为准。

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### POST /api/subscription/creem/pay

- 摘要：发起订阅 Creem 支付
- 请求方法：`POST`
- 路径：`/api/subscription/creem/pay`

#### 路径 / Query 参数

- 无路径参数 / Query 参数，或源码未显式声明。

#### 请求体

- 未在 OpenAPI 中声明；通常为 JSON 请求，具体字段需以对应 Controller 为准。

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### GET /api/subscription/admin/plans

- 摘要：管理员获取订阅套餐
- 请求方法：`GET`
- 路径：`/api/subscription/admin/plans`

#### 路径 / Query 参数

- 无路径参数 / Query 参数，或源码未显式声明。

#### 请求体

- 未在 OpenAPI 中声明；通常为 JSON 请求，具体字段需以对应 Controller 为准。

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### POST /api/subscription/admin/plans

- 摘要：管理员创建订阅套餐
- 请求方法：`POST`
- 路径：`/api/subscription/admin/plans`

#### 路径 / Query 参数

- 无路径参数 / Query 参数，或源码未显式声明。

#### 请求体

- 未在 OpenAPI 中声明；通常为 JSON 请求，具体字段需以对应 Controller 为准。

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### PUT /api/subscription/admin/plans/{id}

- 摘要：管理员更新订阅套餐
- 请求方法：`PUT`
- 路径：`/api/subscription/admin/plans/{id}`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| id | path / integer / 必填 | 套餐 ID | >= 1 |

#### 请求体

- 未在 OpenAPI 中声明；通常为 JSON 请求，具体字段需以对应 Controller 为准。

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### PATCH /api/subscription/admin/plans/{id}

- 摘要：管理员更新订阅套餐状态
- 请求方法：`PATCH`
- 路径：`/api/subscription/admin/plans/{id}`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| id | path / integer / 必填 | 套餐 ID | >= 1 |

#### 请求体

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| enabled | boolean | 是否启用套餐 | true / false |

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### POST /api/subscription/admin/bind

- 摘要：管理员绑定订阅
- 请求方法：`POST`
- 路径：`/api/subscription/admin/bind`

#### 路径 / Query 参数

- 无路径参数 / Query 参数，或源码未显式声明。

#### 请求体

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| user_id | integer | 用户 ID | >= 1 |
| plan_id | integer | 套餐 ID | >= 1 |

#### 响应格式

- 已在下方给出字段级响应结构。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 错误信息；成功时为空 | 任意字符串 |
| data.message | string | 绑定成功时的附加提示；无提示时 data 可能为 null | 字符串 |

### GET /api/subscription/admin/users/{id}/subscriptions

- 摘要：管理员获取用户订阅列表
- 请求方法：`GET`
- 路径：`/api/subscription/admin/users/{id}/subscriptions`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| id | path / integer / 必填 | 用户 ID | >= 1 |

#### 请求体

- 未在 OpenAPI 中声明；通常为 JSON 请求，具体字段需以对应 Controller 为准。

#### 响应格式

- 已在下方给出字段级响应结构。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 错误信息；成功时为空 | 任意字符串 |
| data[] | SubscriptionSummary | 指定用户的全部订阅列表 | 数组 |

### POST /api/subscription/admin/users/{id}/subscriptions

- 摘要：管理员创建用户订阅
- 请求方法：`POST`
- 路径：`/api/subscription/admin/users/{id}/subscriptions`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| id | path / integer / 必填 | 用户 ID | >= 1 |

#### 请求体

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| plan_id | integer | 套餐 ID | >= 1 |

#### 响应格式

- 已在下方给出字段级响应结构。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 错误信息；成功时为空 | 任意字符串 |
| data.message | string | 创建成功时的附加提示；无提示时 data 可能为 null | 字符串 |

### POST /api/subscription/admin/user_subscriptions/{id}/invalidate

- 摘要：管理员使订阅失效
- 请求方法：`POST`
- 路径：`/api/subscription/admin/user_subscriptions/{id}/invalidate`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| id | path / integer / 必填 | 订阅实例 ID | >= 1 |

#### 请求体

- 未在 OpenAPI 中声明；通常为 JSON 请求，具体字段需以对应 Controller 为准。

#### 响应格式

- 已在下方给出字段级响应结构。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 错误信息；成功时为空 | 任意字符串 |
| data.message | string | 失效成功时的附加提示；无提示时 data 可能为 null | 字符串 |

### DELETE /api/subscription/admin/user_subscriptions/{id}

- 摘要：管理员删除用户订阅
- 请求方法：`DELETE`
- 路径：`/api/subscription/admin/user_subscriptions/{id}`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| id | path / integer / 必填 | 订阅实例 ID | >= 1 |

#### 请求体

- 未在 OpenAPI 中声明；通常为 JSON 请求，具体字段需以对应 Controller 为准。

#### 响应格式

- 已在下方给出字段级响应结构。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 错误信息；成功时为空 | 任意字符串 |
| data.message | string | 删除成功时的附加提示；无提示时 data 可能为 null | 字符串 |

### GET /api/subscription/epay/notify

- 摘要：订阅易支付回调(GET)
- 请求方法：`GET`
- 路径：`/api/subscription/epay/notify`

#### 路径 / Query 参数

- 无路径参数 / Query 参数，或源码未显式声明。

#### 请求体

- 未在 OpenAPI 中声明；通常为 JSON 请求，具体字段需以对应 Controller 为准。

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### POST /api/subscription/epay/notify

- 摘要：订阅易支付回调(POST)
- 请求方法：`POST`
- 路径：`/api/subscription/epay/notify`

#### 路径 / Query 参数

- 无路径参数 / Query 参数，或源码未显式声明。

#### 请求体

- 未在 OpenAPI 中声明；通常为 JSON 请求，具体字段需以对应 Controller 为准。

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### GET /api/subscription/epay/return

- 摘要：订阅易支付同步返回(GET)
- 请求方法：`GET`
- 路径：`/api/subscription/epay/return`

#### 路径 / Query 参数

- 无路径参数 / Query 参数，或源码未显式声明。

#### 请求体

- 未在 OpenAPI 中声明；通常为 JSON 请求，具体字段需以对应 Controller 为准。

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### POST /api/subscription/epay/return

- 摘要：订阅易支付同步返回(POST)
- 请求方法：`POST`
- 路径：`/api/subscription/epay/return`

#### 路径 / Query 参数

- 无路径参数 / Query 参数，或源码未显式声明。

#### 请求体

- 未在 OpenAPI 中声明；通常为 JSON 请求，具体字段需以对应 Controller 为准。

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

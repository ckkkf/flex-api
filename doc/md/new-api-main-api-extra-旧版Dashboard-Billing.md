# 旧版Dashboard Billing 模块接口文档

- 来源：`new-api-main/router/*.go` + `new-api-main/controller/*.go`
- 接口数量：4

## 模块说明

- 该模块在 OpenAPI 中未完整覆盖，因此主要根据 Router + Controller 源码整理。

## 统一响应结构

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

## 接口明细

### GET /dashboard/billing/subscription

- 摘要：旧版 Dashboard 订阅账单
- 请求方法：`GET`
- 路径：`/dashboard/billing/subscription`

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

### GET /v1/dashboard/billing/subscription

- 摘要：OpenAI 兼容订阅账单
- 请求方法：`GET`
- 路径：`/v1/dashboard/billing/subscription`

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

### GET /dashboard/billing/usage

- 摘要：旧版 Dashboard 用量统计
- 请求方法：`GET`
- 路径：`/dashboard/billing/usage`

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

### GET /v1/dashboard/billing/usage

- 摘要：OpenAI 兼容用量统计
- 请求方法：`GET`
- 路径：`/v1/dashboard/billing/usage`

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

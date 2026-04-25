# 日志 模块接口文档

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

## 核心数据对象：Log

- 来源：`new-api-main/model/log.go`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| id | int | - | - |
| user_id | int | - | - |
| created_at | int64 | - | - |
| type | int | - | 0=未知；1=充值；2=消费；3=管理操作；4=系统事件；5=错误；6=退款 |
| content | string | - | - |
| username | string | - | - |
| token_name | string | - | - |
| model_name | string | - | - |
| quota | int | - | - |
| prompt_tokens | int | - | - |
| completion_tokens | int | - | - |
| use_time | int | - | - |
| is_stream | bool | - | - |
| channel | int | - | - |
| channel_name | string | - | - |
| token_id | int | - | - |
| group | string | - | - |
| ip | string | - | - |
| request_id | string | - | - |
| other | string | - | - |

## 状态/枚举字段说明

### type

| 取值 | 含义 |
|---|---|
| 0 | 未知 |
| 1 | 充值 |
| 2 | 消费 |
| 3 | 管理操作 |
| 4 | 系统事件 |
| 5 | 错误 |
| 6 | 退款 |

## 接口明细

### DELETE /api/log/

- 摘要：删除历史日志
- 说明：👨‍💼 需要管理员权限（Admin）
- 请求方法：`DELETE`
- 路径：`/api/log/`

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

### GET /api/log/

- 摘要：获取所有日志
- 说明：👨‍💼 需要管理员权限（Admin）
- 请求方法：`GET`
- 路径：`/api/log/`

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

### GET /api/log/search

- 摘要：搜索日志
- 说明：👨‍💼 需要管理员权限（Admin）
- 请求方法：`GET`
- 路径：`/api/log/search`

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

### GET /api/log/self

- 摘要：获取个人日志
- 说明：🔐 需要登录（User权限）
- 请求方法：`GET`
- 路径：`/api/log/self`

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

### GET /api/log/self/search

- 摘要：搜索个人日志
- 说明：🔐 需要登录（User权限）
- 请求方法：`GET`
- 路径：`/api/log/self/search`

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

### GET /api/log/self/stat

- 摘要：获取个人日志统计
- 说明：🔐 需要登录（User权限）
- 请求方法：`GET`
- 路径：`/api/log/self/stat`

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

### GET /api/log/stat

- 摘要：获取日志统计
- 说明：👨‍💼 需要管理员权限（Admin）
- 请求方法：`GET`
- 路径：`/api/log/stat`

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

### GET /api/log/token

- 摘要：通过令牌获取日志
- 说明：🔓 无需鉴权（通过令牌查询）
- 请求方法：`GET`
- 路径：`/api/log/token`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| key | query / string / 选填 | - | - |

#### 请求体

- 无请求体。

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

# 性能运维 模块接口文档

- 来源：`new-api-main/router/*.go` + `new-api-main/controller/*.go`
- 接口数量：6

## 模块说明

- 该模块在 OpenAPI 中未完整覆盖，因此主要根据 Router + Controller 源码整理。

## 统一响应结构

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

## 接口明细

### GET /api/performance/stats

- 摘要：获取性能统计
- 请求方法：`GET`
- 路径：`/api/performance/stats`

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

### DELETE /api/performance/disk_cache

- 摘要：清理磁盘缓存
- 请求方法：`DELETE`
- 路径：`/api/performance/disk_cache`

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

### POST /api/performance/reset_stats

- 摘要：重置性能统计
- 请求方法：`POST`
- 路径：`/api/performance/reset_stats`

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

### POST /api/performance/gc

- 摘要：触发 GC
- 请求方法：`POST`
- 路径：`/api/performance/gc`

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

### GET /api/performance/logs

- 摘要：获取日志文件列表
- 请求方法：`GET`
- 路径：`/api/performance/logs`

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

### DELETE /api/performance/logs

- 摘要：清理日志文件
- 请求方法：`DELETE`
- 路径：`/api/performance/logs`

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

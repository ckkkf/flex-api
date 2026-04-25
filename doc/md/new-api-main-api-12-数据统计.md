# 数据统计 模块接口文档

- 来源：`new-api-main/docs/openapi/api.json`
- 接口数量：2

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

## 核心数据对象：QuotaData

- 来源：`new-api-main/model/usedata.go`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| id | int | - | - |
| user_id | int | - | - |
| username | string | - | - |
| model_name | string | - | - |
| created_at | int64 | - | - |
| token_used | int | - | - |
| count | int | - | - |
| quota | int | - | - |

## 接口明细

### GET /api/data/

- 摘要：获取所有额度数据
- 说明：👨‍💼 需要管理员权限（Admin）
- 请求方法：`GET`
- 路径：`/api/data/`

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

### GET /api/data/self

- 摘要：获取个人额度数据
- 说明：🔐 需要登录（User权限）
- 请求方法：`GET`
- 路径：`/api/data/self`

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

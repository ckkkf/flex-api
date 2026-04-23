# 模型部署 模块接口文档

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

## 状态/枚举字段说明

### status

| 取值 | 含义 |
|---|---|
| running | 运行中 |
| completed | 已完成 |
| failed | 失败 |
| deployment requested | 已申请部署 |
| termination requested | 已申请终止 |
| destroyed | 已销毁 |

## 关键响应对象：Deployment（由 `mapIoNetDeployment` 组装）

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| id | string | 部署 ID | io.net 返回值 |
| deployment_name | string | 部署名称 | 非空字符串 |
| status | string | 部署状态 | 见本模块状态枚举 |
| type | string | 资源类型 | 当前固定为 Container |
| time_remaining_minutes | integer | 剩余运行分钟数 | >= 0 |
| hardware_info | string | 硬件摘要 | 品牌 + 型号 + 数量 |
| completed_percent | integer | 完成百分比 | 0 ~ 100 |
| resource_config | object | 资源配置 | cpu/memory/gpu |

## 接口明细

### GET /api/deployments/settings

- 摘要：获取部署设置
- 请求方法：`GET`
- 路径：`/api/deployments/settings`

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
| data.provider | string | 部署提供商 | 当前固定为 io.net |
| data.enabled | boolean | 是否启用部署功能 | true / false |
| data.configured | boolean | 是否已配置 API Key | true / false |
| data.can_connect | boolean | 是否具备连接条件 | true / false |

### POST /api/deployments/settings/test-connection

- 摘要：测试 io.net 连接
- 请求方法：`POST`
- 路径：`/api/deployments/settings/test-connection`

#### 路径 / Query 参数

- 无路径参数 / Query 参数，或源码未显式声明。

#### 请求体

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| api_key | string | io.net API Key；不传则尝试读取系统配置 | 可选 |

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### GET /api/deployments/

- 摘要：获取部署列表
- 请求方法：`GET`
- 路径：`/api/deployments/`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| status | query / string / 选填 | 按部署状态筛选 | 见模型部署状态枚举 |

#### 请求体

- 未在 OpenAPI 中声明；通常为 JSON 请求，具体字段需以对应 Controller 为准。

#### 响应格式

- 已在下方给出字段级响应结构。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 错误信息；成功时为空 | 任意字符串 |
| data.page | integer | 当前页码 | >= 1 |
| data.page_size | integer | 每页条数 | 1 ~ 100 |
| data.total | integer | 部署总数 | >= 0 |
| data.items[] | Deployment | 部署列表 | 数组 |
| data.status_counts | object | 按状态统计的部署数量 | key 为部署状态字符串 |

### GET /api/deployments/search

- 摘要：搜索部署
- 请求方法：`GET`
- 路径：`/api/deployments/search`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| status | query / string / 选填 | 按部署状态筛选 | 见模型部署状态枚举 |
| keyword | query / string / 选填 | 按部署名称关键字搜索 | 任意字符串 |

#### 请求体

- 未在 OpenAPI 中声明；通常为 JSON 请求，具体字段需以对应 Controller 为准。

#### 响应格式

- 已在下方给出字段级响应结构。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 错误信息；成功时为空 | 任意字符串 |
| data.page | integer | 当前页码 | >= 1 |
| data.page_size | integer | 每页条数 | 1 ~ 100 |
| data.total | integer | 搜索后的部署总数 | >= 0 |
| data.items[] | Deployment | 搜索命中的部署列表 | 数组 |

### POST /api/deployments/test-connection

- 摘要：测试 io.net 连接
- 请求方法：`POST`
- 路径：`/api/deployments/test-connection`

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

### GET /api/deployments/hardware-types

- 摘要：获取硬件类型
- 请求方法：`GET`
- 路径：`/api/deployments/hardware-types`

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
| data.hardware_types[] | object | 硬件类型列表 | 数组 |
| data.total | integer | 硬件类型数量 | >= 0 |
| data.total_available | integer | 总可用资源数 | >= 0 |

### GET /api/deployments/locations

- 摘要：获取可用地域
- 请求方法：`GET`
- 路径：`/api/deployments/locations`

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
| data.locations[] | object | 地域列表 | 数组 |
| data.total | integer | 地域总数 | >= 0 |

### GET /api/deployments/available-replicas

- 摘要：获取可用副本
- 请求方法：`GET`
- 路径：`/api/deployments/available-replicas`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| hardware_id | query / integer / 必填 | 硬件 ID | >= 1 |
| gpu_count | query / integer / 选填 | GPU 数量 | >= 1，默认 1 |

#### 请求体

- 未在 OpenAPI 中声明；通常为 JSON 请求，具体字段需以对应 Controller 为准。

#### 响应格式

- 已在下方给出字段级响应结构。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 错误信息；成功时为空 | 任意字符串 |
| data | object | 可用副本响应对象 | 由 io.net 原样返回 |

### POST /api/deployments/price-estimation

- 摘要：获取价格预估
- 请求方法：`POST`
- 路径：`/api/deployments/price-estimation`

#### 路径 / Query 参数

- 无路径参数 / Query 参数，或源码未显式声明。

#### 请求体

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| hardware_id | integer | 硬件 ID | >= 1 |
| gpu_count | integer | GPU 数量 | >= 1 |
| duration_minutes | integer | 时长（分钟） | >= 1 |

#### 响应格式

- 已在下方给出字段级响应结构。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 错误信息；成功时为空 | 任意字符串 |
| data | object | 价格预估响应对象 | 由 io.net 原样返回 |

### GET /api/deployments/check-name

- 摘要：检查集群名称可用性
- 请求方法：`GET`
- 路径：`/api/deployments/check-name`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| name | query / string / 必填 | 待检查的部署名称 | 非空字符串 |

#### 请求体

- 未在 OpenAPI 中声明；通常为 JSON 请求，具体字段需以对应 Controller 为准。

#### 响应格式

- 已在下方给出字段级响应结构。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 错误信息；成功时为空 | 任意字符串 |
| data.available | boolean | 名称是否可用 | true / false |
| data.name | string | 待检查的名称 | 非空字符串 |

### POST /api/deployments/

- 摘要：创建部署
- 请求方法：`POST`
- 路径：`/api/deployments/`

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
| data.deployment_id | string | 新建部署 ID | 字符串 |
| data.status | string | 创建结果状态 | 字符串 |
| data.message | string | 成功提示 | Deployment created successfully |

### GET /api/deployments/{id}

- 摘要：获取部署详情
- 请求方法：`GET`
- 路径：`/api/deployments/{id}`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| id | path / string / 必填 | 部署 ID | 字符串 |

#### 请求体

- 未在 OpenAPI 中声明；通常为 JSON 请求，具体字段需以对应 Controller 为准。

#### 响应格式

- 已在下方给出字段级响应结构。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 错误信息；成功时为空 | 任意字符串 |
| data.id | string | 部署 ID | 字符串 |
| data.status | string | 部署状态 | 见模型部署状态枚举 |
| data.instance_count | integer | 实例数 | >= 0 |
| data.hardware_id | integer | 硬件 ID | >= 1 |
| data.amount_paid | number | 已支付金额 | >= 0 |
| data.total_gpus | integer | 总 GPU 数 | >= 0 |
| data.locations | array | 地域列表 | 数组 |
| data.container_config | object | 容器配置 | 对象 |

### GET /api/deployments/{id}/logs

- 摘要：获取部署日志
- 请求方法：`GET`
- 路径：`/api/deployments/{id}/logs`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| id | path / string / 必填 | 部署 ID | 字符串 |
| container_id | query / string / 必填 | 容器 ID | 字符串 |
| level | query / string / 选填 | 日志级别 | 字符串 |
| stream | query / string / 选填 | 日志流 | stdout / stderr 等 |
| cursor | query / string / 选填 | 分页游标 | 字符串 |
| limit | query / integer / 选填 | 返回条数 | 1 ~ 1000 |
| follow | query / boolean / 选填 | 是否持续追踪 | true / false |
| start_time | query / string / 选填 | 开始时间 | RFC3339 时间 |
| end_time | query / string / 选填 | 结束时间 | RFC3339 时间 |

#### 请求体

- 未在 OpenAPI 中声明；通常为 JSON 请求，具体字段需以对应 Controller 为准。

#### 响应格式

- 已在下方给出字段级响应结构。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 错误信息；成功时为空 | 任意字符串 |
| data | string|object | 原始容器日志内容 | 由 io.net 接口返回 |

### GET /api/deployments/{id}/containers

- 摘要：获取部署容器列表
- 请求方法：`GET`
- 路径：`/api/deployments/{id}/containers`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| id | path / string / 必填 | 部署 ID | 字符串 |

#### 请求体

- 未在 OpenAPI 中声明；通常为 JSON 请求，具体字段需以对应 Controller 为准。

#### 响应格式

- 已在下方给出字段级响应结构。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 错误信息；成功时为空 | 任意字符串 |
| data.total | integer | 容器总数 | >= 0 |
| data.containers[] | object | 容器列表 | 数组 |
| data.containers[].container_id | string | 容器 ID | 字符串 |
| data.containers[].status | string | 容器状态 | 字符串 |
| data.containers[].events[] | object | 容器事件列表 | 数组 |

### GET /api/deployments/{id}/containers/{container_id}

- 摘要：获取容器详情
- 请求方法：`GET`
- 路径：`/api/deployments/{id}/containers/{container_id}`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| id | path / string / 必填 | 部署 ID | 字符串 |
| container_id | path / string / 必填 | 容器 ID | 字符串 |

#### 请求体

- 未在 OpenAPI 中声明；通常为 JSON 请求，具体字段需以对应 Controller 为准。

#### 响应格式

- 已在下方给出字段级响应结构。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 错误信息；成功时为空 | 任意字符串 |
| data | object | 单个容器详情对象 | 对象 |

### PUT /api/deployments/{id}

- 摘要：更新部署
- 请求方法：`PUT`
- 路径：`/api/deployments/{id}`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| id | path / string / 必填 | 部署 ID | 字符串 |

#### 请求体

- 未在 OpenAPI 中声明；通常为 JSON 请求，具体字段需以对应 Controller 为准。

#### 响应格式

- 已在下方给出字段级响应结构。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 错误信息；成功时为空 | 任意字符串 |
| data.status | string | 更新结果状态 | 字符串 |
| data.deployment_id | string | 部署 ID | 字符串 |

### PUT /api/deployments/{id}/name

- 摘要：更新部署名称
- 请求方法：`PUT`
- 路径：`/api/deployments/{id}/name`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| id | path / string / 必填 | 部署 ID | 字符串 |

#### 请求体

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| name | string | 新部署名称 | 必填；需通过可用性检查 |

#### 响应格式

- 已在下方给出字段级响应结构。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 外层错误信息；成功时为空 | 任意字符串 |
| data.status | string | 更新结果状态 | 字符串 |
| data.message | string | 底层接口返回消息 | 字符串 |
| data.id | string | 部署 ID | 字符串 |
| data.name | string | 更新后的部署名称 | 非空字符串 |

### POST /api/deployments/{id}/extend

- 摘要：续期部署
- 请求方法：`POST`
- 路径：`/api/deployments/{id}/extend`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| id | path / string / 必填 | 部署 ID | 字符串 |

#### 请求体

- 未在 OpenAPI 中声明；通常为 JSON 请求，具体字段需以对应 Controller 为准。

#### 响应格式

- 已在下方给出字段级响应结构。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 错误信息；成功时为空 | 任意字符串 |
| data | Deployment | 续期后的部署摘要对象 | 对象 |

### DELETE /api/deployments/{id}

- 摘要：删除部署
- 请求方法：`DELETE`
- 路径：`/api/deployments/{id}`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| id | path / string / 必填 | 部署 ID | 字符串 |

#### 请求体

- 未在 OpenAPI 中声明；通常为 JSON 请求，具体字段需以对应 Controller 为准。

#### 响应格式

- 已在下方给出字段级响应结构。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 外层错误信息；成功时为空 | 任意字符串 |
| data.status | string | 删除请求状态 | 字符串 |
| data.deployment_id | string | 部署 ID | 字符串 |
| data.message | string | 固定成功提示 | Deployment termination requested successfully |

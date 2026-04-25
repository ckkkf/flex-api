# 自定义OAuth提供商 模块接口文档

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

## 核心数据对象：CustomOAuthProviderResponse

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| id | int | 提供商 ID | - |
| name | string | 显示名称 | - |
| slug | string | URL 标识 | - |
| icon | string | 图标名 | - |
| enabled | bool | 是否启用 | - |
| client_id | string | OAuth Client ID | - |
| authorization_endpoint | string | 授权地址 | - |
| token_endpoint | string | Token 地址 | - |
| user_info_endpoint | string | 用户信息地址 | - |
| scopes | string | 授权范围 | - |
| user_id_field | string | 用户 ID 字段路径 | - |
| username_field | string | 用户名字段路径 | - |
| display_name_field | string | 显示名称字段路径 | - |
| email_field | string | 邮箱字段路径 | - |
| well_known | string | OIDC Discovery 地址 | - |
| auth_style | int | 认证样式 | 0=自动选择；1=参数模式；2=Header Basic Auth 模式 |
| access_policy | string | 访问控制策略 JSON | - |
| access_denied_message | string | 访问拒绝提示 | - |

## 核心数据对象：UserOAuthBindingResponse

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| provider_id | int | 提供商 ID | - |
| provider_name | string | 提供商名称 | - |
| provider_slug | string | 提供商 slug | - |
| provider_icon | string | 提供商图标 | - |
| provider_user_id | string | 第三方平台用户 ID | - |

## 核心数据对象：CustomOAuthProvider

- 来源：`new-api-main/model/custom_oauth_provider.go`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| id | int | - | - |
| name | string | Display name, e.g., "GitHub Enterprise" | - |
| slug | string | URL identifier, e.g., "github-enterprise" | - |
| icon | string | Icon name from @lobehub/icons | - |
| enabled | bool | Whether this provider is enabled | - |
| client_id | string | OAuth client ID | - |
| client_secret | string | OAuth client secret (not returned to frontend) | - |
| authorization_endpoint | string | Authorization URL | - |
| token_endpoint | string | Token exchange URL | - |
| user_info_endpoint | string | User info URL | - |
| scopes | string | OAuth scopes | - |
| user_id_field | string | User ID field path, e.g., "sub", "id", "data.user.id" | - |
| username_field | string | Username field path | - |
| display_name_field | string | Display name field path | - |
| email_field | string | Email field path | - |
| well_known | string | OIDC discovery endpoint (optional) | - |
| auth_style | int | 0=auto, 1=params, 2=header (Basic Auth) | 0=自动选择；1=参数模式；2=Header Basic Auth 模式 |
| access_policy | string | JSON policy for access control based on user info | - |
| access_denied_message | string | Custom error message template when access is denied | - |
| created_at | time.Time | - | - |
| updated_at | time.Time | - | - |

## 核心数据对象：UserOAuthBinding

- 来源：`new-api-main/model/user_oauth_binding.go`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| id | int | - | - |
| user_id | int | User ID - one binding per user per provider | - |
| provider_id | int | Custom OAuth provider ID | - |
| provider_user_id | string | User ID from OAuth provider - one OAuth account per provider | - |
| created_at | time.Time | - | - |

## 状态/枚举字段说明

### auth_style

| 取值 | 含义 |
|---|---|
| 0 | 自动选择 |
| 1 | 参数模式 |
| 2 | Header Basic Auth 模式 |

## 接口明细

### POST /api/custom-oauth-provider/discovery

- 摘要：获取 OIDC Discovery 配置
- 请求方法：`POST`
- 路径：`/api/custom-oauth-provider/discovery`

#### 路径 / Query 参数

- 无路径参数 / Query 参数，或源码未显式声明。

#### 请求体

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| well_known_url | string | OIDC Discovery 完整 URL | http/https URL；与 issuer_url 二选一至少填一个 |
| issuer_url | string | OIDC Issuer URL；后端会自动补齐 /.well-known/openid-configuration | http/https URL；与 well_known_url 二选一至少填一个 |

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

### GET /api/custom-oauth-provider/

- 摘要：获取自定义 OAuth 提供商列表
- 请求方法：`GET`
- 路径：`/api/custom-oauth-provider/`

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
| data[] | CustomOAuthProviderResponse | 自定义 OAuth 提供商列表（已排除 client_secret） | 数组 |

### GET /api/custom-oauth-provider/{id}

- 摘要：获取自定义 OAuth 提供商详情
- 请求方法：`GET`
- 路径：`/api/custom-oauth-provider/{id}`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| id | path / integer / 必填 | 提供商 ID | >= 1 |

#### 请求体

- 未在 OpenAPI 中声明；通常为 JSON 请求，具体字段需以对应 Controller 为准。

#### 响应格式

- 已在下方给出字段级响应结构。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 错误信息；成功时为空 | 任意字符串 |
| data | CustomOAuthProviderResponse | 单个自定义 OAuth 提供商对象 | 对象 |

### POST /api/custom-oauth-provider/

- 摘要：创建自定义 OAuth 提供商
- 请求方法：`POST`
- 路径：`/api/custom-oauth-provider/`

#### 路径 / Query 参数

- 无路径参数 / Query 参数，或源码未显式声明。

#### 请求体

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| name | string | 显示名称 | 必填，非空字符串 |
| slug | string | URL 标识 | 必填；且不能与内置 OAuth 提供商冲突 |
| icon | string | 图标名称 | 可选 |
| enabled | boolean | 是否启用 | true / false |
| client_id | string | OAuth Client ID | 必填 |
| client_secret | string | OAuth Client Secret | 必填 |
| authorization_endpoint | string | 授权地址 | 必填，URL |
| token_endpoint | string | 令牌交换地址 | 必填，URL |
| user_info_endpoint | string | 用户信息地址 | 必填，URL |
| scopes | string | 授权范围 | 如 openid profile email |
| user_id_field | string | 用户 ID 字段路径 | 支持 JSONPath 风格路径 |
| username_field | string | 用户名字段路径 | 支持 JSONPath 风格路径 |
| display_name_field | string | 显示名称字段路径 | 支持 JSONPath 风格路径 |
| email_field | string | 邮箱字段路径 | 支持 JSONPath 风格路径 |
| well_known | string | OIDC discovery 地址 | 可选 URL |
| auth_style | integer | 认证样式 | 0 / 1 / 2 |
| access_policy | string | 访问控制策略 JSON | JSON 字符串 |
| access_denied_message | string | 访问拒绝提示 | 字符串 |

#### 响应格式

- 已在下方给出字段级响应结构。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 成功时为“创建成功” | 任意字符串 |
| data | CustomOAuthProviderResponse | 创建后的提供商对象 | 对象 |

### PUT /api/custom-oauth-provider/{id}

- 摘要：更新自定义 OAuth 提供商
- 请求方法：`PUT`
- 路径：`/api/custom-oauth-provider/{id}`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| id | path / integer / 必填 | 提供商 ID | >= 1 |

#### 请求体

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| name | string | 显示名称 | 可选，非空字符串 |
| slug | string | URL 标识 | 可选；不能与其他 provider 或内置 OAuth 冲突 |
| icon | string|null | 图标名称 | 传 null 表示保持现有值 |
| enabled | boolean|null | 是否启用 | true / false / null |
| client_id | string | OAuth Client ID | 可选 |
| client_secret | string | OAuth Client Secret | 空字符串表示不变 |
| authorization_endpoint | string | 授权地址 | 可选 URL |
| token_endpoint | string | 令牌交换地址 | 可选 URL |
| user_info_endpoint | string | 用户信息地址 | 可选 URL |
| scopes | string | 授权范围 | 可选 |
| user_id_field | string | 用户 ID 字段路径 | 可选 |
| username_field | string | 用户名字段路径 | 可选 |
| display_name_field | string | 显示名称字段路径 | 可选 |
| email_field | string | 邮箱字段路径 | 可选 |
| well_known | string|null | OIDC discovery 地址 | 可选 / null |
| auth_style | integer|null | 认证样式 | 0 / 1 / 2 / null |
| access_policy | string|null | 访问控制策略 JSON | JSON 字符串 / null |
| access_denied_message | string|null | 访问拒绝提示 | 字符串 / null |

#### 响应格式

- 已在下方给出字段级响应结构。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 成功时为“更新成功” | 任意字符串 |
| data | CustomOAuthProviderResponse | 更新后的提供商对象 | 对象 |

### DELETE /api/custom-oauth-provider/{id}

- 摘要：删除自定义 OAuth 提供商
- 请求方法：`DELETE`
- 路径：`/api/custom-oauth-provider/{id}`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| id | path / integer / 必填 | 提供商 ID | >= 1 |

#### 请求体

- 未在 OpenAPI 中声明；通常为 JSON 请求，具体字段需以对应 Controller 为准。

#### 响应格式

- 通常为 `ApiResponse<T>` 统一 JSON 包装。

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| success | boolean | 请求是否成功 | true / false |
| message | string | 提示信息或错误原因；成功时通常为空字符串 | 任意字符串 |
| data | any | 业务数据载荷 | 对象 / 数组 / 分页对象 / 标量 |

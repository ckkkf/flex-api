# 视频生成/即梦格式 模块接口文档

- 来源：`new-api-main/docs/openapi/relay.json` + `new-api-main/router/relay-router.go` / `video-router.go`
- OpenAPI 覆盖接口数量：1

## 模块说明

- Relay 接口通常直接透传 OpenAI / Claude / Gemini / 视频平台兼容协议。
- 绝大多数接口需要令牌认证；少数下载类接口支持用户会话或令牌二选一。

## 接口明细

### POST /jimeng/

- 摘要：即梦视频生成
- 请求方法：`POST`
- 路径：`/jimeng/`

#### 路径 / Query 参数

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| Action | query / string / 必填 | API 操作类型 | CVSync2AsyncSubmitTask / CVSync2AsyncGetResult |
| Version | query / string / 必填 | API 版本 | - |

#### 请求体

- Content-Type：`application/json`
- 请求体结构：`object`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| req_key | string | 请求体字段 | - |
| prompt | string | 请求体字段 | - |
| binary_data_base64 | array<string> | 请求体字段 | - |

#### 响应格式

- 透传上游兼容协议响应，不再套用后台 `ApiResponse` 外层。

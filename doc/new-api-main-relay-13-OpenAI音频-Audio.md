# OpenAI音频(Audio) 模块接口文档

- 来源：`new-api-main/docs/openapi/relay.json` + `new-api-main/router/relay-router.go` / `video-router.go`
- OpenAPI 覆盖接口数量：3

## 模块说明

- Relay 接口通常直接透传 OpenAI / Claude / Gemini / 视频平台兼容协议。
- 绝大多数接口需要令牌认证；少数下载类接口支持用户会话或令牌二选一。

## 接口明细

### POST /v1/audio/speech

- 摘要：文本转语音
- 请求方法：`POST`
- 路径：`/v1/audio/speech`

#### 路径 / Query 参数

- 无路径参数 / Query 参数。

#### 请求体

- Content-Type：`application/json`
- 请求体结构：`SpeechRequest`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| model | string | 请求体字段 | - |
| input | string | 请求体字段 | - |
| voice | string | 请求体字段 | alloy / echo / fable / onyx / nova / shimmer |
| response_format | string | 请求体字段 | mp3 / opus / aac / flac / wav / pcm |
| speed | number | 请求体字段 | - |

#### 响应格式

- 透传上游兼容协议响应，不再套用后台 `ApiResponse` 外层。

### POST /v1/audio/transcriptions

- 摘要：音频转录
- 请求方法：`POST`
- 路径：`/v1/audio/transcriptions`

#### 路径 / Query 参数

- 无路径参数 / Query 参数。

#### 请求体

- Content-Type：`multipart/form-data`
- 请求体结构：`object`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| file | string | 请求体字段 | - |
| model | string | 请求体字段 | - |
| language | string | 请求体字段 | - |
| prompt | string | 请求体字段 | - |
| response_format | string | 请求体字段 | json / text / srt / verbose_json / vtt |
| temperature | number | 请求体字段 | - |
| timestamp_granularities | array<string> | 请求体字段 | - |

#### 响应格式

- 透传上游兼容协议响应，不再套用后台 `ApiResponse` 外层。

### POST /v1/audio/translations

- 摘要：音频翻译
- 请求方法：`POST`
- 路径：`/v1/audio/translations`

#### 路径 / Query 参数

- 无路径参数 / Query 参数。

#### 请求体

- Content-Type：`multipart/form-data`
- 请求体结构：`object`

| 字段 | 类型 | 含义 | 取值范围 |
|---|---|---|---|
| file | string | 请求体字段 | - |
| model | string | 请求体字段 | - |
| prompt | string | 请求体字段 | - |
| response_format | string | 请求体字段 | - |
| temperature | number | 请求体字段 | - |

#### 响应格式

- 透传上游兼容协议响应，不再套用后台 `ApiResponse` 外层。

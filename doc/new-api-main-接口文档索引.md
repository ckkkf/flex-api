# new-api-main 接口文档索引

生成时间：2026-04-23

## API 管理面模块

- [系统](new-api-main-api-01-系统.md)
- [用户登陆注册](new-api-main-api-02-用户登陆注册.md)
- [OAuth](new-api-main-api-03-OAuth.md)
- [用户管理](new-api-main-api-04-用户管理.md)
- [充值](new-api-main-api-05-充值.md)
- [两步验证](new-api-main-api-06-两步验证.md)
- [安全验证](new-api-main-api-07-安全验证.md)
- [渠道管理](new-api-main-api-08-渠道管理.md)
- [令牌管理](new-api-main-api-09-令牌管理.md)
- [兑换码](new-api-main-api-10-兑换码.md)
- [日志](new-api-main-api-11-日志.md)
- [数据统计](new-api-main-api-12-数据统计.md)
- [分组](new-api-main-api-13-分组.md)
- [任务](new-api-main-api-14-任务.md)
- [供应商](new-api-main-api-15-供应商.md)
- [模型管理](new-api-main-api-16-模型管理.md)
- [系统设置](new-api-main-api-17-系统设置.md)

## API 管理面补充模块

- [订阅计费](new-api-main-api-extra-订阅计费.md)
- [自定义OAuth提供商](new-api-main-api-extra-自定义OAuth提供商.md)
- [模型部署](new-api-main-api-extra-模型部署.md)
- [性能运维](new-api-main-api-extra-性能运维.md)
- [旧版Dashboard Billing](new-api-main-api-extra-旧版Dashboard-Billing.md)

## Relay / 兼容协议模块

- [获取模型列表](new-api-main-relay-01-获取模型列表.md)
- [OpenAI格式(Chat)](new-api-main-relay-02-OpenAI格式-Chat.md)
- [OpenAI格式(Responses)](new-api-main-relay-03-OpenAI格式-Responses.md)
- [图片生成/Qwen千问](new-api-main-relay-04-图片生成-Qwen千问.md)
- [视频生成/Sora兼容格式](new-api-main-relay-05-视频生成-Sora兼容格式.md)
- [视频生成/Kling格式](new-api-main-relay-06-视频生成-Kling格式.md)
- [视频生成/即梦格式](new-api-main-relay-07-视频生成-即梦格式.md)
- [视频生成](new-api-main-relay-08-视频生成.md)
- [Claude格式(Messages)](new-api-main-relay-09-Claude格式-Messages.md)
- [Gemini格式](new-api-main-relay-10-Gemini格式.md)
- [OpenAI格式(Embeddings)](new-api-main-relay-11-OpenAI格式-Embeddings.md)
- [文本补全(Completions)](new-api-main-relay-12-文本补全-Completions.md)
- [OpenAI音频(Audio)](new-api-main-relay-13-OpenAI音频-Audio.md)
- [重排序(Rerank)](new-api-main-relay-14-重排序-Rerank.md)
- [Moderations](new-api-main-relay-15-Moderations.md)
- [Realtime](new-api-main-relay-16-Realtime.md)
- [未实现/Fine-tunes](new-api-main-relay-17-未实现-Fine-tunes.md)
- [未实现/Files](new-api-main-relay-18-未实现-Files.md)
- [中继-Midjourney](new-api-main-relay-extra-中继-Midjourney.md)
- [中继-Suno](new-api-main-relay-extra-中继-Suno.md)

## 说明

- 管理面接口优先基于 `new-api-main/docs/openapi/api.json` 生成。
- Relay 接口优先基于 `new-api-main/docs/openapi/relay.json` 生成，再补路由层未覆盖接口。
- 文档生成脚本：`doc/generate_new_api_docs.py`。后续如需刷新文档，可直接运行该脚本。
- 对于 OpenAPI 未给出精确响应 schema 的接口，文档会明确标注为统一 `ApiResponse<T>` 或分页结构，并对关键接口额外补充字段级响应说明。

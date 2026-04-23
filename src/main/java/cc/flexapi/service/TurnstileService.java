package cc.flexapi.service;

import reactor.core.publisher.Mono;

/**
 * @author ckkk
 * @version 1.0
 * @description
 * @since 2026-04-23 20:22
 */
public interface TurnstileService {
    /**
     * 验证 turnstile
     * @param turnstile turnstile
     * @return 验证结果
     */
    Mono<Boolean> verify(String turnstile);
}

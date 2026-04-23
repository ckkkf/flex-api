package cc.flexapi.service.impl;

import cc.flexapi.service.TurnstileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author ckkk
 * @version 1.0
 * @description
 * @since 2026-04-23 20:22
 */
@Slf4j
@Service
public class TurnstileServiceImpl implements TurnstileService {
    @Override
    public Mono<Boolean> verify(String turnstile) {
        // TODO 校验 turnstile
        return Mono.just(true);
    }
}

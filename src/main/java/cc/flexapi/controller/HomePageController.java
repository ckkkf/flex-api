package cc.flexapi.controller;

import cc.flexapi.model.response.R;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author ckkk
 * @version 1.0
 * TODO：写死
 * @since 2026-04-18 14:10
 */
@Slf4j
@RestController
public class HomePageController {

    @GetMapping("/home_page_content")
    public Mono<R<String>> getContent() {
        return R.ok(Mono.just("home_page_content"));
    }

    @GetMapping("/notice")
    public Mono<R<String>> getNotice() {
        return R.ok(Mono.just("notice"));
    }

}


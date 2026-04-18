package cc.flexapi.controller.homePage;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ckkk
 * @version 1.0
 * @description
 * @since 2026-04-18 14:10
 */
@Slf4j
@RestController
public class HomePageController {

    @GetMapping("/home_page_content")
    public String getContent() {
        return "home_page_content";
    }

    @GetMapping("/notice")
    public String getNotice() {
        return "notice";
    }

    @GetMapping("/status")
    public String getStatus() {
        return "status";
    }

}


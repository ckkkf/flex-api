package cc.flexapi.config;

import cn.dev33.satoken.reactor.filter.SaReactorFilter;
import cn.dev33.satoken.util.SaResult;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SaTokenConfig {

    @Bean
    public SaReactorFilter getSaReactorFilter() {
        return new SaReactorFilter()
                // 放行所有请求 = 完全不做任何权限控制
                .addInclude("/**")
                .addExclude("/**")

                // 空校验 = 不做登录/权限检查
                .setAuth(obj -> {})

                // 异常处理保留，不影响测试
                .setError(e -> SaResult.error("Sa-Token 拦截：" + e.getMessage()));
    }
}
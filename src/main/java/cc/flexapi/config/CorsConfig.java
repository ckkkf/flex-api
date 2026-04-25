package cc.flexapi.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 * WebFlux 全局跨域配置。
 *
 * <p>统一处理浏览器跨域访问，避免每个控制器单独加 {@code @CrossOrigin}。</p>
 *
 * @author ckkk
 * @since 2026-04-25
 */
@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(CorsProperties.class)
public class CorsConfig {

    private final CorsProperties corsProperties;

    /**
     * 注册全局跨域过滤器。
     *
     * <p>对整个应用路径生效，包含 `/api/**` 及其他 WebFlux 路径。</p>
     *
     * @return 全局 CORS 过滤器
     */
    @Bean
    @ConditionalOnProperty(prefix = "flexapi.cors", name = "enabled", havingValue = "true", matchIfMissing = true)
    public CorsWebFilter corsWebFilter() {
        CorsConfiguration configuration = new CorsConfiguration();

        // 允许哪些来源访问，使用 Pattern 兼容本地开发端口变化。
        configuration.setAllowedOriginPatterns(corsProperties.getAllowedOriginPatterns());
        // 允许的请求方法。
        configuration.setAllowedMethods(corsProperties.getAllowedMethods());
        // 允许前端携带的请求头。
        configuration.setAllowedHeaders(corsProperties.getAllowedHeaders());
        // 允许前端读取的响应头。
        configuration.setExposedHeaders(corsProperties.getExposedHeaders());
        // 允许携带 Cookie / Authorization 等凭证。
        configuration.setAllowCredentials(corsProperties.isAllowCredentials());
        // 预检请求缓存时间，减少浏览器重复 OPTIONS 请求。
        configuration.setMaxAge(corsProperties.getMaxAge());

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return new CorsWebFilter(source);
    }
}

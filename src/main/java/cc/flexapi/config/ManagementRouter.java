package cc.flexapi.config;


import cc.flexapi.handler.ManagementHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class ManagementRouter {

    @Bean
    public RouterFunction<ServerResponse> userRoutes(ManagementHandler handler) {
        return RouterFunctions.route()
                .path("/api/users", builder -> builder
                        // --- 不需要 ID 的操作 ---
                        .GET("", handler::listUsers)                    // GET /api/users (列表)
                        .POST("", handler::addUser)                     // POST /api/users (新增)
                        .GET("/search", handler::searchUser)            // GET /api/users/search (模糊搜索)

                        // --- 需要 ID 的操作 ---
                        .path("/{id}", idBuilder -> idBuilder
                                .GET("", handler::getUserById)              // GET /api/users/{id} (详情)
                                .PUT("", handler::editUser)                 // PUT /api/users/{id} (修改)
                                .DELETE("", handler::deleteUser)            // DELETE /api/users/{id} (删除)
                                .PATCH("/disable", handler::disableUser)    // PATCH /api/users/{id}/disable
                                .PATCH("/enable", handler::enableUser)      // PATCH /api/users/{id}/enable
                                .PATCH("/promote", handler::promoteUser)    // PATCH /api/users/{id}/promote
                                .PATCH("/demote", handler::demoteUser)      // PATCH /api/users/{id}/demote
                        )
                )
                .build();
    }
}
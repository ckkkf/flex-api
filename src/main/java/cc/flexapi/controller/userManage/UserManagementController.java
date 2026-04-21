package cc.flexapi.controller.userManage;


import cc.flexapi.domain.dto.UsersManagerDTO;
import cc.flexapi.model.request.UserManageRequest;
import cc.flexapi.model.response.R;
import cc.flexapi.service.ManagementService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Tag(name = "用户管理接口")
@RestController
@Slf4j
@RequestMapping(value = "/api/user",method = RequestMethod.POST)
public class UserManagementController {


    @Autowired
    private ManagementService managementService;

    public Mono<R<Void>> updateUser(@RequestBody UserManageRequest userManageRequest) {

        log.debug("更新用户信息");
        managementService.updateUser(userManageRequest);
        return R.ok(Mono.just("success").then());
    }

}

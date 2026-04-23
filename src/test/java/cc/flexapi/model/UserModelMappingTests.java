package cc.flexapi.model;

import cc.flexapi.model.dto.UserDto;
import cc.flexapi.model.mapper.ModelMapper;
import cc.flexapi.model.po.UserPo;
import cc.flexapi.model.vo.LoginVo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ckkk
 * @version 1.0
 * @description 用户模型映射测试
 * @since 2026-04-21 19:00
 */
class UserModelMappingTests {

    @Test
    void shouldMapUserPoToLoginVo() {
        UserPo userPO = new UserPo();
        userPO.setId(1);
        userPO.setUsername("flex-user");
        userPO.setPassword("hashed-password");
        userPO.setDisplayName("Flex User");
        userPO.setRole(10);
        userPO.setStatus(1);
        userPO.setEmail("flex@example.com");
        userPO.setGroup("default");

        UserDto userDTO = ModelMapper.toDto(userPO, UserDto.class);
        LoginVo loginVO = ModelMapper.toVo(userDTO, LoginVo.class);

        assertEquals(1, loginVO.getId());
        assertEquals("flex-user", loginVO.getUsername());
        assertEquals("Flex User", loginVO.getDisplayName());
        assertEquals(10, loginVO.getRole());
        assertEquals(1, loginVO.getStatus());
        assertEquals("default", loginVO.getGroup());
    }

    @Test
    void shouldFallbackDisplayNameToUsername() {
        UserPo userPO = new UserPo();
        userPO.setUsername("fallback-user");

        UserDto userDTO = ModelMapper.toDto(userPO, UserDto.class);

        assertEquals("fallback-user", userDTO.getDisplayName());
    }
}

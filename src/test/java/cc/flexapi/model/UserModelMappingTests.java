package cc.flexapi.model;

import cc.flexapi.model.dto.UserDTO;
import cc.flexapi.model.mapper.ModelMapper;
import cc.flexapi.model.po.UserPO;
import cc.flexapi.model.vo.LoginVO;
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
        UserPO userPO = new UserPO();
        userPO.setId(1);
        userPO.setUsername("flex-user");
        userPO.setPassword("hashed-password");
        userPO.setDisplayName("Flex User");
        userPO.setRole(10);
        userPO.setStatus(1);
        userPO.setEmail("flex@example.com");
        userPO.setGroup("default");

        UserDTO userDTO = ModelMapper.toDto(userPO, UserDTO.class);
        LoginVO loginVO = ModelMapper.toLoginVo(userDTO);

        assertEquals(1, loginVO.getId());
        assertEquals("flex-user", loginVO.getUsername());
        assertEquals("Flex User", loginVO.getDisplayName());
        assertEquals(10, loginVO.getRole());
        assertEquals(1, loginVO.getStatus());
        assertEquals("default", loginVO.getGroup());
    }

    @Test
    void shouldFallbackDisplayNameToUsername() {
        UserPO userPO = new UserPO();
        userPO.setUsername("fallback-user");

        UserDTO userDTO = ModelMapper.toDto(userPO, UserDTO.class);

        assertEquals("fallback-user", userDTO.getDisplayName());
    }
}

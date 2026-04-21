package cc.flexapi.model.mapper;

import cc.flexapi.model.dto.UserDTO;
import cc.flexapi.model.vo.LoginVO;
import org.springframework.beans.BeanUtils;

/**
 * @author ckkk
 * @version 1.0
 * @description 模型转换工具类
 * @since 2026-04-21 22:00
 */
public final class ModelMapper {

    private ModelMapper() {
    }

    public static <T> T toDto(Object source, Class<T> targetClass) {
        return copy(source, targetClass);
    }

    public static <T> T toVo(Object source, Class<T> targetClass) {
        return copy(source, targetClass);
    }

    public static LoginVO toLoginVo(UserDTO userDTO) {
        return toVo(userDTO, LoginVO.class);
    }

    private static <T> T copy(Object source, Class<T> targetClass) {
        if (source == null) {
            return null;
        }
        T target = BeanUtils.instantiateClass(targetClass);
        BeanUtils.copyProperties(source, target);
        applyRules(target);
        return target;
    }

    private static void applyRules(Object target) {
        if (target instanceof UserDTO userDTO
                && (userDTO.getDisplayName() == null || userDTO.getDisplayName().isBlank())) {
            userDTO.setDisplayName(userDTO.getUsername());
        }
    }
}

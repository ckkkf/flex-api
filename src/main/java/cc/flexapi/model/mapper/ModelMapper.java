package cc.flexapi.model.mapper;

import cn.hutool.core.bean.BeanUtil;

/**
 * @author ckkk
 * @version 1.0
 * @since 2026-04-23 20:43
 */
public class ModelMapper {

    /**
     * po 转 dto
     * @param po po
     * @param dtoClass dto class
     * @return dto
     * @param <PO> po
     * @param <DTO> dto
     */
    public static <PO, DTO> DTO toDto(PO po, Class<DTO> dtoClass) {
        return BeanUtil.copyProperties(po, dtoClass);
    }

    /**
     * dto 转 po
     * @param dto dto
     * @param poClass po class
     * @return po
     * @param <DTO> dto
     * @param <PO> po
     */
    public static <DTO, PO> PO toPo(DTO dto, Class<PO> poClass) {
        return BeanUtil.copyProperties(dto, poClass);
    }

    /**
     * dto 转 vo
     * @param dto dto
     * @param voClass vo class
     * @return vo
     * @param <DTO> dto
     * @param <VO> vo
     */
    public static <DTO, VO> VO toVo(DTO dto, Class<VO> voClass) {
        return BeanUtil.copyProperties(dto, voClass);
    }

}

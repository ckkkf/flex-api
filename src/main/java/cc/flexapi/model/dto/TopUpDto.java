package cc.flexapi.model.dto;

import lombok.Data;

/**
 * @author ckkk
 * @version 1.0
 * top_ups 表服务传输对象
 * @since 2026-04-21 19:00
 */
@Data
public class TopUpDto {

    /**
     * id
     */
    private Integer id;

    /**
     * user_id
     */
    private Integer userId;

    /**
     * amount
     */
    private Long amount;

    /**
     * money
     */
    private Double money;

    /**
     * trade_no
     */
    private String tradeNo;

    /**
     * payment_method
     */
    private String paymentMethod;

    /**
     * create_time
     */
    private Long createTime;

    /**
     * complete_time
     */
    private Long completeTime;

    /**
     * status
     */
    private String status;

}

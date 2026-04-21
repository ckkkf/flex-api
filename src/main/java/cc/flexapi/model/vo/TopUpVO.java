package cc.flexapi.model.vo;

import cc.flexapi.model.dto.TopUpDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author ckkk
 * @version 1.0
 * @description top_ups 表视图对象
 * @since 2026-04-21 19:00
 */
@Data
public class TopUpVO {

    /**
     * id
     */
    private Integer id;

    /**
     * user_id
     */
    @JsonProperty("user_id")
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
    @JsonProperty("trade_no")
    private String tradeNo;

    /**
     * payment_method
     */
    @JsonProperty("payment_method")
    private String paymentMethod;

    /**
     * create_time
     */
    @JsonProperty("create_time")
    private Long createTime;

    /**
     * complete_time
     */
    @JsonProperty("complete_time")
    private Long completeTime;

    /**
     * status
     */
    private String status;

}

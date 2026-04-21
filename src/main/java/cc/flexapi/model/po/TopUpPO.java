package cc.flexapi.model.po;

import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @author ckkk
 * @version 1.0
 * @description top_ups 表持久化对象
 * @since 2026-04-21 19:00
 */
@Data
@Table("top_ups")
public class TopUpPO {

    /**
     * id
     */
    @Id
    @Column("id")
    private Integer id;

    /**
     * user_id
     */
    @Column("user_id")
    private Integer userId;

    /**
     * amount
     */
    @Column("amount")
    private Long amount;

    /**
     * money
     */
    @Column("money")
    private Double money;

    /**
     * trade_no
     */
    @Column("trade_no")
    private String tradeNo;

    /**
     * payment_method
     */
    @Column("payment_method")
    private String paymentMethod;

    /**
     * create_time
     */
    @Column("create_time")
    private Long createTime;

    /**
     * complete_time
     */
    @Column("complete_time")
    private Long completeTime;

    /**
     * status
     */
    @Column("status")
    private String status;

}

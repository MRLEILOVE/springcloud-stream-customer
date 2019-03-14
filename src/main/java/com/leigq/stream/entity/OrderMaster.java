package com.leigq.stream.entity;

import com.leigq.common.springboot.bean.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 订单实体
 * <p>
 * 创建人：LeiGQ <br>
 * 创建时间：2019-03-06 20:45 <br>
 * <p>
 * 修改人： <br>
 * 修改时间： <br>
 * 修改备注： <br>
 * </p>
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class OrderMaster extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 6534536822902630499L;
    /**
	* 编号
	*/
    private String code;

    /**
	* 金额
	*/
    private BigDecimal amount;

    /**
	* 0:未支付;1:已支付
	*/
    private Boolean status;
}
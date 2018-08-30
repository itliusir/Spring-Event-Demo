package com.itliusir.event.entity;

import lombok.Data;

/**
 * 卡券
 *
 * @author liugang
 * @since 2018-08-28
 */
@Data
public class Coupon {

    private String id;

    private Integer type;

    private String name;

    private Integer amount;

    private Double money;
}

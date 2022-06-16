package com.imedia.service.authenticate.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AffiliateCreateOrderResponse {
    private String code;
    private String shortcode = "";
    private String packCode;
    private Long shopId = 0L;
    private String shopOrderCode;
    private int routeType = 0;
    private String expectPickTime;
    private String expectDeliverTime;
    private BigDecimal productValue = BigDecimal.ZERO;
    private BigDecimal cod = BigDecimal.ZERO;
    private BigDecimal feeCod = BigDecimal.ZERO;
    private BigDecimal feeInsurance = BigDecimal.ZERO;
    private BigDecimal fee = BigDecimal.ZERO;
    private int status = 0;
    private String statusText = "";
}

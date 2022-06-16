package com.imedia.service.authenticate.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class AffiliateDetailProduct {
    private String productName = "";
    private BigDecimal productValue;
    private Integer quantity;
    private BigDecimal cod;
}

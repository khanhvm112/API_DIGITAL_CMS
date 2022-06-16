package com.imedia.service.authenticate.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class AffiliateCreateOrderReceiver {
    private String receiverAddress;
    private String receiverProvinceCode;
    private String receiverDistrictCode;
    private String receiverWardCode;
    private String receiver;
    private String receiverPhone;
    private String expectDate = "";
    private String expectTime = "";
    private Integer length = 0;
    private Integer width= 0;
    private Integer height= 0;
    private Integer weight;
    private Integer partialDelivery = 0;
    private Integer isFree;
    private Integer confirmType;
    private Integer isRefund = 1;
    private Integer deliverShift = 0;
    private Integer requireNote = 3;
    private String note = "";
    private BigDecimal totalCod;
    private List<ExtraService> extraServices;
    private List<AffiliateDetailProduct> items;
}

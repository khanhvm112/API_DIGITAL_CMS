package com.imedia.service.authenticate.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AffiliateCreateOrder {
    private String packCode;
    private String shopOrderCode;
    private String sender;
    private String senderPhone;
    private String senderAddress;
    private Integer paymentType;
    private String senderProvinceCode;
    private String senderDistrictCode;
    private String senderWardCode;
    private String expectShipperPhone;
    private Integer pickupType = 2;
    private List<AffiliateCreateOrderReceiver> receiver;
}

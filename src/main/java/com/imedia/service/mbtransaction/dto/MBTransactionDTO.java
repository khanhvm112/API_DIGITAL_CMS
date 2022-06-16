package com.imedia.service.mbtransaction.dto;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
public class MBTransactionDTO {
    private Long id;

    private Integer serviceId;

    private Integer subServiceId;

    private Date createDate;

    private String productName;

    private String productValue;

    private String phone;

    private String email;

    private Integer phoneType;

    private Long quantity;

    private String status;

    private String transactionId;

    private Long cif;

    private Long amount;

    private Long holaTransactionCode;

    private String holaPhone;

    public MBTransactionDTO(Long id, Integer serviceId, Integer subServiceId, Date createDate, String productName, String productValue, String phone, String email, Integer phoneType, Long quantity, String status, String transactionId, Long cif, Long amount, Long holaTransactionCode, String holaPhone) {
        this.id = id;
        this.serviceId = serviceId;
        this.subServiceId = subServiceId;
        this.createDate = createDate;
        this.productName = productName;
        this.productValue = productValue;
        this.phone = phone;
        this.email = email;
        this.phoneType = phoneType;
        this.quantity = quantity;
        this.status = status;
        this.transactionId = transactionId;
        this.cif = cif;
        this.amount = amount;
        this.holaTransactionCode = holaTransactionCode;
        this.holaPhone = holaPhone;
    }
}

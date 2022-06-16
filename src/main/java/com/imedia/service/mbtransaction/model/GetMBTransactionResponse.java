package com.imedia.service.mbtransaction.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;




import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
public class GetMBTransactionResponse {
    private Long id;

    private String service;

    private String subService;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date createDate;

    private String productName;

    private String productValue;

    private String phone;

    private String email;

    private String phoneType;

    private Long quantity;

    private String status;

    private String transactionId;

    private Long cif;

    private Long amount;

    private Long holaTransactionCode;

    private String holaPhone;
}

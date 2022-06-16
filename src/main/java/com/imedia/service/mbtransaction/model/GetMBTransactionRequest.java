package com.imedia.service.mbtransaction.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
@Getter
@Setter
public class GetMBTransactionRequest {
    private String keyword;

    @NotNull
    private Integer serviceType;

    @NotNull
    private Integer serviceSubType;

    @NotNull
    private Long productId;

    private Integer status;

    @NotNull
    private Integer page;

    @NotNull
    private Integer pagesize;
}

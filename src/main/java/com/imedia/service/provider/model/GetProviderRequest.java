package com.imedia.service.provider.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class GetProviderRequest {

    private String keyword;

    @NotNull
    private Integer subServiceId;

    @NotNull
    private Integer provinceId;

    private String fromCreateDate;

    private String toCreateDate;

    @NotNull
    private Integer status;

    @NotNull
    private Integer page;

    @NotNull
    private Integer pagesize;
}

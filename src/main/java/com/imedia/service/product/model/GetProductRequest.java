package com.imedia.service.product.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class GetProductRequest {
    private String keyword;
    private Integer serviceId;
    private Integer providerId;
    private Integer status;
    @NotNull
//    @Min(value = 1, message = "Trang không được phép nhỏ hơn 1.")
    private Integer page;

    @NotNull
//    @Min(value = 1, message = "Kích thước trang không được phép nhỏ hơn 1.")
    private Integer pagesize;
}

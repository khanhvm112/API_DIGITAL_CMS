package com.imedia.service.product.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
@Getter
@Setter
@RequiredArgsConstructor
public class GetProductRespone {
    private Long id;


    private String productName;


    private Long productValue;


    private String providerName;




    private String serviceName;
    private Integer active;
}

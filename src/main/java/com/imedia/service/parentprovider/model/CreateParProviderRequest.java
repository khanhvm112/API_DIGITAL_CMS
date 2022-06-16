package com.imedia.service.parentprovider.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateParProviderRequest {
    private String providerCode;
    private String image;
    private Integer active;
}

package com.imedia.service.provider.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Getter
@Setter
public class CreateProviderRequest {

    private Long pid;

    private String provider_code;

    private String provider_name;

    private Integer sub_type;

    private Integer type;

    private String image;

    private String province;

    private Long province_id;

    private String prepaid_syntax;

    private String postpaid_syntax;

    private Long itopup_id;
}

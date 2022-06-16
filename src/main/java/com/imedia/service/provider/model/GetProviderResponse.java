package com.imedia.service.provider.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
public class
GetProviderResponse {
    private Long id;

    private Long pid;

    private Integer Active;

    private String provider_code;

    private String provider_name;

    private String sub_type;

    private String serviceName;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date create_date;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date update_date;

    private String image;

    private String province;

    private Long province_id;

    private String prepaid_syntax;

    private String postpaid_syntax;

    private Long itopup_id;
}

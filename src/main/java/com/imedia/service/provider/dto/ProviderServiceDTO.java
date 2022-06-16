package com.imedia.service.provider.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
public class ProviderServiceDTO {

    private Long id;
    private Long pid;
    private Integer active;
    private String provider_code;
    private String provider_name;
    private Integer sub_type;
    private String service_name;
    private Date create_date;
    private Date update_date;
    private String image;
    private String province;
    private Long province_id;
    private String prepaid_syntax;
    private String postpaid_syntax;
    private Long itopup_id;

    public ProviderServiceDTO(Long id, Long pid, Integer active, String provider_code, String provider_name, Integer sub_type, String service_name, Date create_date, Date update_date, String image, String province, Long province_id, String prepaid_syntax, String postpaid_syntax, Long itopup_id) {
        this.id = id;
        this.pid = pid;
        this.active = active;
        this.provider_code = provider_code;
        this.provider_name = provider_name;
        this.sub_type = sub_type;
        this.service_name = service_name;
        this.create_date = create_date;
        this.update_date = update_date;
        this.image = image;
        this.province = province;
        this.province_id = province_id;
        this.prepaid_syntax = prepaid_syntax;
        this.postpaid_syntax = postpaid_syntax;
        this.itopup_id = itopup_id;
    }
}

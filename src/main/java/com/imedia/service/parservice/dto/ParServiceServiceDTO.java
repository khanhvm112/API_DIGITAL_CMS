package com.imedia.service.parservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ParServiceServiceDTO {
    private Long id;

    private String serviceName;

    private String serviceType;

    private Date createDate;

    private Integer active;

    public ParServiceServiceDTO(Long id, String serviceName, String serviceType, Date createDate, Integer active) {
        this.id = id;
        this.serviceName = serviceName;
        this.serviceType = serviceType;
        this.createDate = createDate;
        this.active = active;
    }
}

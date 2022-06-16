package com.imedia.service.parservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateParServiceRequest {
    private String serviceName;

    private String serviceType;

    private Integer active;
}

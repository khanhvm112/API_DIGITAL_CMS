package com.imedia.service.subservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetSubServiceRequest {
    private String keyword;
    private Integer serviceID;
    private Integer status;
    private Integer page;
    private Integer pagesize;
}

package com.imedia.service.authenticate.model;

import lombok.Data;

@Data
public class AffiliateBaseResponse {
    private Integer code;
    private String message;
    private Object data;
}

package com.imedia.service.authenticate.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignInSetCache {
    private String token;
    private String username;
    private Integer userId;
    private String deviceId;
    private String requestService;
    private String role;
    private String name;
    private Integer warehouseId;
    private String warehouseName;
}

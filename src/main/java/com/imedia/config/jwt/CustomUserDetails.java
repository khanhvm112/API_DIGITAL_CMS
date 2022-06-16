package com.imedia.config.jwt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CustomUserDetails {
    private Integer id;
    private String username;
    private Integer rememberMe;
    private String role;
    private Integer warehouseId;
}

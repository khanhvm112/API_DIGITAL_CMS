package com.imedia.service.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserInfoRes {
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String username;
    private String passwordMd5;
    private Integer isSuperAdmin;
    private Integer status;
    private String salt;
    private Integer isLoginFirstTimel;
    private Integer groupId;
    private String role;
    private Integer warehouseId;
    private String warehouseName;
}

package com.imedia.service.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserInfoAddressData {
    private Integer wardId;
    private String provinceName = "";
    private String provinceCode = "";
    private String districtName = "";
    private String districtCode = "";
    private String wardName = "";
    private String wardCode = "";
    private String address = "";

    public UserInfoAddressData() {
    }

    public UserInfoAddressData(Integer wardId, String provinceName, String provinceCode, String districtName, String districtCode, String wardName, String wardCode) {
        this.wardId = wardId;
        this.provinceName = provinceName;
        this.provinceCode = provinceCode;
        this.districtName = districtName;
        this.districtCode = districtCode;
        this.wardName = wardName;
        this.wardCode = wardCode;
    }
}

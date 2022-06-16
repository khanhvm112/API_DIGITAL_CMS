package com.imedia.service.mbtransaction.enums;

public enum SubServiceEnum {
    ERROR(0,"Không tìm thấy loại dịch vụ"),
    TELECOM(1, "Thẻ điện thoại"),
    GAME(2,"Thẻ game"),
    DATA(3,"Thẻ data"),
    ELECTRICITY(4,"Hóa đơn điện"),
    WATER(5,"Hóa đơn nước"),
    MOBILE(6,"Hóa đơn di động"),
    TELEVISION(7,"Hóa đơn truyền hình"),
    INTERNET(8,"Hóa đơn Internet"),
    FINANCE(9,"Khoản vay"),
    INSURANCE(10,"Bảo hiểm"),
    LUCKYBEST(11,"Luckybest");

    public final int code;
    public final String name;

    SubServiceEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }
    public static SubServiceEnum valueOf(int value) {
        for (SubServiceEnum val : values()) {
            if (val.code == value)
                return val;
        }
        return SubServiceEnum.ERROR;
    }
}

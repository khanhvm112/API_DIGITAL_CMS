package com.imedia.service.mbtransaction.enums;

public enum ParServiceEnum {
    ERROR(0,"Không tìm thấy loại dịch vụ"),
    TOPUP(1, "Nạp trực tiếp"),
    BILLING(2,"Thẻ game"),
    DOWNLOAD(3,"Mua mã thẻ");

    public final int code;
    public final String name;

    ParServiceEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }
    public static ParServiceEnum valueOf(int value) {
        for (ParServiceEnum val : values()) {
            if (val.code == value)
                return val;
        }
        return ParServiceEnum.ERROR;
    }
}

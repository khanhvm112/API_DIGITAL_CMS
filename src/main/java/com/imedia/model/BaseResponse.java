package com.imedia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.imedia.util.PreloadUtil;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class BaseResponse {
    private Integer status;
    private String message;
    private Object data;
    @JsonIgnore
    static final List<Integer> successCodes = Arrays.asList(200, 3000, 4000, 5000);
    static final List<Integer> failedSystemCodes = Arrays.asList(401, 142, 666, 402, 302, 303, 304, 305);

    public BaseResponse(Integer status, int type) {
        if (successCodes.contains(status))
            this.status = 200;
        else this.status = status;
        setMessage(status);
    }

    public BaseResponse(Integer status) {
        if (successCodes.contains(status))
            this.status = 200;
        else
            this.status = status;
        if (failedSystemCodes.contains(status))
            setMessage("Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại");
        else
            setMessage(this.status);
    }

    public BaseResponse(Integer status, Object data) {
        if (successCodes.contains(status))
            this.status = 200;
        else
            this.status = status;
        if (failedSystemCodes.contains(status))
            setMessage("Có lỗi hệ thống trong quá trình thực hiện giao dịch, vui lòng thử lại");
        else
            setMessage(this.status);
        this.data = data;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private void setMessage(int status) {
        try {
            ErrorCode errorCodes = PreloadUtil.errorCodes.get(status);
            if (errorCodes != null) {
                this.message = errorCodes.message;
            } else this.message = PreloadUtil.errorCodes.get(1).message;
        } catch (Exception e) {
            this.message = "Không tìm thấy mã lỗi";
        }
    }
}

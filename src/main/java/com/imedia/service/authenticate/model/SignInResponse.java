package com.imedia.service.authenticate.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class SignInResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private String token = "";
    private String sessionKey = "";
    private String message;
    private Integer status;
    private String username;
    private Object userInfo;
    private Object data;

    public SignInResponse() {
    }

    public SignInResponse(String message, Integer status) {
        this.message = message;
        this.status = status;
    }

}
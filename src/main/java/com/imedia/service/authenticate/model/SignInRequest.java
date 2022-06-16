package com.imedia.service.authenticate.model;

import com.imedia.model.BaseRequest;

import java.io.Serializable;

public class SignInRequest extends BaseRequest implements Serializable {

    private final long serialVersionUID = 5926468583005150707L;

    private String username;
    private String password;
    private String deviceId;
    private String key;
    private Integer rememberMe;
    private String requestService;

    //need default constructor for JSON Parsing
    public SignInRequest() {
    }

    public SignInRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public Integer getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(Integer rememberMe) {
        this.rememberMe = rememberMe;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getRequestService() {
        return requestService;
    }

    public void setRequestService(String requestService) {
        this.requestService = requestService;
    }
}
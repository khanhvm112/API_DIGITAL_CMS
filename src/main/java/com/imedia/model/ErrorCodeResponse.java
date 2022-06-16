package com.imedia.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorCodeResponse {
    private Integer errorCode;
    private String message;
}

package com.imedia.service.parservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
@Getter
@Setter
public class GetParServiceRequest {
    private String keyword;

    @NotNull
    private Integer active;

    @NotNull
    private Integer page;

    @NotNull
    private Integer pagesize;
}

package com.imedia.service.parservice.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class UpdateParServiceRequest {
    @NotNull
    private Long id;

    @NotBlank
    private String serviceNameEdit;

    @NotBlank
    private String serviceTypeEdit;
}

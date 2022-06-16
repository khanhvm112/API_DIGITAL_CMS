package com.imedia.service.subservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CreateSubServiceRequest {
    private Long typeId;
    @NotBlank
    private String subService_name;
}

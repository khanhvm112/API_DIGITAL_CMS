package com.imedia.service.subservice.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateSubServiceRequest extends CreateSubServiceRequest {
    @NotNull
    private Long id;
}

package com.imedia.service.provider.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateProviderRequest extends CreateProviderRequest{
    @NotNull
    private Long id;
}

package com.imedia.service.provider.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InactiveProviderRequest {
    @NotNull
    private Long id;
}

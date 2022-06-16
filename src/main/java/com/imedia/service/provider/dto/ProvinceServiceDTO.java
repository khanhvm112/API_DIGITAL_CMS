package com.imedia.service.provider.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
@Getter
@Setter
@NoArgsConstructor
public class ProvinceServiceDTO {
    private Long id;

    private String name;


    public ProvinceServiceDTO(Long id, String name) {
        this.id = id;
        this.name = name;

    }
}

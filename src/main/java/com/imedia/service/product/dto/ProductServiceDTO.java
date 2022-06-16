package com.imedia.service.product.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class ProductServiceDTO {
    private Long id;
    private String product_name;
    private Long product_value;
    private String provider_name;
    private String service_name;
    private Integer active;

    public ProductServiceDTO(Long id, String product_name, Long product_value, String provider_name, String service_name, Integer active) {
        this.id = id;
        this.product_name = product_name;
        this.product_value = product_value;
        this.provider_name = provider_name;
        this.service_name = service_name;
        this.active = active;
    }
}

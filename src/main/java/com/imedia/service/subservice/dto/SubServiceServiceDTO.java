package com.imedia.service.subservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class SubServiceServiceDTO {
    private Long id;
    private String subserviceName;
    private Integer typeId;
    private Date createDate;
    private Date updateDate;
    private Integer active;

    public SubServiceServiceDTO(Long id, String subserviceName, Integer typeId, Date createDate, Date updateDate, Integer active) {
        this.id = id;
        this.subserviceName = subserviceName;
        this.typeId = typeId;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.active = active;
    }
}

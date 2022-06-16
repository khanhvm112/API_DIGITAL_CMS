package com.imedia.service.parservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
public class GetParServiceResponse {
    private Long id;

    private String serviceName;

    private String serviceType;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date createDate;

    private Integer active;
}

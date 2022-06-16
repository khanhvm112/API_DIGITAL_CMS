package com.imedia.service.subservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
public class GetSubServiceResponse {
    private Long id;

    private String subserviceName;

    private Integer typeId;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date createDate;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date updateDate;

    private String userName;

    private Integer active;
}

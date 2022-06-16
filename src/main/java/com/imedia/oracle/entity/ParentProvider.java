package com.imedia.oracle.entity;

import com.imedia.service.provider.dto.ProvinceServiceDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name= "TOPUP_PARENT_PROVIDER")
@Getter
@Setter
@NoArgsConstructor
public class ParentProvider implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "TOPUP_PARENT_PROVIDER_SEQ", sequenceName = "TOPUP_PARENT_PROVIDER_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TOPUP_PARENT_PROVIDER_SEQ")
    @Column(name = "ID")
    private Long id;

    @Column(name = "PROVIDER_CODE")
    private String providerCode;

    @Column(name = "ACTIVE")
    private Integer active;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "IMAGE")
    private String image;
}

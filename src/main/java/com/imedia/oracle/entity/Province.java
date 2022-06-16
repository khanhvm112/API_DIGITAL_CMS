package com.imedia.oracle.entity;

import com.imedia.service.provider.dto.ProviderServiceDTO;
import com.imedia.service.provider.dto.ProvinceServiceDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name= "PROVINCES")
@SqlResultSetMapping(
        name = "GetProvincesDetailMapping",
        classes = {
                @ConstructorResult(
                        targetClass = ProvinceServiceDTO.class,
                        columns = {
                                @ColumnResult(name = "ID", type = Long.class),
                                @ColumnResult(name = "NAME", type = String.class)
                        }

                )
        }
)
@Getter
@Setter
@NoArgsConstructor
public class Province implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "PROVINCES_SEQ", sequenceName = "PROVINCES_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROVINCES_SEQ")
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CODE")
    private String code;

    @Column(name = "RANK")
    private Integer rank;

    @Column(name = "STATUS")
    private Integer status;

    @Column(name = "SHORTCODE")
    private String shortCode;

    @Column(name = "CARRIER_CODE")
    private String carrierCode;
}

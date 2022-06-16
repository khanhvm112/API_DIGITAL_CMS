package com.imedia.oracle.entity;


import com.imedia.service.subservice.dto.SubServiceServiceDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TOPUP_SUBSERVICE")
@SqlResultSetMapping(
        name = "GetSubServiceDetailMapping",
        classes = {
                @ConstructorResult(
                        targetClass = SubServiceServiceDTO.class,
                        columns = {
                                @ColumnResult(name = "ID", type = Long.class),
                                @ColumnResult(name = "SUBSERVICE_NAME", type = String.class),
                                @ColumnResult(name = "TYPE_ID", type = Integer.class),
                                @ColumnResult(name = "CREATE_DATE", type = Date.class),
                                @ColumnResult(name = "UPDATE_DATE", type = Date.class),
                                @ColumnResult(name = "ACTIVE", type = Integer.class),
                        }

                )
        }
)
@Getter
@Setter
@NoArgsConstructor
public class SubService implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "TOPUP_SERVICE_SEQ", sequenceName = "TOPUP_SERVICE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TOPUP_SERVICE_SEQ")
    @Column(name = "ID")
    private Long id;

    @Column(name = "SUBSERVICE_NAME")
    private String subServiceName;

    @Column(name = "TYPE_ID")
    private Long typeId;

    @Column(name = "ACTIVE")
    private Integer active;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "CREATE_DATE")
    private Date createDate;

    @UpdateTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "UPDATE_DATE")
    private Date updateDate;
}

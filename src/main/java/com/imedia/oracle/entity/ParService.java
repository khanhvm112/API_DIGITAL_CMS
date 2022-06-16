package com.imedia.oracle.entity;

import com.imedia.service.parservice.dto.ParServiceServiceDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TOPUP_SERVICE")
@SqlResultSetMapping(
        name = "GetServiceDetailMapping",
        classes = {
                @ConstructorResult(
                        targetClass = ParServiceServiceDTO.class,
                        columns = {
                                @ColumnResult(name = "ID", type = Long.class),
                                @ColumnResult(name = "SERVICE_NAME", type = String.class),
                                @ColumnResult(name = "SERVICE_TYPE", type = String.class),
                                @ColumnResult(name = "CREATE_DATE", type = Date.class),
                                @ColumnResult(name = "ACTIVE", type = Integer.class)
                        }

                )
        }
)
@Getter
@Setter
@NoArgsConstructor
public class ParService implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "TOPUP_SERVICE_SEQ", sequenceName = "TOPUP_SERVICE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TOPUP_SERVICE_SEQ")
    @Column(name = "ID")
    private Long id;

    @Column(name = "SERVICE_NAME")
    private String serviceName;

    @Column(name = "SERVICE_TYPE")
    private String serviceType;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "ACTIVE")
    private Integer active;
}

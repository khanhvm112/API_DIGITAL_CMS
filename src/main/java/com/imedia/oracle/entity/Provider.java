package com.imedia.oracle.entity;

import com.imedia.service.provider.dto.ProviderServiceDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the TOPUP_PROVIDER database table.
 */
@Entity
@Table(name = "TOPUP_PROVIDER")
@SqlResultSetMapping(
        name = "GetProviderDetailMapping",
        classes = {
                @ConstructorResult(
                        targetClass = ProviderServiceDTO.class,
                        columns = {
                                @ColumnResult(name = "ID", type = Long.class),
                                @ColumnResult(name = "PID", type = Long.class),
                                @ColumnResult(name = "ACTIVE", type = Integer.class),
                                @ColumnResult(name = "PROVIDER_CODE", type = String.class),
                                @ColumnResult(name = "PROVIDER_NAME", type = String.class),
                                @ColumnResult(name = "SUB_TYPE", type = Integer.class),
                                @ColumnResult(name = "SERVICE_NAME", type = String.class),
                                @ColumnResult(name = "CREATE_DATE", type = Date.class),
                                @ColumnResult(name = "UPDATE_DATE", type = Date.class),
                                @ColumnResult(name = "IMAGE", type = String.class),
                                @ColumnResult(name = "PROVINCE", type = String.class),
                                @ColumnResult(name = "PROVINCE_ID", type = Long.class),
                                @ColumnResult(name = "PREPAID_SYNTAX", type = String.class),
                                @ColumnResult(name = "POSTPAID_SYNTAX", type = String.class),
                                @ColumnResult(name = "ITOPUP_ID", type = Long.class),
                        }

                )
        }
)
@Getter
@Setter
@NoArgsConstructor
public class Provider implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "TOPUP_PROVIDER_SEQ", sequenceName = "TOPUP_PROVIDER_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TOPUP_PROVIDER_SEQ")
    @Column(name = "ID")
    private Long id;

    @Column(name = "PID")
    private Long pid;

    @Column(name = "ACTIVE")
    private Integer active;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "IMAGE")
    private String image;

    @Column(name = "PROVIDER_CODE")
    private String providerCode;

    @Column(name = "PROVIDER_NAME")
    private String providerName;

    @Column(name = "SUB_TYPE")
    private Integer subType;

    @Column(name = "TYPE")
    private Integer type;

    @UpdateTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "UPDATE_DATE")
    private Date updateDate;

    @Column(name = "PROVINCE")
    private String province;

    @Column(name = "PROVINCE_ID")
    private Long provinceId;

    @Column(name = "PREPAID_SYNTAX")
    private String prepaidSyntax;

    @Column(name = "POSTPAID_SYNTAX")
    private String postpaidSyntax;

    @Column(name = "ITOPUP_ID")
    private Long itopupid;
}

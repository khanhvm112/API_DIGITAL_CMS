package com.imedia.oracle.entity;

import com.imedia.service.mbtransaction.dto.MBTransactionDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TOPUP_MB_BANK_TRANSACTION")
@SqlResultSetMapping(
        name = "GetMBTransactionDetailMapping",
        classes = {
                @ConstructorResult(
                        targetClass = MBTransactionDTO.class,
                        columns = {
                                @ColumnResult(name = "ID", type = Long.class),
                                @ColumnResult(name = "SERVICE_TYPE", type = Integer.class),
                                @ColumnResult(name = "SERVICE_SUBTYPE", type = Integer.class),
                                @ColumnResult(name = "CREATED_DATE", type = Date.class),
                                @ColumnResult(name = "PRODUCT_NAME", type = String.class),
                                @ColumnResult(name = "PRODUCT_VALUE", type = String.class),
                                @ColumnResult(name = "PHONE_TRANSACTION", type = String.class),
                                @ColumnResult(name = "EMAIL", type = String.class),
                                @ColumnResult(name = "PHONE_TYPE", type = Integer.class),
                                @ColumnResult(name = "QUANTITY", type = Long.class),
                                @ColumnResult(name = "STATUS", type = String.class),
                                @ColumnResult(name = "TRANSACTION_ID", type = String.class),
                                @ColumnResult(name = "CIF", type = Long.class),
                                @ColumnResult(name = "AMOUNT", type = Long.class),
                                @ColumnResult(name = "HOLA_TRANSACTION_CODE", type = Long.class),
                                @ColumnResult(name = "PHONE_USER", type = String.class),
                        }

                )
        }
)
@Getter
@Setter
@NoArgsConstructor
public class MBTransaction implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "TOPUP_MB_BANK_TRANSACTION_SEQ", sequenceName = "TOPUP_MB_BANK_TRANSACTION_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TOPUP_MB_BANK_TRANSACTION_SEQ")
    @Column(name = "ID")
    private Long id;

    @Column(name = "SERVICE_TYPE")
    private Integer serviceType;

    @Column(name = "SERVICE_SUBTYPE")
    private Integer serviceSubType;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "CREATED_DATE")
    private Date createDate;

    @Column(name = "PROVIDER_ID")
    private Long providerId;

    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE_TYPE")
    private Integer phoneType;

    @Column(name = "QUANTITY")
    private Long quantity;

    @Column(name = "STATUS")
    private Integer status;

    @Column(name = "TRANSACTION_ID")
    private String transactionId;

    @Column(name = "CIF")
    private Long cif;

    @Column(name = "AMOUNT")
    private Long amount;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "HOLA_TRANSACTION_CODE")
    private Long holaTransactionCode;

    @Column(name = "HOLA_USER_ID")
    private Long holaUserId;

}
package com.imedia.oracle.entity;

import com.imedia.service.product.dto.ProductServiceDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "TOPUP_PRODUCTS")
@SqlResultSetMapping(
        name = "GetProductDetailMapping",
        classes = {
                @ConstructorResult(
                        targetClass = ProductServiceDTO.class,
                        columns = {
                                @ColumnResult(name = "ID", type = Long.class),
                                @ColumnResult(name = "PRODUCT_NAME", type = String.class),
                                @ColumnResult(name = "PRODUCT_VALUE", type = Long.class),
                                @ColumnResult(name = "PROVIDER_NAME", type = String.class),
                                @ColumnResult(name = "SERVICE_NAME", type = String.class),
                                @ColumnResult(name = "ACTIVE", type = Integer.class),
                        }

                )
        }
)
@Getter
@Setter
@NoArgsConstructor
public class Product {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "TOPUP_PRODUCTS_SEQ", sequenceName = "TOPUP_PRODUCTS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TOPUP_PRODUCTS_SEQ")
    @Column(name = "ID")
    private Long id;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "PRODUCT_VALUE")
    private Long productValue;

    @Column(name = "PROVIDER_ID")
    private Long providerId;

    @Column(name = "ACTIVE")
    private Integer active;

//    @CreationTimestamp
//    @Temporal(TemporalType.DATE)
//    @Column(name = "CREATE_DATE")
//    private Date createDate;

//    @UpdateTimestamp
//    @Temporal(TemporalType.DATE)
//    @Column(name = "UPDATE_DATE")
//    private Date updateDate;

    @Column(name = "SERVICE_TYPE")
    private Long serviceType;


}

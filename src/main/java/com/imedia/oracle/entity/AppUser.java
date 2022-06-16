package com.imedia.oracle.entity;

import com.imedia.service.user.model.UserInfoAddressData;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the APP_USERS database table.
 */
@Entity
@Table(name = "APP_USERS")
@Data
@SqlResultSetMapping(
        name = "CacheAddressMapping",
        classes = {
                @ConstructorResult(
                        targetClass = UserInfoAddressData.class,
                        columns = {
                                @ColumnResult(name = "WARD_ID", type = Integer.class),
                                @ColumnResult(name = "PROVINCE_NAME", type = String.class),
                                @ColumnResult(name = "PROVINCE_CODE", type = String.class),
                                @ColumnResult(name = "DISTRICT_NAME", type = String.class),
                                @ColumnResult(name = "DISTRICT_CODE", type = String.class),
                                @ColumnResult(name = "WARD_NAME", type = String.class),
                                @ColumnResult(name = "WARD_CODE", type = String.class),
                        }
                )
        }
)
public class AppUser implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
//    @SequenceGenerator(name = "ISEQ$$_73923", sequenceName = "ISEQ$$_73923", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ISEQ$$_73923")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", insertable = false)
    private long id;

    @Column(name = "ACCESS_TOKEN")
    private String accessToken;

    @Column(name = "ACCOUNT_CODE")
    private String accountCode;

    @Column(name = "ADDRESS_ID")
    private BigDecimal addressId;

    private String avatar;

    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Column(name = "CALLBACK_URL")
    private String callbackUrl;

    private String company;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_AT", updatable = false)
    private Date createAt;

    private String email;

    @Column(name = "FACEBOOK_ID")
    private String facebookId;

    private String identify;

    @Column(name = "IDENTIFY_ROLE_TYPE")
    private Integer identifyRoleType;

    @Column(name = "IDENTITY_CARD")
    private String identityCard;

    private String name;

    private BigDecimal partner = BigDecimal.ZERO;

    private String password;

    private String phone;

    private Integer point = 0;

    @Column(name = "PROFILE_LEVEL")
    private Integer profileLevel;

    private Integer rating;

    private Integer sex = 3;

    private Integer ship = 0;

    private Integer shop = 0;

    private String types;

    @Column(name = "USER_GROUP_ID")
    private Integer userGroupId = 0;

    @UpdateTimestamp
    @Column(name = "UTIMESTAMP")
    private Timestamp utimestamp;

    @Column(name = "VA_ID")
    private String vaId;

    @Column(name = "VA_TOKEN")
    private String vaToken;

    @Column(name = "WALLET_SHIP_ID")
    private BigDecimal walletShipId = BigDecimal.ZERO;

    @Column(name = "WALLET_SHOP_ID")
    private BigDecimal walletShopId = BigDecimal.ZERO;

    @Column(name = "ACCOUNT_EPURSE_ID")
    private BigDecimal accountEpurseId;

    @Column(name = "ALLOW_WITHDRAW")
    private Integer allowWithdraw;

}
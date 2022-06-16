package com.imedia.oracle.dao;

import com.imedia.service.mbtransaction.dto.MBTransactionDTO;
import com.imedia.service.mbtransaction.model.GetMBTransactionRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MBTransactionDAO {
    private final EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<MBTransactionDTO> getListMBTransaction(GetMBTransactionRequest request) {
        StringBuilder sql = new StringBuilder(" SELECT" +
                "        a.ID," +
                "        a.SERVICE_TYPE," +
                "        a.SERVICE_SUBTYPE," +
                "        a.CREATED_DATE," +
                "        a.PROVIDER_ID," +
                "        a.PRODUCT_ID," +
                "        a.EMAIL," +
                "        a.PHONE_TYPE," +
                "        a.PHONE AS PHONE_TRANSACTION," +
                "        a.QUANTITY," +
                "        a.STATUS," +
                "        a.TRANSACTION_ID," +
                "        a.CIF," +
                "        a.AMOUNT," +
                "        a.TYPE," +
                "        a.HOLA_TRANSACTION_CODE," +
                "        a.HOLA_USER_ID," +
                "        d.PHONE AS PHONE_USER," +
                "        e.PRODUCT_NAME," +
                "        e.PRODUCT_VALUE" +
                "        FROM" +
                "        TOPUP_MB_BANK_TRANSACTION a" +
                "        LEFT JOIN APP_USERS d ON a.HOLA_USER_ID = d.ID" +
                "        LEFT JOIN TOPUP_PRODUCTS e ON a.PRODUCT_ID = e.ID ");
        sql.append(" WHERE ( LOWER( a.TRANSACTION_ID ) LIKE LOWER( CONCAT( CONCAT( '%', ' ")
                .append(request.getKeyword())
                .append("'), '%'))")
                .append(" OR LOWER(a.CIF) LIKE LOWER(CONCAT(CONCAT('%', '")
                .append(request.getKeyword())
                .append("'), '%'))")
                .append(" OR LOWER(a.HOLA_TRANSACTION_CODE) LIKE LOWER(CONCAT(CONCAT('%', '")
                .append(request.getKeyword())
                .append("'), '%'))")
                .append(" OR LOWER(d.PHONE) LIKE LOWER(CONCAT(CONCAT('%', '")
                .append(request.getKeyword())
                .append("'), '%'))")
                .append(" OR LOWER(a.PHONE) LIKE LOWER(CONCAT(CONCAT('%', '")
                .append(request.getKeyword())
                .append("'), '%'))")
                .append(" OR LOWER(a.EMAIL) LIKE LOWER(CONCAT(CONCAT('%', '")
                .append(request.getKeyword())
                .append("'), '%'))")
                .append(")");
        if(request.getServiceType() != null && request.getServiceType() != -1){
            sql.append(" AND a.SERVICE_TYPE = ")
                    .append(request.getServiceType());
        }
        if(request.getServiceSubType() != null && request.getServiceSubType() != -1){
            sql.append(" AND a.SERVICE_SUBTYPE = ")
                    .append(request.getServiceSubType());
        }
        if(request.getProductId() != null && request.getProductId() != -1){
            sql.append(" AND a.PRODUCT_ID = ")
                    .append(request.getProductId());
        }
        if(request.getStatus() != null){
            sql.append(" AND a.STATUS = ")
                    .append(request.getStatus());
        }
        sql.append(" OFFSET ")
                .append(request.getPage() * request.getPagesize())
                .append(" ROWS FETCH NEXT ")
                .append(request.getPagesize())
                .append(" ROWS ONLY");
        Query query = entityManager.createNativeQuery(sql.toString(), "GetMBTransactionDetailMapping");
        return query.getResultList();
    }
}

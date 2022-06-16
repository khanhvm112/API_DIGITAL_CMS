package com.imedia.oracle.dao;

import com.imedia.service.product.dto.ProductServiceDTO;
import com.imedia.service.product.model.GetProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductDAO {
    private final EntityManager entityManager;

    public List<ProductServiceDTO> getListProduct(GetProductRequest getProductRequest){
    StringBuilder sql = new StringBuilder(" SELECT a.ID, a.PRODUCT_NAME, a.PRODUCT_VALUE, a.PROVIDER_ID, a.SERVICE_TYPE, a.ACTIVE, b.PROVIDER_NAME, c.SERVICE_NAME " +
            " FROM TOPUP_PRODUCTS a " +
            " LEFT JOIN TOPUP_PROVIDER b ON a.PROVIDER_ID = b.ID " +
            " LEFT JOIN TOPUP_SERVICE c ON a.SERVICE_TYPE = c.ID ");
    sql.append(" WHERE ( LOWER(a.PRODUCT_NAME) LIKE LOWER(CONCAT(CONCAT('%', '")
            .append(getProductRequest.getKeyword())
            .append("'), '%')) )");
    if (getProductRequest.getProviderId() != null && getProductRequest.getProviderId() != -1){
        sql.append(" AND a.PROVIDER_ID = ")
                .append(getProductRequest.getProviderId());
    }
    if (getProductRequest.getServiceId() != null && getProductRequest.getServiceId() != -1){
        sql.append(" AND a.SERVICE_TYPE = ")
                .append(getProductRequest.getServiceId());
    }
    if(getProductRequest.getStatus() != null && getProductRequest.getStatus() != -1){
        sql.append(" AND a.ACTIVE = ")
                .append(getProductRequest.getStatus());
    }
    sql.append(" OFFSET ")
            .append(getProductRequest.getPage() * getProductRequest.getPagesize())
            .append(" ROWS FETCH NEXT ")
            .append(getProductRequest.getPagesize())
            .append(" ROWS ONLY ");
    Query query = entityManager.createNativeQuery(sql.toString(), "GetProductDetailMapping");
    return query.getResultList();
    }
}


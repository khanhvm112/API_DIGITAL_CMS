package com.imedia.oracle.dao;

import com.imedia.service.provider.dto.ProviderServiceDTO;
import com.imedia.service.provider.dto.ProvinceServiceDTO;
import com.imedia.service.provider.model.GetProviderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProviderDAO {
    private final EntityManager entityManager;

    public List<ProviderServiceDTO> getListProvider(GetProviderRequest request) {
        StringBuilder sql = new StringBuilder("SELECT a.ID, a.PID, a.ACTIVE, a.PROVIDER_CODE, a.PROVIDER_NAME, a.SUB_TYPE, b.SERVICE_NAME, a.CREATE_DATE, a.UPDATE_DATE," +
                " a.IMAGE, a.PROVINCE, a.PROVINCE_ID, a.PREPAID_SYNTAX, a.POSTPAID_SYNTAX, a.ITOPUP_ID " +
                " FROM TOPUP_PROVIDER a " +
                " LEFT JOIN TOPUP_SERVICE b ON a.TYPE = b.ID "
        );
        sql.append("  WHERE ( LOWER(PROVIDER_CODE) LIKE LOWER(CONCAT(CONCAT('%', '")
                .append(request.getKeyword())
                .append("'), '%')) )");
        if(request.getSubServiceId() != null && request.getSubServiceId() != -1){
            sql.append(" AND a.SUB_TYPE = ")
                    .append(request.getSubServiceId());
        }
        if(request.getProvinceId() != null && request.getProvinceId() != -1 && request.getSubServiceId() == 5){
            sql.append(" AND a.PROVINCE_ID = ")
                    .append(request.getProvinceId());
        }
        if(request.getStatus() != null && request.getStatus() != -1){
            sql.append(" AND a.ACTIVE = ")
                    .append(request.getStatus());
        }
        sql.append(" OFFSET ")
                .append(request.getPage() * request.getPagesize())
                .append(" ROWS FETCH NEXT ")
                .append(request.getPagesize())
                .append(" ROWS ONLY");
        Query query = entityManager.createNativeQuery(sql.toString(), "GetProviderDetailMapping");
        return query.getResultList();
    }
    public List<ProvinceServiceDTO> getListProvince(){
        StringBuilder sql = new StringBuilder("SELECT a.NAME,a.ID FROM PROVINCES a");
        Query query = entityManager.createNativeQuery(sql.toString(), "GetProvincesDetailMapping");
        return query.getResultList();
    }
}


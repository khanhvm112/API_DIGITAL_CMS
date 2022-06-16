package com.imedia.oracle.dao;

import com.imedia.service.subservice.dto.SubServiceServiceDTO;
import com.imedia.service.subservice.model.GetSubServiceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SubServiceDAO {
    private final EntityManager entityManager;

    public List<SubServiceServiceDTO> getListService(GetSubServiceRequest request) {
        StringBuilder sql = new StringBuilder( " SELECT a.ID, a.SUBSERVICE_NAME, a.ACTIVE, a.CREATE_DATE, a.UPDATE_DATE, a.TYPE_ID  " +
                " FROM TOPUP_SUBSERVICE a " );
        sql.append(" WHERE ( LOWER(a.SUBSERVICE_NAME) LIKE LOWER(CONCAT(CONCAT('%', '")
                .append(request.getKeyword())
                .append("'), '%')) )");
        if (request.getServiceID() != null){
            sql.append(" AND a.TYPE_ID = ")
                    .append(request.getServiceID());
        }
        if(request.getStatus() != null && request.getStatus() != -1){
            sql.append(" AND a.ACTIVE = ")
                    .append(request.getStatus());
        }
        sql.append(" OFFSET ")
                .append(request.getPage() * request.getPagesize())
                .append(" ROWS FETCH NEXT ")
                .append(request.getPagesize())
                .append(" ROWS ONLY ");
        Query query = entityManager.createNativeQuery(sql.toString(), "GetSubServiceDetailMapping");
        return query.getResultList();
    }
}

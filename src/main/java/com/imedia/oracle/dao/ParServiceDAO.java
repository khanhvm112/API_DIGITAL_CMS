package com.imedia.oracle.dao;

import com.imedia.service.parservice.dto.ParServiceServiceDTO;
import com.imedia.service.parservice.model.GetParServiceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ParServiceDAO {
    private final EntityManager entityManager;
    public List<ParServiceServiceDTO> getListService(GetParServiceRequest request){
        StringBuilder sql = new StringBuilder("SELECT * FROM TOPUP_SERVICE a"

        );
        sql.append("  WHERE ( LOWER(a.SERVICE_TYPE) LIKE LOWER(CONCAT(CONCAT('%', '")
                .append(request.getKeyword())
                .append("'), '%')) )");
        if(request.getActive() != null && request.getActive() != -1){
            sql.append(" AND a.ACTIVE = ")
                    .append(request.getActive());
        }
        sql.append(" OFFSET ")
                .append(request.getPage() * request.getPagesize())
                .append(" ROWS FETCH NEXT ")
                .append(request.getPagesize())
                .append(" ROWS ONLY");
        Query query = entityManager.createNativeQuery(sql.toString(), "GetServiceDetailMapping");
        return query.getResultList();
    }
}

package com.imedia.oracle.repository;

import com.imedia.oracle.entity.ParService;
import com.imedia.service.parservice.dto.ParServiceServiceDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParServiceRepository extends JpaRepository<ParService, Long> {
    @Query(value = "Select * from TOPUP_SERVICE", nativeQuery = true)
    List<ParServiceServiceDTO> getServiceService();
}

package com.imedia.oracle.repository;

import com.imedia.oracle.entity.SubService;
import com.imedia.service.subservice.dto.SubServiceServiceDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubServiceRepository extends JpaRepository<SubService, Long> {
    @Query(value = "Select * from TOPUP_SUBSERVICE", nativeQuery = true)
    List<SubServiceServiceDTO> getServiceService();
}

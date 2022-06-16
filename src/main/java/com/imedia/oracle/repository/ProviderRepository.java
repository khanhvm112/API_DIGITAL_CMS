package com.imedia.oracle.repository;

import com.imedia.oracle.entity.Provider;
import com.imedia.service.provider.dto.ProviderServiceDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {
    @Query(value = "Select * from TOPUP_PROVIDER", nativeQuery = true)
    List<ProviderServiceDTO> getProviderService();
}

package com.imedia.oracle.repository;


import com.imedia.oracle.entity.ParentProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentProviderRepository extends JpaRepository<ParentProvider, Long> {
}

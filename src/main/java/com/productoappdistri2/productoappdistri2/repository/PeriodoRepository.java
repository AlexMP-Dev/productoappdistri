package com.productoappdistri2.productoappdistri2.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.productoappdistri2.productoappdistri2.entities.Periodo;
public interface PeriodoRepository extends  JpaRepository<Periodo, Long> {
    
}

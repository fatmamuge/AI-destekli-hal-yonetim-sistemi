package com.fatmamuge.backend.repository;

import com.fatmamuge.backend.entity.SaleStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleStatusRepository extends JpaRepository<SaleStatus, Integer> {

}

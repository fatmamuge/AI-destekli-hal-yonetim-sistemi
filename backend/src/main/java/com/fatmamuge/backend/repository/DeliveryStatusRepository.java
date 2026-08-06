package com.fatmamuge.backend.repository;

import com.fatmamuge.backend.entity.DeliveryStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryStatusRepository extends JpaRepository<DeliveryStatus, Integer> {

}

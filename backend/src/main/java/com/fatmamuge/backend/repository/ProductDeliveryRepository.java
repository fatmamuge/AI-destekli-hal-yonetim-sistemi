package com.fatmamuge.backend.repository;

import com.fatmamuge.backend.entity.ProductDelivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDeliveryRepository extends JpaRepository<ProductDelivery, Integer> {

}

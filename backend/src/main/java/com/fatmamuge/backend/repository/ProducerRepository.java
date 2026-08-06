package com.fatmamuge.backend.repository;

import com.fatmamuge.backend.entity.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducerRepository extends JpaRepository<Producer, Integer> {

}

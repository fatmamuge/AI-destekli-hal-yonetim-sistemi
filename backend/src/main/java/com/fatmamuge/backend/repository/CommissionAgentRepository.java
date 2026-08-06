package com.fatmamuge.backend.repository;

import com.fatmamuge.backend.entity.CommissionAgent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommissionAgentRepository extends JpaRepository<CommissionAgent, Integer>{
}

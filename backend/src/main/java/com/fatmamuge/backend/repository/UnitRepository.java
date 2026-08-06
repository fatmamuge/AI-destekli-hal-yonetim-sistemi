package com.fatmamuge.backend.repository;

import com.fatmamuge.backend.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Integer> {

}

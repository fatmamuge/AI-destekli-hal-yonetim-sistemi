package com.fatmamuge.backend.service;

import com.fatmamuge.backend.entity.Unit;
import com.fatmamuge.backend.repository.UnitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitService {

    private final UnitRepository unitRepository;

    public UnitService(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    public List<Unit> getAllUnits() {
        return unitRepository.findAll();
    }

    public Unit getUnitById(Integer id) {
        return unitRepository.findById(id)
                .orElseThrow();
    }

    public Unit saveUnit(Unit unit) {
        return unitRepository.save(unit);
    }

    public Unit updateUnit(Integer id, Unit updatedUnit) {

        Unit unit = unitRepository.findById(id)
                .orElseThrow();

        unit.setName(updatedUnit.getName());

        return unitRepository.save(unit);
    }

    public void deleteUnit(Integer id) {
        unitRepository.deleteById(id);
    }
}

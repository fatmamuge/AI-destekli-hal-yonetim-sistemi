package com.fatmamuge.backend.controller;

import com.fatmamuge.backend.entity.Unit;
import com.fatmamuge.backend.service.UnitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/units")
public class UnitController {

    private final UnitService unitService;

    public UnitController(UnitService unitService) {
        this.unitService = unitService;
    }

    @GetMapping
    public List<Unit> getAllUnits() {
        return unitService.getAllUnits();
    }

    @GetMapping("/{id}")
    public Unit getUnitById(@PathVariable Integer id) {
        return unitService.getUnitById(id);
    }

    @PostMapping
    public Unit createUnit(@RequestBody Unit unit) {
        return unitService.saveUnit(unit);
    }

    @PutMapping("/{id}")
    public Unit updateUnit(
            @PathVariable Integer id,
            @RequestBody Unit updatedUnit) {

        return unitService.updateUnit(id, updatedUnit);
    }

    @DeleteMapping("/{id}")
    public void deleteUnit(@PathVariable Integer id) {
        unitService.deleteUnit(id);
    }
}

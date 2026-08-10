package com.fatmamuge.backend.controller;

import com.fatmamuge.backend.entity.Unit;
import com.fatmamuge.backend.repository.UnitRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/units")
public class UnitController {

    private final UnitRepository unitRepository;

    public UnitController(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    @GetMapping
    public List<Unit> getAllUnits() {
        return unitRepository.findAll();
    }
}

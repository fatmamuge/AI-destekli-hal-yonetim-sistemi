package com.fatmamuge.backend.controller;

import com.fatmamuge.backend.entity.SaleStatus;
import com.fatmamuge.backend.repository.SaleStatusRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sale-statuses")
public class SaleStatusController {

    private final SaleStatusRepository saleStatusRepository;

    public SaleStatusController(SaleStatusRepository saleStatusRepository) {
        this.saleStatusRepository = saleStatusRepository;
    }

    @GetMapping
    public List<SaleStatus> getAll() {
        return saleStatusRepository.findAll();
    }
}

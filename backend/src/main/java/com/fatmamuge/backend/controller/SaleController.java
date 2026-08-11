package com.fatmamuge.backend.controller;

import com.fatmamuge.backend.entity.Sale;
import com.fatmamuge.backend.service.SaleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SaleController {

    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping
    public List<Sale> getAllSales() {
        return saleService.getAllSales();
    }

    @GetMapping("/{id}")
    public Sale getSaleById(@PathVariable Integer id) {
        return saleService.getSaleById(id);
    }

    @PostMapping
    public Sale createSale(@RequestBody Sale sale) {
        return saleService.saveSale(sale);
    }

    @PutMapping("/{id}")
    public Sale updateSale(
            @PathVariable Integer id,
            @RequestBody Sale updatedSale) {

        return saleService.updateSale(id, updatedSale);
    }

    @DeleteMapping("/{id}")
    public void deleteSale(@PathVariable Integer id) {
        saleService.deleteSale(id);
    }
}

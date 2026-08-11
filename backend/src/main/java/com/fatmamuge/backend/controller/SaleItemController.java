package com.fatmamuge.backend.controller;

import com.fatmamuge.backend.entity.SaleItem;
import com.fatmamuge.backend.service.SaleItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sale-items")
public class SaleItemController {

    private final SaleItemService saleItemService;

    public SaleItemController(SaleItemService saleItemService) {
        this.saleItemService = saleItemService;
    }

    @GetMapping
    public List<SaleItem> getAllSaleItems() {
        return saleItemService.getAllSaleItems();
    }

    @GetMapping("/{id}")
    public SaleItem getSaleItemById(@PathVariable Integer id) {
        return saleItemService.getSaleItemById(id);
    }

    @PostMapping
    public SaleItem createSaleItem(
            @RequestBody SaleItem saleItem) {
        return saleItemService.saveSaleItem(saleItem);
    }

    @PutMapping("/{id}")
    public SaleItem updateSaleItem(
            @PathVariable Integer id,
            @RequestBody SaleItem updatedSaleItem) {

        return saleItemService.updateSaleItem(
                id, updatedSaleItem);
    }

    @DeleteMapping("/{id}")
    public void deleteSaleItem(@PathVariable Integer id) {
        saleItemService.deleteSaleItem(id);
    }
}

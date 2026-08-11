package com.fatmamuge.backend.controller;

import com.fatmamuge.backend.entity.ProductDelivery;
import com.fatmamuge.backend.service.ProductDeliveryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-deliveries")
public class ProductDeliveryController {

    private final ProductDeliveryService productDeliveryService;

    public ProductDeliveryController(
            ProductDeliveryService productDeliveryService) {
        this.productDeliveryService = productDeliveryService;
    }

    @GetMapping
    public List<ProductDelivery> getAllProductDeliveries() {
        return productDeliveryService.getAllProductDeliveries();
    }

    @GetMapping("/{id}")
    public ProductDelivery getProductDeliveryById(
            @PathVariable Integer id) {
        return productDeliveryService.getProductDeliveryById(id);
    }

    @PostMapping
    public ProductDelivery createProductDelivery(
            @RequestBody ProductDelivery productDelivery) {
        return productDeliveryService.saveProductDelivery(productDelivery);
    }

    @PutMapping("/{id}")
    public ProductDelivery updateProductDelivery(
            @PathVariable Integer id,
            @RequestBody ProductDelivery updatedProductDelivery) {

        return productDeliveryService.updateProductDelivery(
                id, updatedProductDelivery);
    }

    @DeleteMapping("/{id}")
    public void deleteProductDelivery(@PathVariable Integer id) {
        productDeliveryService.deleteProductDelivery(id);
    }
}

package com.fatmamuge.backend.service;

import com.fatmamuge.backend.entity.SaleItem;
import com.fatmamuge.backend.repository.SaleItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleItemService {

    private final SaleItemRepository saleItemRepository;

    public SaleItemService(SaleItemRepository saleItemRepository) {
        this.saleItemRepository = saleItemRepository;
    }

    public List<SaleItem> getAllSaleItems() {
        return saleItemRepository.findAll();
    }

    public SaleItem getSaleItemById(Integer id) {
        return saleItemRepository.findById(id)
                .orElseThrow();
    }

    public SaleItem saveSaleItem(SaleItem saleItem) {
        return saleItemRepository.save(saleItem);
    }

    public SaleItem updateSaleItem(
            Integer id,
            SaleItem updatedSaleItem) {

        SaleItem saleItem = saleItemRepository.findById(id)
                .orElseThrow();

        saleItem.setSale(updatedSaleItem.getSale());
        saleItem.setProductDelivery(
                updatedSaleItem.getProductDelivery());
        saleItem.setQuantity(updatedSaleItem.getQuantity());
        saleItem.setUnitPrice(updatedSaleItem.getUnitPrice());

        return saleItemRepository.save(saleItem);
    }

    public void deleteSaleItem(Integer id) {
        saleItemRepository.deleteById(id);
    }
}

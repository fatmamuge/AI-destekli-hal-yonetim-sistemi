package com.fatmamuge.backend.service;

import com.fatmamuge.backend.entity.Sale;
import com.fatmamuge.backend.repository.SaleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {

    private final SaleRepository saleRepository;

    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    public Sale getSaleById(Integer id) {
        return saleRepository.findById(id)
                .orElseThrow();
    }

    public Sale saveSale(Sale sale) {
        return saleRepository.save(sale);
    }

    public Sale updateSale(Integer id, Sale updatedSale) {

        Sale sale = saleRepository.findById(id)
                .orElseThrow();

        sale.setCommissionAgent(updatedSale.getCommissionAgent());
        sale.setTrader(updatedSale.getTrader());
        sale.setSalesDate(updatedSale.getSalesDate());
        sale.setTotalAmount(updatedSale.getTotalAmount());
        sale.setSaleStatus(updatedSale.getSaleStatus());

        return saleRepository.save(sale);
    }

    public void deleteSale(Integer id) {
        saleRepository.deleteById(id);
    }
}

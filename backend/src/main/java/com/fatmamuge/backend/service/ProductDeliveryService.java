package com.fatmamuge.backend.service;

import com.fatmamuge.backend.entity.ProductDelivery;
import com.fatmamuge.backend.repository.ProductDeliveryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDeliveryService {

    private final ProductDeliveryRepository productDeliveryRepository;

    public ProductDeliveryService(ProductDeliveryRepository productDeliveryRepository) {
        this.productDeliveryRepository = productDeliveryRepository;
    }

    public List<ProductDelivery> getAllProductDeliveries() {
        return productDeliveryRepository.findAll();
    }

    public ProductDelivery getProductDeliveryById(Integer id) {
        return productDeliveryRepository.findById(id)
                .orElseThrow();
    }

    public ProductDelivery saveProductDelivery(ProductDelivery productDelivery) {
        return productDeliveryRepository.save(productDelivery);
    }

    public ProductDelivery updateProductDelivery(
            Integer id,
            ProductDelivery updatedProductDelivery) {

        ProductDelivery productDelivery =
                productDeliveryRepository.findById(id)
                        .orElseThrow();

        productDelivery.setProducer(updatedProductDelivery.getProducer());
        productDelivery.setCommissionAgent(
                updatedProductDelivery.getCommissionAgent());
        productDelivery.setProduct(updatedProductDelivery.getProduct());
        productDelivery.setQuantity(updatedProductDelivery.getQuantity());
        productDelivery.setUnitPrice(updatedProductDelivery.getUnitPrice());
        productDelivery.setDeliveryDate(
                updatedProductDelivery.getDeliveryDate());
        productDelivery.setCreatedAt(
                updatedProductDelivery.getCreatedAt());
        productDelivery.setDeliveryStatus(
                updatedProductDelivery.getDeliveryStatus());

        return productDeliveryRepository.save(productDelivery);
    }

    public void deleteProductDelivery(Integer id) {
        productDeliveryRepository.deleteById(id);
    }
}

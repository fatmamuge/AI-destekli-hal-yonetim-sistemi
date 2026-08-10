package com.fatmamuge.backend.service;

import com.fatmamuge.backend.entity.Product;
import com.fatmamuge.backend.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Integer id) {
        return productRepository.findById(id)
                .orElseThrow();
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }
    public Product updateProduct(Integer id, Product updatedProduct) {

        Product product = productRepository.findById(id)
                .orElseThrow();

        product.setName(updatedProduct.getName());
        product.setUnit(updatedProduct.getUnit());
        product.setCreatedAt(updatedProduct.getCreatedAt());

        return productRepository.save(product);
    }
}

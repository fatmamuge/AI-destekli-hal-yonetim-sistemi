package com.fatmamuge.backend.service;

import com.fatmamuge.backend.entity.Payment;
import com.fatmamuge.backend.entity.Sale;
import com.fatmamuge.backend.repository.PaymentRepository;
import com.fatmamuge.backend.repository.ProductDeliveryRepository;
import com.fatmamuge.backend.repository.ProductRepository;
import com.fatmamuge.backend.repository.SaleRepository;
import com.fatmamuge.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class DashboardService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final SaleRepository saleRepository;
    private final PaymentRepository paymentRepository;
    private final ProductDeliveryRepository productDeliveryRepository;

    public DashboardService(
            UserRepository userRepository,
            ProductRepository productRepository,
            SaleRepository saleRepository,
            PaymentRepository paymentRepository,
            ProductDeliveryRepository productDeliveryRepository) {

        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.saleRepository = saleRepository;
        this.paymentRepository = paymentRepository;
        this.productDeliveryRepository = productDeliveryRepository;
    }

    public Map<String, Object> getStats() {

        BigDecimal totalSalesAmount = saleRepository.findAll()
                .stream()
                .map(Sale::getTotalAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalPaymentAmount = paymentRepository.findAll()
                .stream()
                .map(Payment::getAmountReceived)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        Map<String, Object> stats = new HashMap<>();

        stats.put("totalUsers", userRepository.count());
        stats.put("totalProducts", productRepository.count());
        stats.put("totalSales", saleRepository.count());
        stats.put("totalPayments", paymentRepository.count());
        stats.put("totalProductDeliveries", productDeliveryRepository.count());

        stats.put("totalSalesAmount", totalSalesAmount);
        stats.put("totalPaymentAmount", totalPaymentAmount);

        return stats;
    }
}

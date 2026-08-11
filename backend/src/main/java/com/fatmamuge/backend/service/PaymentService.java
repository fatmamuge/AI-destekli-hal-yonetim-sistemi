package com.fatmamuge.backend.service;

import com.fatmamuge.backend.entity.Payment;
import com.fatmamuge.backend.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment getPaymentById(Integer id) {
        return paymentRepository.findById(id)
                .orElseThrow();
    }

    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Payment updatePayment(
            Integer id,
            Payment updatedPayment) {

        Payment payment = paymentRepository.findById(id)
                .orElseThrow();

        payment.setSale(updatedPayment.getSale());
        payment.setAmountReceived(
                updatedPayment.getAmountReceived());
        payment.setPaymentDate(
                updatedPayment.getPaymentDate());
        payment.setCreatedAt(
                updatedPayment.getCreatedAt());
        payment.setPaymentStatus(
                updatedPayment.getPaymentStatus());

        return paymentRepository.save(payment);
    }

    public void deletePayment(Integer id) {
        paymentRepository.deleteById(id);
    }
}

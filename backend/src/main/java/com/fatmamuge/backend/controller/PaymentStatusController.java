package com.fatmamuge.backend.controller;

import com.fatmamuge.backend.entity.PaymentStatus;
import com.fatmamuge.backend.repository.PaymentStatusRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment-statuses")
public class PaymentStatusController {

    private final PaymentStatusRepository paymentStatusRepository;

    public PaymentStatusController(PaymentStatusRepository paymentStatusRepository) {
        this.paymentStatusRepository = paymentStatusRepository;
    }

    @GetMapping
    public List<PaymentStatus> getAll() {
        return paymentStatusRepository.findAll();
    }
}

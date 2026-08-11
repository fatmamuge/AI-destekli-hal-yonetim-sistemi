package com.fatmamuge.backend.controller;

import com.fatmamuge.backend.entity.DeliveryStatus;
import com.fatmamuge.backend.repository.DeliveryStatusRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delivery-statuses")
public class DeliveryStatusController {

    private final DeliveryStatusRepository deliveryStatusRepository;

    public DeliveryStatusController(DeliveryStatusRepository deliveryStatusRepository) {
        this.deliveryStatusRepository = deliveryStatusRepository;
    }

    @GetMapping
    public List<DeliveryStatus> getAllDeliveryStatuses() {
        return deliveryStatusRepository.findAll();
    }
}

package com.fatmamuge.backend.controller;

import com.fatmamuge.backend.entity.Producer;
import com.fatmamuge.backend.service.ProducerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producers")
public class ProducerController {

    private final ProducerService producerService;

    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @GetMapping
    public List<Producer> getAllProducers() {
        return producerService.getAllProducers();
    }

    @GetMapping("/{id}")
    public Producer getProducerById(@PathVariable Integer id) {
        return producerService.getProducerById(id);
    }

    @PostMapping
    public Producer createProducer(@RequestBody Producer producer) {
        return producerService.saveProducer(producer);
    }

    @PutMapping("/{id}")
    public Producer updateProducer(
            @PathVariable Integer id,
            @RequestBody Producer updatedProducer) {

        return producerService.updateProducer(id, updatedProducer);
    }

    @DeleteMapping("/{id}")
    public void deleteProducer(@PathVariable Integer id) {
        producerService.deleteProducer(id);
    }
}

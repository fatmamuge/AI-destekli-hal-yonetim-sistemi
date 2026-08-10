package com.fatmamuge.backend.service;

import com.fatmamuge.backend.entity.Producer;
import com.fatmamuge.backend.repository.ProducerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducerService {

    private final ProducerRepository producerRepository;

    public ProducerService(ProducerRepository producerRepository) {
        this.producerRepository = producerRepository;
    }

    public List<Producer> getAllProducers() {
        return producerRepository.findAll();
    }

    public Producer getProducerById(Integer id) {
        return producerRepository.findById(id)
                .orElseThrow();
    }

    public Producer saveProducer(Producer producer) {
        return producerRepository.save(producer);
    }

    public Producer updateProducer(Integer id, Producer updatedProducer) {

        Producer producer = producerRepository.findById(id)
                .orElseThrow();

        producer.setAddress(updatedProducer.getAddress());
        producer.setUser(updatedProducer.getUser());

        return producerRepository.save(producer);
    }

    public void deleteProducer(Integer id) {
        producerRepository.deleteById(id);
    }
}

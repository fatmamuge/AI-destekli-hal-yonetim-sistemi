package com.fatmamuge.backend.service;

import com.fatmamuge.backend.entity.Trader;
import com.fatmamuge.backend.repository.TraderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraderService {

    private final TraderRepository traderRepository;

    public TraderService(TraderRepository traderRepository) {
        this.traderRepository = traderRepository;
    }

    public List<Trader> getAllTraders() {
        return traderRepository.findAll();
    }

    public Trader getTraderById(Integer id) {
        return traderRepository.findById(id)
                .orElseThrow();
    }

    public Trader saveTrader(Trader trader) {
        return traderRepository.save(trader);
    }

    public Trader updateTrader(
            Integer id,
            Trader updatedTrader) {

        Trader trader = traderRepository.findById(id)
                .orElseThrow();

        trader.setCompanyName(
                updatedTrader.getCompanyName());

        trader.setTaxNumber(
                updatedTrader.getTaxNumber());

        trader.setUser(updatedTrader.getUser());

        return traderRepository.save(trader);
    }

    public void deleteTrader(Integer id) {
        traderRepository.deleteById(id);
    }
}

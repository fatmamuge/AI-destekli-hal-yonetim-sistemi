package com.fatmamuge.backend.controller;

import com.fatmamuge.backend.entity.Trader;
import com.fatmamuge.backend.service.TraderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/traders")
public class TraderController {

    private final TraderService traderService;

    public TraderController(TraderService traderService) {
        this.traderService = traderService;
    }

    @GetMapping
    public List<Trader> getAllTraders() {
        return traderService.getAllTraders();
    }

    @GetMapping("/{id}")
    public Trader getTraderById(@PathVariable Integer id) {
        return traderService.getTraderById(id);
    }

    @PostMapping
    public Trader createTrader(@RequestBody Trader trader) {
        return traderService.saveTrader(trader);
    }

    @PutMapping("/{id}")
    public Trader updateTrader(
            @PathVariable Integer id,
            @RequestBody Trader updatedTrader) {

        return traderService.updateTrader(
                id, updatedTrader);
    }

    @DeleteMapping("/{id}")
    public void deleteTrader(@PathVariable Integer id) {
        traderService.deleteTrader(id);
    }
}

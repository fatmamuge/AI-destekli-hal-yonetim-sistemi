package com.fatmamuge.backend.controller;

import com.fatmamuge.backend.entity.CommissionAgent;
import com.fatmamuge.backend.service.CommissionAgentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commission-agents")
public class CommissionAgentController {

    private final CommissionAgentService commissionAgentService;

    public CommissionAgentController(
            CommissionAgentService commissionAgentService) {
        this.commissionAgentService = commissionAgentService;
    }

    @GetMapping
    public List<CommissionAgent> getAllCommissionAgents() {
        return commissionAgentService.getAllCommissionAgents();
    }

    @GetMapping("/{id}")
    public CommissionAgent getCommissionAgentById(
            @PathVariable Integer id) {
        return commissionAgentService.getCommissionAgentById(id);
    }

    @PostMapping
    public CommissionAgent createCommissionAgent(
            @RequestBody CommissionAgent commissionAgent) {
        return commissionAgentService
                .saveCommissionAgent(commissionAgent);
    }

    @PutMapping("/{id}")
    public CommissionAgent updateCommissionAgent(
            @PathVariable Integer id,
            @RequestBody CommissionAgent updatedCommissionAgent) {

        return commissionAgentService.updateCommissionAgent(
                id, updatedCommissionAgent);
    }

    @DeleteMapping("/{id}")
    public void deleteCommissionAgent(
            @PathVariable Integer id) {
        commissionAgentService.deleteCommissionAgent(id);
    }
}

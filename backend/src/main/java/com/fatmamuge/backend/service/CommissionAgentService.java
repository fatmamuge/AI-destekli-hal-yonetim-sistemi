package com.fatmamuge.backend.service;

import com.fatmamuge.backend.entity.CommissionAgent;
import com.fatmamuge.backend.repository.CommissionAgentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommissionAgentService {

    private final CommissionAgentRepository commissionAgentRepository;

    public CommissionAgentService(
            CommissionAgentRepository commissionAgentRepository) {
        this.commissionAgentRepository = commissionAgentRepository;
    }

    public List<CommissionAgent> getAllCommissionAgents() {
        return commissionAgentRepository.findAll();
    }

    public CommissionAgent getCommissionAgentById(Integer id) {
        return commissionAgentRepository.findById(id)
                .orElseThrow();
    }

    public CommissionAgent saveCommissionAgent(
            CommissionAgent commissionAgent) {
        return commissionAgentRepository.save(commissionAgent);
    }

    public CommissionAgent updateCommissionAgent(
            Integer id,
            CommissionAgent updatedCommissionAgent) {

        CommissionAgent agent =
                commissionAgentRepository.findById(id)
                        .orElseThrow();

        agent.setCompanyName(
                updatedCommissionAgent.getCompanyName());

        agent.setTaxNumber(
                updatedCommissionAgent.getTaxNumber());

        agent.setUser(
                updatedCommissionAgent.getUser());

        return commissionAgentRepository.save(agent);
    }

    public void deleteCommissionAgent(Integer id) {
        commissionAgentRepository.deleteById(id);
    }
}

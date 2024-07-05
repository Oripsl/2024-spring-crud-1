package com.example.nuovoGiro.service;

import com.example.nuovoGiro.entity.ContoBancario;
import com.example.nuovoGiro.repository.ContoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContoService {
    @Autowired
    private ContoRepo contoRepo;

    public ContoBancario addConto(ContoBancario contoBancario) {
        return contoRepo.save(contoBancario);
    }

    public ContoBancario findById(Long id) {
        return contoRepo.findById(id).orElse(null);
    }

    public List<ContoBancario> findAll() {
        return contoRepo.findAll();
    }

    public ContoBancario increaseConto(Long id, double increase) {
        Optional<ContoBancario> foundConto = contoRepo.findById(id);
        if (foundConto.isPresent()) {
            ContoBancario conto = foundConto.get();
            conto.deposit(increase);
            return contoRepo.save(conto);
        }
        throw new IllegalArgumentException("Conto bancario non trovato con id: " + id);
    }

    public ContoBancario decreaseConto(Long id, double decrease) {
        Optional<ContoBancario> foundConto = contoRepo.findById(id);
        if (foundConto.isPresent()) {
            ContoBancario conto = foundConto.get();
            conto.withdrawal(decrease);
            return contoRepo.save(conto);
        }
        throw new IllegalArgumentException("Conto bancario non trovato con id: " + id);
    }

    public boolean deleteConto(Long id) {
        Optional<ContoBancario> foundConto = contoRepo.findById(id);
        if (foundConto.isPresent()) {
            contoRepo.delete(foundConto.get());
            return true;
        }
        throw new IllegalArgumentException("Conto bancario non trovato con id: " + id);
    }
}

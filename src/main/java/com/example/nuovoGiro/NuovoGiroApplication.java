package com.example.nuovoGiro;

import com.example.nuovoGiro.entity.ContoBancario;
import com.example.nuovoGiro.service.ContoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NuovoGiroApplication implements CommandLineRunner {
    @Autowired
    private ContoService service;

    public static void main(String[] args) {
        SpringApplication.run(NuovoGiroApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ContoBancario conto1 = new ContoBancario();
        service.addConto(conto1);

        try {
            service.increaseConto(conto1.getId(), 1000);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            service.decreaseConto(conto1.getId(), 500);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        ContoBancario retrievedConto = service.findById(conto1.getId());
        if (retrievedConto != null) {
            System.out.println("Saldo conto: " + retrievedConto.getConto());
        } else {
            System.out.println("Conto non trovato");
        }

        try {
            service.decreaseConto(conto1.getId(), 600);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            service.deleteConto(conto1.getId());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}


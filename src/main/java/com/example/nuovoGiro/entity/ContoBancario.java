package com.example.nuovoGiro.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "Conto_bancario")
public class ContoBancario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double conto;

    public ContoBancario() {
        this.conto = 0;
    }

    public void deposit(double importo) {
        if (importo < 0) {
            throw new IllegalArgumentException("Non è possibile depositare un importo negativo");
        }
        this.conto += importo;
    }

    public void withdrawal(double importo) {
        if (importo > this.conto) {
            throw new IllegalArgumentException("Saldo insufficiente");
        }
        this.conto -= importo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getConto() {
        return conto;
    }

    public void setConto(double conto) {
        this.conto = conto;
    }
}

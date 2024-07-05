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

    public boolean deposit(double importo) {
        if (importo < 0) {
            return false;
        }
        this.conto += importo;
        return true;
    }

    public boolean withdrawal(double importo) {
        if (importo > this.conto || importo < 0) {
            return false;
        }
        this.conto -= importo;
        return true;
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

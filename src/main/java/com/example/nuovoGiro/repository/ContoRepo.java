package com.example.nuovoGiro.repository;

import com.example.nuovoGiro.entity.ContoBancario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContoRepo extends JpaRepository<ContoBancario, Long> {
}

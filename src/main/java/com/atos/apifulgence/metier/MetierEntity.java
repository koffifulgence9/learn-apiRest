package com.atos.apifulgence.metier;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Data
public class MetierEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomMetier;

    private BigDecimal amont;

    private LocalDate dateNaissance;
}

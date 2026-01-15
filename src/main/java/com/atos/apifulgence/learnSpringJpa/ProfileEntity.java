package com.atos.apifulgence.learnSpringJpa;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bio;

    @OneToOne(mappedBy = "profile")
    private UserEntity user;


}

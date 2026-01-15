package com.atos.apifulgence.learnSpringJpa;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class GroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "groupEntity")
    private Set<UserEntity> userEntity;
}

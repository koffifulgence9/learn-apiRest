package com.atos.apifulgence.person;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false, length = 100)
    private String city;
    @Column(nullable = false, length = 100)
    private String phoneNumber;
}

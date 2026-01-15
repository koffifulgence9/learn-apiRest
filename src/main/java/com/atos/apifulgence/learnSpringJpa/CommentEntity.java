package com.atos.apifulgence.learnSpringJpa;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class CommentEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;

    @ManyToMany(mappedBy = "commentEntity")
    private Set<PostEntity> postEntity;
}

package com.atos.apifulgence.learnSpringJpa;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;

   @ManyToOne
   @JoinColumn(name = "user_id")
   private UserEntity userEntity;

    @ManyToMany
    @JoinTable(name = "postEntity_commentEntity",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "comment_id"))
    private Set<CommentEntity> commentEntity;

}

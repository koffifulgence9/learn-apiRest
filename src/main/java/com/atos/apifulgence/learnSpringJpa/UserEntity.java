package com.atos.apifulgence.learnSpringJpa;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    @OneToOne
    @JoinColumn(name="profile_id")
    private ProfileEntity profile;

    @OneToMany(mappedBy = "userEntity")
    private List<PostEntity> postEntity;

    @ManyToMany
    @JoinTable(name="userEntity_groupEntity",
    joinColumns = @JoinColumn(name ="user_id"),
    inverseJoinColumns = @JoinColumn(name = "group_id"))
    private Set<GroupEntity> groupEntity;

    @ManyToMany
    @JoinTable(name="userEntity_friendEntity",
    joinColumns = @JoinColumn(name ="user_id"),
    inverseJoinColumns = @JoinColumn(name = "friend_id"))
    private Set<UserEntity> friendEntity;

}

package com.seguo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    @ManyToMany
    @JoinTable(name = "role_permission",joinColumns = @JoinColumn(name = "role_id"),inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private List<Permission> permissions;
}

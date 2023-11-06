package com.seguo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Permission {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private int sort;
    @ManyToMany(mappedBy = "permissions",fetch = FetchType.EAGER)
    private List<Role> roles;
}

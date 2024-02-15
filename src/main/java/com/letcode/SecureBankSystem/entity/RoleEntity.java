package com.letcode.SecureBankSystem.entity;

import com.letcode.SecureBankSystem.util.enums.roles.Roles;

import javax.persistence.*;

@Entity
@Table(name="role")
public class RoleEntity {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Roles getTitle() {
        return title;
    }

    public void setTitle(Roles title) {
        this.title = title;
    }

    @Id
    @Column(name="id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Roles title;



}

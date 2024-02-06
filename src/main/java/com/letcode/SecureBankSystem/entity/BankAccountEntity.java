package com.letcode.SecureBankSystem.entity;

import javax.persistence.*;

@Entity
@Table(name="bank_account")
public class BankAccountEntity {

    @Id
    @Column(name="id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // the best one is identity bc it will let the database generate the id
    private Long id;

    @Column(nullable = false)
    private Double balance;


    @ManyToOne
    @JoinColumn(name="user_id")
    private UserEntity user;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}

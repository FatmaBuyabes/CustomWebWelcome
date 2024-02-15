package com.letcode.SecureBankSystem.entity;

import org.apache.catalina.User;

import javax.persistence.*;
 //PRACTICE
@Entity
@Table(name="user_setting")
public class UserSettingsEntity {

     @Id
     @Column(name="id", nullable = false)
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     private boolean reciveNewsletter;

     private String prefferedLanguage;

    @OneToOne  // to show the relation
    @JoinColumn(name = "user_id")  //give the ability to name the foreign key
     private UserEntity user;

     public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isReciveNewsletter() {
        return reciveNewsletter;
    }

    public void setReciveNewsletter(boolean reciveNewsletter) {
        this.reciveNewsletter = reciveNewsletter;
    }

    public String getPrefferedLanguage() {
        return prefferedLanguage;
    }

    public void setPrefferedLanguage(String prefferedLanguage) {
        this.prefferedLanguage = prefferedLanguage;
    }





}

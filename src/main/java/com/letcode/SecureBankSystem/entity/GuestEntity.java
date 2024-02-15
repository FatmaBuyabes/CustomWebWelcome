package com.letcode.SecureBankSystem.entity;

import com.letcode.SecureBankSystem.util.enums.roles.Roles;
import com.letcode.SecureBankSystem.util.enums.suggestion.SuggestionStatus;

import javax.persistence.*;

@Entity
@Table(name="Guest Suggestion")
public class GuestEntity {

    @Id
    @Column(name="id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // the best one is identity bc it will let the database generate the id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRate() {
        return rate;
    }

    public void setRate(Long rate) {
        this.rate = rate;
    }

    public String getGuestSuggestionText() {
        return guestSuggestionText;
    }

    public void setGuestSuggestionText(String guestSuggestionText) {
        this.guestSuggestionText = guestSuggestionText;
    }

    @Column(nullable = false)
    private Long rate;

    @Column(nullable = false)
    private String guestSuggestionText;

    @Enumerated(EnumType.STRING)
    private SuggestionStatus suggestionStatus;














}

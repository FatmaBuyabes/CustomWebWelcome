package com.letcode.SecureBankSystem.bo;

import com.fasterxml.jackson.annotation.JsonInclude;


public class CreateContactRequest {

    private String name;
    private String email;
    private String phone;


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}

package com.letcode.SecureBankSystem.bo;

public class UpdateUserRequest {

    //every bo must have setter and getter

    private Long userId;

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }




}

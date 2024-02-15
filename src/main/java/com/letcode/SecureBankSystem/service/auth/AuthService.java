package com.letcode.SecureBankSystem.service.auth;

import com.letcode.SecureBankSystem.bo.auth.AuthinticationResponse;
import com.letcode.SecureBankSystem.bo.auth.CreateLoginRequest;
import com.letcode.SecureBankSystem.bo.auth.CreateSignupRequest;
import com.letcode.SecureBankSystem.bo.auth.LogoutRespone;

public interface AuthService {

    void signup(CreateSignupRequest createSignupRequest);

    AuthinticationResponse login(CreateLoginRequest createLoginRequest);


    void logout(LogoutRespone logoutRespone);
}

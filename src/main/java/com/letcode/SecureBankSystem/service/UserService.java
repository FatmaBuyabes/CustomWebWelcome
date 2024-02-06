package com.letcode.SecureBankSystem.service;

import com.letcode.SecureBankSystem.bo.UpdateUserRequest;
import com.letcode.SecureBankSystem.bo.user.CreateUserRequest;

public interface UserService {
    void saveUser(CreateUserRequest createUserRequest);

    void deleteUser();

    void updateUserStatus(UpdateUserRequest updateUserRequest);


}

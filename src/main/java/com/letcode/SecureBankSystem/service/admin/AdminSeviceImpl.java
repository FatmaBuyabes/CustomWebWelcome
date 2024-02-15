package com.letcode.SecureBankSystem.service.admin;

import com.letcode.SecureBankSystem.entity.UserEntity;
import com.letcode.SecureBankSystem.repository.UserRepository;

import java.util.List;

public class AdminSeviceImpl implements AdminService {

    private final UserRepository userRepository;

    public AdminSeviceImpl(UserRepository userRepository) {this.userRepository = userRepository;}

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }
}

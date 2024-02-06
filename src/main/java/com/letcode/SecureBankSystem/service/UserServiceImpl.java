package com.letcode.SecureBankSystem.service;

import com.letcode.SecureBankSystem.bo.UpdateUserRequest;
import com.letcode.SecureBankSystem.entity.UserEntity;
import com.letcode.SecureBankSystem.bo.user.CreateUserRequest;
import com.letcode.SecureBankSystem.repository.UserRepository;
import com.letcode.SecureBankSystem.util.enums.Status;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {  // we want to take the method

    private final UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override  // print the entity and call them
    public void saveUser(CreateUserRequest createUserRequest){
        UserEntity userEntity = new UserEntity();
        userEntity.setName(createUserRequest.getName());
        userEntity.setEmail(createUserRequest.getEmail());
        userEntity.setPhoneNumber(createUserRequest.getPhone());
        userEntity.setStatus(Status.valueOf(createUserRequest.getStatus()));
        userRepository.save(userEntity);



    }

    @Override
    public void deleteUser() {

    }

    @Override
    public void updateUserStatus(Long userId, UpdateUserRequest updateUserRequest) {
        UserEntity userEntity =userRepository.findById(updateUserRequest.getUserId()).orElseThrow(); // else throw will give a message

        if(!updateUserRequest.getStatus().equals("ACTIVE") && !updateUserRequest.getUserId().equals("INACTIVE")){
            throw new IllegalArgumentException("The status should be ACTIVE or INACTIVE");
        }
        userEntity.setStatus(Status.valueOf(updateUserRequest.getStatus()));
        userRepository.save(userEntity);
    }



}

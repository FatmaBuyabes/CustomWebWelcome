package com.letcode.SecureBankSystem.service.user;

import com.letcode.SecureBankSystem.bo.user.UpdateUserStatusRequest;
import com.letcode.SecureBankSystem.entity.UserEntity;
import com.letcode.SecureBankSystem.bo.user.CreateUserRequest;
import com.letcode.SecureBankSystem.repository.UserRepository;
import com.letcode.SecureBankSystem.util.enums.status.Status;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {  // we want to take the method
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override  // print the entity and call them
    public void saveUser(CreateUserRequest createUserRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(createUserRequest.getName());
        userEntity.setEmail(createUserRequest.getEmail());
        userEntity.setPhoneNumber(createUserRequest.getPhone());
        userEntity.setStatus(Status.valueOf(createUserRequest.getStatus()));
        userRepository.save(userEntity);

    }

    @Override
    public void updateUserStatus(Long userId, UpdateUserStatusRequest updateUserRequest) {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow(); // else throw will give a message

        if (!updateUserRequest.getStatus().equals("ACTIVE") && !updateUserRequest.getStatus().equals("INACTIVE")) {
            throw new IllegalArgumentException("The status should be ACTIVE or INACTIVE");
        }
        userEntity.setStatus(Status.valueOf(updateUserRequest.getStatus()));
        userRepository.save(userEntity);
    }

    @Override
    public List<String> getAllUsersWithStrongPassword() {
        return userRepository.findAll().stream()
                .filter(user -> user.getPassword().length() > 8)
                .map(UserEntity::getName)
                .collect(Collectors.toList());
    }


}

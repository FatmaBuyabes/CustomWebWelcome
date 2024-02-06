package com.letcode.SecureBankSystem.controller.userController;

import com.letcode.SecureBankSystem.bo.UpdateUserRequest;
import com.letcode.SecureBankSystem.bo.user.CreateUserRequest;
import com.letcode.SecureBankSystem.service.UserService;
import com.letcode.SecureBankSystem.util.enums.Status;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/create-user")
    public ResponseEntity<String> createUser(@RequestBody CreateUserRequest createUserRequest) {
        try {
            userService.saveUser(createUserRequest);
        } catch (IllegalAccessError e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("User Created Successfully");

    }



    @GetMapping("/update-user-status")
    public ResponseEntity<String> updateUser(@RequestParam Long userId, @RequestBody UpdateUserRequest updateUserRequest) {
        try {
            userService.updateUserStatus(updateUserRequest);
        } catch (IllegalAccessError e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return ResponseEntity.ok("User Updated Successfully");


    }
}

package com.letcode.SecureBankSystem.controller.adminController;

import com.letcode.SecureBankSystem.bo.auth.CreateLoginRequest;
import com.letcode.SecureBankSystem.bo.auth.LogoutRespone;
import com.letcode.SecureBankSystem.entity.UserEntity;
import com.letcode.SecureBankSystem.service.admin.AdminService;
import com.letcode.SecureBankSystem.service.user.UserService;
import com.nimbusds.openid.connect.sdk.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    private final AdminService adminService;

    private final UserService userService;


    public AdminController(AdminService adminService, UserService userService) {
        this.adminService = adminService;
        this.userService = userService;
    }


    // GET endpoint to retrieve all Users
    @GetMapping("/get_user")
    public List<UserEntity> getAllUsers() {
        return adminService.getAllUsers();
    }


//    public ResponseEntity<List <String> >getAllUsersWithStrongPassword(){
//        List <String> allUserWithStrongPassword = userService.getAllUsersWithStrongPassword();
//    }


}




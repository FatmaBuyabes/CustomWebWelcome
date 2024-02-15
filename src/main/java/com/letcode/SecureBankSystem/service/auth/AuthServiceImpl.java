package com.letcode.SecureBankSystem.service.auth;

import com.letcode.SecureBankSystem.bo.auth.AuthinticationResponse;
import com.letcode.SecureBankSystem.bo.auth.CreateLoginRequest;
import com.letcode.SecureBankSystem.bo.auth.CreateSignupRequest;
import com.letcode.SecureBankSystem.bo.auth.LogoutRespone;
import com.letcode.SecureBankSystem.bo.customerUserDetails.CustomUserDetails;
import com.letcode.SecureBankSystem.config.JWTUtil;
import com.letcode.SecureBankSystem.entity.RoleEntity;
import com.letcode.SecureBankSystem.entity.UserEntity;
import com.letcode.SecureBankSystem.repository.RoleRepository;
import com.letcode.SecureBankSystem.repository.UserRepository;
import com.letcode.SecureBankSystem.util.enums.roles.Roles;
import com.letcode.SecureBankSystem.util.enums.status.Status;
import com.letcode.SecureBankSystem.util.exception.BodyGuardException;
import com.letcode.SecureBankSystem.util.exception.UserNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class AuthServiceImpl implements AuthService {


    private final AuthenticationManager authenticationManager;

    private final CustomUserDetailsService userDetailsService;

    private final JWTUtil jwtUtil;

    private final RoleRepository roleRepository;

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthServiceImpl(AuthenticationManager authenticationManager, CustomUserDetailsService userDetailsService, JWTUtil jwtUtil, RoleRepository roleRepository, UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public void signup(CreateSignupRequest createSignupRequest) {
        RoleEntity roleEntity = roleRepository.findRoleEntityByTitle(Roles.user.name())
                .orElseThrow(() -> new BodyGuardException("no Roles found !! "));
        UserEntity user = new UserEntity();
        user.setName(createSignupRequest.getName());
        user.setUsername(createSignupRequest.getUsername());
        user.setPhoneNumber(createSignupRequest.getPhoneNumber());
        user.setEmail(createSignupRequest.getEmail());
        user.setRoles(roleRepository.findByTitle(Roles.user));
        user.setStatus(Status.ACTIVE);
        user.setPassword(bCryptPasswordEncoder.encode(createSignupRequest.getPassword()));
        userRepository.save(user);
    }


    @Override
    public AuthinticationResponse login(CreateLoginRequest createLoginRequest) {
        requiredNonNull(createLoginRequest.getUsername(), "username");
        requiredNonNull(createLoginRequest.getPassword(), "password");

        String username = createLoginRequest.getUsername().toLowerCase();
        String password = createLoginRequest.getPassword();

        authentication(username, password);

        CustomUserDetails userDetails = userDetailsService.loadUserByUsername(username);

        String accessToken = jwtUtil.generateToken(userDetails);

        AuthinticationResponse response = new AuthinticationResponse();
        response.setId(userDetails.getId());
        response.setUsername(userDetails.getUsername());
        response.setRole(userDetails.getRole());
        response.setToken("Bearer " + accessToken);
        return response;
    }

    @Override
    public void logout(LogoutRespone logoutRespone) {
        requiredNonNull(logoutRespone.getToken(), "token");
    }


    private void requiredNonNull(Object obj, String name) {
        if (obj == null || obj.toString().isEmpty()) {
            throw new BodyGuardException(name + " can't be empty");
        }
    }


    private void authentication(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (BodyGuardException e) {
            throw new BodyGuardException("Incorrect password");
        } catch (AuthenticationServiceException e) {
            throw new UserNotFoundException("Incorrect username");
        }
    }
}
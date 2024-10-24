package com.SelfDefenseHub.selfdefenseHub.controller;

import com.SelfDefenseHub.selfdefenseHub.dto.JwtRequest;
import com.SelfDefenseHub.selfdefenseHub.dto.LoginResponse;
import com.SelfDefenseHub.selfdefenseHub.entity.User;
import com.SelfDefenseHub.selfdefenseHub.security.JwtHelper;
import com.SelfDefenseHub.selfdefenseHub.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private JwtHelper helper;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody JwtRequest request) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());
        try {
            manager.authenticate(authentication);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        String token = helper.generateToken(userDetails);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setJwtToken(token);
        loginResponse.setUserDetails(userService.getUserByEmail(request.getEmail()));
        return loginResponse;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> createUser(@Valid @RequestBody User userRequest) {
        User user = userService.createUser(userRequest);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }

}



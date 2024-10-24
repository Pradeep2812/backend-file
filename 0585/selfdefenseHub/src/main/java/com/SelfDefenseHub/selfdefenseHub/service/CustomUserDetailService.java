package com.SelfDefenseHub.selfdefenseHub.service;

import com.SelfDefenseHub.selfdefenseHub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         //Load user details from Data Base
        return userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User with given Email not found !!"));
    }
}

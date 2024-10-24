package com.SelfDefenseHub.selfdefenseHub.service;

import com.SelfDefenseHub.selfdefenseHub.entity.User;
import com.SelfDefenseHub.selfdefenseHub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User updateUser(User userDto, String userId) {
        userRepository.findById(userId).orElseThrow(() -> new UsernameNotFoundException("User Not found with the given userId "));
        return userRepository.save(userDto);
    }

    public void deleteUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UsernameNotFoundException("User Not found with the given userId "));
        userRepository.delete(user);
    }

    public Page<User> getAllUser(int pageNumber, int pageSize, String sortBy, String sortDir) {
        Sort sort =(sortDir.equalsIgnoreCase("desc")) ? (Sort.by(sortBy).descending()):(Sort.by(sortBy).ascending());
        Pageable pageable= PageRequest.of(pageNumber,pageSize,sort);
        return userRepository.findAll(pageable);
    }

    public User getUserById(String userId) {
        return userRepository.findById(userId).orElseThrow(() -> new UsernameNotFoundException("User Not found with the given userId "));
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User Not found with the given Email "));
    }

}

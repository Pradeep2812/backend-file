package com.SelfDefenseHub.selfdefenseHub.repository;



import com.SelfDefenseHub.selfdefenseHub.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User,String> {

    // User is the entity on which we are working
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email,String password);
    List<User> findByNameContaining(String keywords);

}

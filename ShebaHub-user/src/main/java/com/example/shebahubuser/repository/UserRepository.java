package com.example.shebahubuser.repository;

import com.example.shebahubuser.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findUserByUsername(String username);

    //Boolean usernameAndEmailExists(String username, String email);

    Users findUsersByUsername(String username);

}

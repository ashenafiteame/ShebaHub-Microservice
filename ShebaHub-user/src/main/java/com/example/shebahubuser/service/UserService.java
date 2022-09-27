package com.example.shebahubuser.service;

import com.example.shebahubuser.model.Users;
import com.example.shebahubuser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(Users user) {
//        Boolean emailOrUsernameExists = userRepository.usernameAndEmailExists(user.getUsername(), user.getEmail());
//        System.out.println(emailOrUsernameExists);
//        if (emailOrUsernameExists) {
//            throw new IllegalStateException("username or email Taken");
//        }

        userRepository.save(user);
    }

    public List<Users> getUsers() {
        return userRepository.findAll();
    }


    public Optional<Users> getUser(Long id) {
        return userRepository.findById(id);
    }

    public Optional<Users> findByUsername(String username) {
        return userRepository.findUserByUsername(username);

    }

    public void updateUser(Users user) {
        userRepository.save(user);
    }

    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "user deleted";


    }
}

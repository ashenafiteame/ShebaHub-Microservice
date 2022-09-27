package com.example.shebahubuser.controller;

import com.example.shebahubuser.model.Users;
import com.example.shebahubuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    public Optional<Users> getUserInfo(@PathVariable("id") Long id) {
       return userService.getUser(id);
    }

    @GetMapping("/users")
    public List<Users> getUsers() {
        return userService.getUsers();
    }


    @PostMapping("/user")
    public void addUser(@RequestBody Users user) {
        userService.registerUser(user);
    }

    @PutMapping("/user")
    public String  updateUser(@RequestBody Users user) {
        userService.updateUser(user);
        return "user with username="+user.getUsername()+ "updated successfully";
    }

    @DeleteMapping("/user/{id}")
    public String  deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "user with id="+id+ "deleted successfully";
    }


}

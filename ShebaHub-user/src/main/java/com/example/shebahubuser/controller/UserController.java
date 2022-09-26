package com.example.shebahubuser.controller;

import com.example.shebahubuser.model.Users;
import com.example.shebahubuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getuser/{id}")
    public Optional<Users> getUserInfo(@PathVariable("id") Long id) {
       return userService.getUser(id);
    }

    @GetMapping("/getusers")
    public List<Users> getUsers() {
        return userService.getUsers();
    }


    @PostMapping("/createuser")
    public void addUser(@RequestBody Users user) {
        userService.registerUser(user);
    }

    @PutMapping("/update")
    public String  updateUser(@RequestBody Users user) {
        userService.updateUser(user);
        return "user with username="+user.getUsername()+ "updated successfully";
    }

    @DeleteMapping("/delete/{id}")
    public String  deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "user with id="+id+ "deleted successfully";
    }


}

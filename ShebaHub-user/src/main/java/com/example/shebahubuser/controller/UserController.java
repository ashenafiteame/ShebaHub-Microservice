package com.example.shebahubuser.controller;

import com.example.shebahubuser.DTO.request.AuthenticationRequest;
import com.example.shebahubuser.DTO.response.AuthenticationResponse;
import com.example.shebahubuser.authentication.jwt.JWTUtil;
import com.example.shebahubuser.authentication.service.MyUserDetailService;
import com.example.shebahubuser.model.Users;
import com.example.shebahubuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
<<<<<<< HEAD
@RequestMapping("/api")
=======
@RequestMapping("/api/user")
>>>>>>> Authentication
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private MyUserDetailService userDetailService;

    @Autowired
    private JWTUtil jwtTokenUtil;

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


    /***
     *
     * Authentication
     * ***/
    @PostMapping("/authentication")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getUsername(),
                            authenticationRequest.getPassword()
                    )
            );

        }catch (BadCredentialsException e){
            throw  new Exception("Incorrect username or password",e);
        }
        final UserDetails userDetails = userDetailService.loadUserByUsername(
                authenticationRequest.getUsername()
        );
        Optional<Users> user = userService.findByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);
        System.out.println(jwt);

        return ResponseEntity.ok(new AuthenticationResponse(user.get() ,jwt));
    }


}

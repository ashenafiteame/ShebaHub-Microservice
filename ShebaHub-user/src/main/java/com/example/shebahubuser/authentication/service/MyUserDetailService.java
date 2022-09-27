package com.example.shebahubuser.authentication.service;

import com.example.shebahubuser.authentication.model.MyUserDetails;
import com.example.shebahubuser.model.Users;
import com.example.shebahubuser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> user = userRepository.findUserByUsername(username);
        user.orElseThrow(()->new UsernameNotFoundException("Not found:" +user));
        return user.map(MyUserDetails::new).get();
    }
}

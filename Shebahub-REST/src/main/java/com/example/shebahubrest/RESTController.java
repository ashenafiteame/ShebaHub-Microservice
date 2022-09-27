package com.example.shebahubrest;

import com.example.shebahubrest.Models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/sheba")
public class RESTController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("{/userId}")
    public Users getUsers(@PathVariable("userId") String userId){
        System.out.println(userId);
        Users users = restTemplate.getForObject("http://user-service/getuser", Users.class);
        return users;
    }

}

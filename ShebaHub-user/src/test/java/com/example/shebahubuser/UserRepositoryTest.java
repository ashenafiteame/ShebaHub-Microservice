package com.example.shebahubuser;

import com.example.shebahubuser.model.Users;
import com.example.shebahubuser.repository.UserRepository;
import org.joda.time.LocalDate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepoMock;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
        userRepoMock.deleteAll();
    }

    @Test
    void shouldFindUserByUsername() {
        Users user= new Users(
                "hagos",
                "hagos",
                "berhe",
                "hagos.berhe@gmail.com",
               LocalDate.now().toDate()
        );
        userRepoMock.save(user);

        Optional<Users> u=userRepoMock.findUserByUsername(user.getUsername());
        System.out.println(u.toString());
        assertEquals (u.get(),user);
    }
    @Test
    void shouldNotFindUserByUsername() {
        Users user= new Users(
                "hagos",
                "hagos",
                "berhe",
                "hagos.berhe@gmail.com",
                LocalDate.now().toDate()
        );
        userRepoMock.save(user);

        assertNotEquals(userRepoMock.findUserByUsername("yemane").orElse(null) ,user);
    }



}
package com.example.shebahubuser;

import com.example.shebahubuser.model.Users;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Date;

import static org.springframework.http.RequestEntity.post;

@SpringBootTest
@AutoConfigureMockMvc
public class UsersControllerTest {
    private final Faker faker = new Faker();
    @Autowired
    private MockMvc mockMvc;

    @Test
    void canAddUser() throws Exception {
        String firstName = faker.name().firstName();
        String lastName = faker.name().firstName();
        String email = firstName + "@" + lastName + ".com";
        String username = faker.name().username();
        Date dob = faker.date().birthday();

        Users userTest = new Users(
                username,
                firstName,
                lastName,
                email,
                dob
        );
        //when
//        ResultActions resultActions  = mockMvc.perform(
//                post("/api/user/createAccount")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(userTest))
//        );
//        //then
//        resultActions.andExpect(status().isOk());
    }
}

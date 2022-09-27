package com.example.shebahubrating;


import com.example.shebahubrating.model.Vote;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

@SpringBootTest
@AutoConfigureMockMvc
public class RatingControllerTest {
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

        Vote voteTest = new Vote(
                10L,10L
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

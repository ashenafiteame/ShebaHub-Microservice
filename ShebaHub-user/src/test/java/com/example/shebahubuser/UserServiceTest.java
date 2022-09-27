package com.example.shebahubuser;

import com.example.shebahubuser.model.Users;
import com.example.shebahubuser.repository.UserRepository;
import com.example.shebahubuser.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import com.github.javafaker.Faker;

import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.BDDAssumptions.given;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
@ExtendWith({MockitoExtension.class})
class UserServiceTest {
    private final Faker faker = new Faker();
    @Mock
    private UserRepository userRepository;
    private UserService userServiceMock;

    @BeforeEach
    void setUp() {
        userServiceMock=new UserService(userRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
    }
    @Test
    void canGetAllUsers() {
        userServiceMock.getUsers();
        verify(userRepository).findAll();
    }


    @Test
    void canRegisterUser() {
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
        userServiceMock.registerUser(userTest);
        ArgumentCaptor<Users> usersArgumentCaptor=ArgumentCaptor.forClass(Users.class);
        verify(userRepository).save(usersArgumentCaptor.capture());
        Users userCaptured=usersArgumentCaptor.getValue();
        assertThat(userCaptured).isEqualTo(userTest);

    }

    @Test
    void willThrowWhenUsernameIsTaken(){
        //given
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
//        given(userRepository.findUserByUsername(anyString())).isEqualTo(true);
//        //when
//        //then
//        assertThatThrownBy(()-> userServiceMock.registerUser(userTest))
//                .isInstanceOf(IllegalStateException.class)
//                .hasMessageContaining("username is Taken");
       // verify(userRepository, never()).save(any());
    }

    @Test
    void getUser() {
    }

    @Test
    void findByUsername() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }
}
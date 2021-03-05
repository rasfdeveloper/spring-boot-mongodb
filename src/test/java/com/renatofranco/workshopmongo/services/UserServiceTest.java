package com.renatofranco.workshopmongo.services;

import com.renatofranco.workshopmongo.domain.User;
import com.renatofranco.workshopmongo.repository.UserRepository;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;


public class UserServiceTest {

    private static UserRepository userRepository;

    private static UserService userService;

    private User userOutput;

    @BeforeAll
    public static void setup(){
        userRepository = mock(UserRepository.class);
        userService = new UserService(userRepository);
    }

    @BeforeEach
    public void initialize() {
        userOutput = new User("1234", "teste", "teste@gmail.com");
    }

    @Test
    @DisplayName("Should return all users")
    public void whenUseUserFindAll_thenReturnAllUsers(){
        List<User> users = Arrays.asList(
                new User(null, "teste1", "teste1@gmail.com"),
                new User(null, "teste2", "teste2@gmail.com")
        );

        // GIVEN
        when(userRepository.findAll()).thenReturn(users);

        // WHEN
        List<User> response = userService.findAll();

        // THEN
//        assertEquals(response, users);

    }

    @Test
    @DisplayName("Should return a user by id")
    public void whenUseUserFindById_thenReturnUser(){

        // GIVEN
        when(userRepository.findById("1234")).thenReturn(Optional.of(userOutput));

        // WHEN
        User response = userService.findById("1234");

        // THEN
        assertEquals(response, userOutput);

    }

    @Test
    @DisplayName("Should create user")
    public void whenUseUserInsert_thenReturnStatusCreated(){
        User input = new User("12345", "teste", "teste12@gmail.com");

        // GIVEN
        when(userRepository.insert(input)).thenReturn(userOutput);

        // WHEN
        User response = userService.insert(input);

        //THEN
        assertEquals(response, input);

    }

}

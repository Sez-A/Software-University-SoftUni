package com.example.pathfinder.web;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.example.pathfinder.model.entity.User;
import com.example.pathfinder.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
    }

    @Test
    void testOpenRegisterForm() throws Exception {
        mockMvc
                .perform(get("/users/register"))
                .andExpect(status().isOk())
                .andExpect(view().name("register"));
    }

    private static final String TEST_USER_USERNAME = "pesho77";
    private static final String TEST_USER_EMAIL = "pesho@example.com";
    private static final int TEST_USER_AGE = 18;
    private static final String TEST_USER_FULL_NAME = "Pesho Petrov";
    private static final String TEST_USER_PASSWORD = "12345";

    @Test
    void testRegisterNewUser() throws Exception {
        mockMvc.perform(post("/users/register")
                .param("username", TEST_USER_USERNAME)
                .param("age", String.valueOf(TEST_USER_AGE))
                .param("email", TEST_USER_EMAIL)
                .param("fullName", TEST_USER_FULL_NAME)
                .param("password", TEST_USER_PASSWORD)
                .param("confirmPassword", TEST_USER_PASSWORD)
                .with(csrf())
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
        ).andExpect(status().is3xxRedirection());

        assertEquals(1, userRepository.count());

        Optional<User> newlyCreatedUserOpt = userRepository.findByUsername(TEST_USER_USERNAME);

        assertTrue(newlyCreatedUserOpt.isPresent());

        User newlyCreatedUser = newlyCreatedUserOpt.get();

        assertEquals(TEST_USER_USERNAME, newlyCreatedUser.getUsername());
        assertEquals(TEST_USER_EMAIL, newlyCreatedUser.getEmail());
        assertEquals(TEST_USER_AGE, newlyCreatedUser.getAge());
        assertEquals(TEST_USER_FULL_NAME, newlyCreatedUser.getFullName());
    }

    @Test
    void testOpenLoginForm() throws Exception {
        mockMvc
                .perform(get("/users/login"))
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }
}
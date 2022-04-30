package com.example.pathfinder.web;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.pathfinder.model.entity.Comments;
import com.example.pathfinder.model.entity.Route;
import com.example.pathfinder.model.entity.User;
import com.example.pathfinder.repository.RouteRepository;
import com.example.pathfinder.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@WithMockUser("user")
@SpringBootTest
@AutoConfigureMockMvc
class CommentRestControllerTest {
    private static final String COMMENT_1 = "First comment text content";
    private static final String COMMENT_2 = "Second comment text content";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private UserRepository userRepository;

    private User testUser;

    @BeforeEach
    void setUp() {
        testUser = new User();
        testUser.setPassword("password");
        testUser.setUsername("user");
        testUser.setEmail("user@userov.com");
        testUser.setFullName("User Userov");

        testUser = userRepository.save(testUser);
    }

    @AfterEach
    void tearDown() {
        routeRepository.deleteAll();
        userRepository.deleteAll();
    }

    @Test
    void testGetComments() throws Exception {
        Long routeId = initRoute();

        mockMvc.perform(get("/api/" + routeId + "/comments"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$.[0].message", is(COMMENT_1)))
                .andExpect(jsonPath("$.[1].message", is(COMMENT_2)));
    }

    private Long initRoute() {
        Route testRoute = new Route();
        testRoute.setName("Testing route");

        testRoute = routeRepository.save(testRoute);

        Comments firstComment = new Comments();
        firstComment.setApproved(true);
        firstComment.setCreated(LocalDateTime.now());
        firstComment.setTextContent(COMMENT_1);
        firstComment.setAuthor(testUser);
        firstComment.setRoute(testRoute);

        Comments secondComment = new Comments();
        secondComment.setApproved(true);
        secondComment.setCreated(LocalDateTime.now());
        secondComment.setTextContent(COMMENT_2);
        secondComment.setAuthor(testUser);
        secondComment.setRoute(testRoute);

        testRoute.setComments(List.of(firstComment, secondComment));
        return routeRepository.save(testRoute).getId();
    }
}
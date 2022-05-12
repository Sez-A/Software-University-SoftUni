package com.example.pathfinder.service.impl;

import com.example.pathfinder.model.entity.Role;
import com.example.pathfinder.model.entity.User;
import com.example.pathfinder.model.entity.enums.RoleNamesEnum;
import com.example.pathfinder.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PathfinderUserDetailsServiceImplTest {
    private User testUser;
    private Role adminRole, userRole;
    private PathfinderUserDetailsServiceImpl serviceToTest;

    @Mock
    private UserRepository mockUserRepository;


    @BeforeEach
    void init() {
        serviceToTest = new PathfinderUserDetailsServiceImpl(mockUserRepository);

        adminRole = new Role();
        adminRole.setRole(RoleNamesEnum.ADMIN);
        userRole = new Role();
        userRole.setRole(RoleNamesEnum.USER);

        testUser = new User();
        testUser.setUsername("testUser");
        testUser.setPassword("password");
        testUser.setFullName("test user");
        testUser.setRoles(Set.of(adminRole, userRole));
    }

    @Test
    void testUserNotFound() {
        assertThrows(
                UsernameNotFoundException.class,
                () -> serviceToTest.loadUserByUsername("not exist user")
        );
    }

    @Test
    void testUserFound() {
        Mockito.when(mockUserRepository.findByUsername(testUser.getUsername()))
                .thenReturn(Optional.of(testUser));

        UserDetails actual =
                serviceToTest.loadUserByUsername(testUser.getUsername());

        String expectedRoles = "ROLE_ADMIN, ROLE_USER";
        String actualRoles = actual.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(", "));

        assertEquals(expectedRoles, actualRoles);
        assertEquals(actual.getUsername(), testUser.getUsername());
    }
}
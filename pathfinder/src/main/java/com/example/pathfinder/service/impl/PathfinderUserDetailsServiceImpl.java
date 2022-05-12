package com.example.pathfinder.service.impl;

import com.example.pathfinder.model.entity.User;
import com.example.pathfinder.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PathfinderUserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public PathfinderUserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userEntity = this.userRepository.findByUsername(username).
                orElseThrow(() ->
                        new UsernameNotFoundException("User with username " + username + " was not found!"));


        return this.map(userEntity);
    }

    private UserDetails map(User userEntity) {
        Set<GrantedAuthority> grantedAuthorities =
                userEntity
                        .getRoles()
                        .stream()
                        .map(r -> new SimpleGrantedAuthority("ROLE_" + r.getRole().name()))
                        .collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(
                userEntity.getUsername(),
                userEntity.getPassword(),
                grantedAuthorities
        );
    }
}

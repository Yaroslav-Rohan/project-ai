package com.project.Band_Search.service;

import com.project.Band_Search.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    public UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        if (userRepository.findByEmail(email) != null)
            return new User(email, userRepository.findByEmail(email).getPassword(),
                    new ArrayList<>());
        else {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
    }
}
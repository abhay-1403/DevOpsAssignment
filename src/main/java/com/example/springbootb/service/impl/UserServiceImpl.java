package com.example.springbootb.service.impl;

import com.example.springbootb.dto.RegistrationDto;
import com.example.springbootb.entity.Role;
import com.example.springbootb.entity.User;
import com.example.springbootb.repository.RoleRepository;
import com.example.springbootb.repository.UserRepository;
import com.example.springbootb.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(RegistrationDto registrationDto) {
        User user = new User();
        user.setName(registrationDto.getFirstName() + " " + registrationDto.getLastName());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
//        Role role = roleRepository.findByName("ROLE_GUEST");
        // Fetch the ROLE_GUEST from the database
        Role role = roleRepository.findByName("ROLE_GUEST");

        // Ensure the role is not null before assigning
        if (role != null) {
            user.setRoles(Collections.singletonList(role));
        } else {
            // If ROLE_GUEST is not found, handle the error accordingly
            throw new RuntimeException("Role ROLE_GUEST not found in the database.");
        }
        userRepository.save(user);
    }
    //write test case

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}

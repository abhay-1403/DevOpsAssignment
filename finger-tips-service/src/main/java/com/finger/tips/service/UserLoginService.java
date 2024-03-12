package com.finger.tips.service;

import com.finger.tips.dao.UserRepo;
import com.finger.tips.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserLoginService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepo dao;

    public List<User> getAllUsers(){
        return dao.findAll();
    }

    public void postUser(User user){
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        dao.save(user);
    }

    public Optional<User> authenticateUser(String email, String password) {
        Optional<User> userOptional = dao.findByEmail(email);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (passwordEncoder.matches(password, user.getPassword())) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }
}

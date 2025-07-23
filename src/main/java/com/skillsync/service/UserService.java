package com.skillsync.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.skillsync.model.User;
import com.skillsync.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Save new user with encoded password
    public void saveUser(User user) {
        // Encode password before saving to DB
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }

    // Optional: get user by email
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}


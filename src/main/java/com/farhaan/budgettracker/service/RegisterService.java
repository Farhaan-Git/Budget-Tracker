package com.farhaan.budgettracker.service;


import com.farhaan.budgettracker.model.User;
import com.farhaan.budgettracker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class RegisterService {

    private final BCryptPasswordEncoder encoder;

    private final UserRepository userRepository;

    public User register(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

}

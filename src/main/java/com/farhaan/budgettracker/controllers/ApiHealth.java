package com.farhaan.budgettracker.controllers;


import com.farhaan.budgettracker.config.JwtService;
import com.farhaan.budgettracker.model.User;
import com.farhaan.budgettracker.repository.UserRepository;
import com.farhaan.budgettracker.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("api/v1/api-health")
public class ApiHealth {

    private Optional<User> user;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public ResponseEntity<Object> checkHealth(@RequestHeader("Authorization") String token){
        user = userRepository.findByUsername(jwtService.extractUsername(token.replace("Bearer","")));
                return ResponseUtil.getResponse("API is healthy "+"User authentication :"+user.get().getAuthorities()+" which class :"+user.get().getAuthorities().getClass(), HttpStatus.OK);
    }

}

package com.farhaan.budgettracker.service;

import com.farhaan.budgettracker.Dto.LoginDto;
import com.farhaan.budgettracker.config.JwtService;
import com.farhaan.budgettracker.model.User;
import com.farhaan.budgettracker.repository.UserRepository;
import com.farhaan.budgettracker.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    private final JwtService jwtService;

    public ResponseEntity<Object> login(LoginDto loginDto){

        Optional<User> user = (userRepository.findByUsername(loginDto.getUsername()));

        if(user.isPresent()){
            return ResponseUtil.getResponseWithData("User logged in succesfully",jwtService.generateToken(user.get()), HttpStatus.OK);
        }

        return ResponseUtil.getResponse("Wrong credentials", HttpStatus.UNAUTHORIZED);
    }
}

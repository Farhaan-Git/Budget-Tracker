package com.farhaan.budgettracker.controllers;


import com.farhaan.budgettracker.Dto.LoginDto;
import com.farhaan.budgettracker.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/v1/auth/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/submit")
    public ResponseEntity<Object> userLogin(@RequestBody LoginDto loginDto){

        return loginService.login(loginDto);
    }
}

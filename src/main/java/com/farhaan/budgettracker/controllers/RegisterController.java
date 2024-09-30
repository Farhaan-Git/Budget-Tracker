package com.farhaan.budgettracker.controllers;


import com.farhaan.budgettracker.model.User;
import com.farhaan.budgettracker.service.RegisterService;
import com.farhaan.budgettracker.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/v1/auth/register")
public class RegisterController {

    private final RegisterService registerService;

    @PostMapping("/submit")
    public ResponseEntity<Object> register(@RequestBody User user){

        return ResponseUtil.getResponseWithData("User registered Sucessfully, complete the next steps",registerService.register(user), HttpStatus.OK);
    }
}

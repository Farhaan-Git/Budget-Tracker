package com.farhaan.budgettracker.controllers;

import com.farhaan.budgettracker.model.CustomerModel;
import com.farhaan.budgettracker.model.ShopModel;
import com.farhaan.budgettracker.service.RoleRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/v1/roleregister")
public class RoleRegisterController {

    private final RoleRegisterService roleRegisterService;

    @PostMapping("/customerregister")
    public ResponseEntity<Object> customerRegistration(@RequestBody CustomerModel customerModel, @RequestHeader("Authorization") String token){

        return roleRegisterService.saveCustomer(token.replace("Bearer",""),customerModel);
    }

    @PostMapping("/shopregister")
    public ResponseEntity<Object> shopRegistration(@RequestBody ShopModel shopModel, @RequestHeader("Authorization") String token) {

        return roleRegisterService.saveShop(token.substring(7), shopModel);

    }
}

package com.farhaan.budgettracker.service;

import com.farhaan.budgettracker.config.JwtService;
import com.farhaan.budgettracker.model.CustomerModel;
import com.farhaan.budgettracker.model.ShopModel;
import com.farhaan.budgettracker.repository.CustomerRepository;
import com.farhaan.budgettracker.repository.ShopRepository;
import com.farhaan.budgettracker.util.ResponseUtil;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.RequiredTypes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleRegisterService {

    private final JwtService jwtService;

    private final CustomerRepository customerRepository;

    private final ShopRepository shopRepository;

    public ResponseEntity<Object> saveCustomer(String token, CustomerModel customerModel) {
        long userId = jwtService.extractAllClaims(token).get("Id", Long.class);
        customerModel.setUserId(userId);
        customerRepository.save(customerModel);
        return ResponseUtil.getResponse("Customer Registered successfully", HttpStatus.OK);

    }


    public ResponseEntity<Object> saveShop(String token, ShopModel shopModel) {
        long userId = jwtService.extractAllClaims(token).get("Id", Long.class);
        shopModel.setUserId(userId);
        shopRepository.save(shopModel);
        return ResponseUtil.getResponse("Shop details Registered successfully", HttpStatus.OK);

    }
}

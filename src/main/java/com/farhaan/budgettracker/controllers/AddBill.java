package com.farhaan.budgettracker.controllers;

import com.farhaan.budgettracker.model.CustomerBillModel;
import com.farhaan.budgettracker.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/v1/bill")
@Controller
@RequiredArgsConstructor
public class AddBill {

    private final BillService billService;

    @PostMapping("/add")
    public ResponseEntity<Object> addBill(@RequestBody CustomerBillModel customerBill, @RequestHeader("Authorization") String token){
        return billService.addNewBill(token.substring(7),customerBill);
    }
}

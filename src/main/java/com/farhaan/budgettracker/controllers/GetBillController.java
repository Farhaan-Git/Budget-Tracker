package com.farhaan.budgettracker.controllers;

import com.farhaan.budgettracker.repository.BillRepository;
import com.farhaan.budgettracker.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/v1/bill")
@RequiredArgsConstructor
public class GetBillController {

    private final BillService billService;

    @GetMapping("/get")
    public ResponseEntity<Object> getBill(@RequestHeader("Authorization") String token){
        return  billService.getBillForCustomer(token.substring(7));
    }
}

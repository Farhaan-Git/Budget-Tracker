package com.farhaan.budgettracker.service;

import com.farhaan.budgettracker.config.JwtService;
import com.farhaan.budgettracker.model.CustomerBillModel;
import com.farhaan.budgettracker.model.CustomerModel;
import com.farhaan.budgettracker.repository.BillRepository;
import com.farhaan.budgettracker.repository.CustomerRepository;
import com.farhaan.budgettracker.util.ResponseUtil;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BillService {

    private final BillRepository billRepository;

    private final CustomerRepository customerRepository;

    private final JwtService jwtService;

    public ResponseEntity<Object> addNewBill(String token, CustomerBillModel customerBill) {

        String userId = jwtService.extractClaim(token, Claims::getId);

        CustomerBillModel customerBillModel =billRepository.save(customerBill);

        return ResponseUtil.getResponse("Bill added succesfully", HttpStatus.OK);

    }

    public ResponseEntity<Object> getBillForCustomer(String token){

        String userId = jwtService.extractClaim(token,Claims::getId);
        Optional<CustomerModel> customerModel =  customerRepository.findByUserId(Long.parseLong(userId));
        long customerId = customerModel.get().getCustomerId();

        List<CustomerBillModel> customerBillModelList = billRepository.findAllByCustomerId(customerId);

        if(customerBillModelList.isEmpty()){
            return ResponseUtil.getResponse("No bills are found", HttpStatus.NOT_FOUND);
        }
        return ResponseUtil.getResponseWithData("bills found",customerBillModelList,HttpStatus.FOUND);

    }
}

package com.farhaan.budgettracker.service;

import com.farhaan.budgettracker.Dto.CustomerBillDto;
import com.farhaan.budgettracker.Dto.Item;
import com.farhaan.budgettracker.config.JwtService;
import com.farhaan.budgettracker.model.CustomerBillModel;
import com.farhaan.budgettracker.model.CustomerModel;
import com.farhaan.budgettracker.repository.BillRepository;
import com.farhaan.budgettracker.repository.CustomerRepository;
import com.farhaan.budgettracker.util.ListToJsonconverter;
import com.farhaan.budgettracker.util.ResponseUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BillService {

    private final BillRepository billRepository;

    private final CustomerRepository customerRepository;

    private final JwtService jwtService;

    private final ModelMapper modelMapper;

    public ResponseEntity<Object> addNewBill(String token, CustomerBillDto customerBill)  {
        Logger logger = LoggerFactory.getLogger(BillService.class);
        ObjectMapper objectMapper = new ObjectMapper();
        long userId = jwtService.extractAllClaims(token).get("Id", Long.class);
        Optional<CustomerModel> customerModel =  customerRepository.findByUserId(userId);
        long customerId = customerModel.get().getCustomerId();
        customerBill.setCustomerId(customerId);
        logger.info("before convertion:\n"+customerBill.toString());
        CustomerBillModel bill = modelMapper.map(customerBill,CustomerBillModel.class);
        bill.setItemsList(ListToJsonconverter.convertToString(customerBill.getItemsList()));
        logger.info("After convertion:\n"+customerBill.toString());
        billRepository.save(bill);
        return ResponseUtil.getResponse("Bill added succesfully", HttpStatus.OK);
    }

    public ResponseEntity<Object> getBillForCustomer(String token){

        long userId = jwtService.extractAllClaims(token).get("Id", Long.class);
        Optional<CustomerModel> customerModel =  customerRepository.findByUserId(userId);
        long customerId = customerModel.get().getCustomerId();

        List<CustomerBillModel> customerBillModelList = billRepository.findAllByCustomerId(customerId);

        if(customerBillModelList.isEmpty()){
            return ResponseUtil.getResponse("No bills are found", HttpStatus.NOT_FOUND);
        }
        List<CustomerBillDto> customerBillDtoList = new ArrayList<>();
        for(CustomerBillModel temp:customerBillModelList){
            CustomerBillDto tempModel = modelMapper.map(temp,CustomerBillDto.class);
            tempModel.setItemsList(ListToJsonconverter.convertToJson(temp.getItemsList()));
           customerBillDtoList.add(tempModel);
        }
        return ResponseUtil.getResponseWithData("bills found",customerBillDtoList,HttpStatus.FOUND);

    }
}

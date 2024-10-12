package com.farhaan.budgettracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "customerBill")
public class CustomerBillModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "billid")
    private long billId;

    @Column(name = "customerid")
    private long customerId;

    @Column(name = "username")
    private String customerUsername;

    @Column(name = "shopid")
    private long shopId;

    @Column(name = "shopname")
    private String shopName;

    @Column(name = "totalamount")
    private double totalAmount;

    @Column(name = "billdate")
    private LocalDateTime billCreatedDate;

//    @Column(name = "itemslist",columnDefinition = "jsonb")
//    @Convert(converter = ListToJsonBconverter.class)
//    private Map<String,Double> itemsmap;

    @Column(name = "itemslist")
    private String itemsList;

//    public void setItemsmap(HashMap<String,Double> hashMap) throws JsonProcessingException{
//        ObjectMapper objectMapper  = new ObjectMapper();
//        this.itemsmap = objectMapper.writeValueAsString(hashMap);
//    }
//
//    public HashMap<String,Double> getItemsmapAsHashMap(String itemsmapAsString) throws JsonProcessingException {
//
//        return new ObjectMapper().readValue(itemsmapAsString, HashMap.class);
//    }
}

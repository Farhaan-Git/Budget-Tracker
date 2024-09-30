package com.farhaan.budgettracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Entity
@NoArgsConstructor
@AllArgsConstructor
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
    private long customerUsername;

    @Column(name = "shopid")
    private long shopId;

    @Column(name = "shopname")
    private String shopName;

    @Column(name = "totalamount")
    private double totalAmount;

    @Column(name = "billdate")
    private LocalDateTime billCreatedDate;

    @Column(name = "itemslist")
    private Map<String,Double> itemsmap;


}

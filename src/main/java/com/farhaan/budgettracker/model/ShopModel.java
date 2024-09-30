package com.farhaan.budgettracker.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "shops")
public class ShopModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shopid")
    private long shopId;

    @Column(name = "shopname",nullable = false)
    private String shopName;

    @Column(name = "phonenumber",nullable = false)
    private String phoneNumber;

    @Column(name = "address",nullable = false)
    private String address;

    @Column(name = "userid")
    private long userId;

}

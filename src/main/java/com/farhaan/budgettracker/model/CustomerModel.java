package com.farhaan.budgettracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "customers")
public class CustomerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerId")
    private long customerId;

    @Column(name = "phonenumber",unique = true)
    private String phoneNumber;

    @Column(name = "userid")
    private long userId;

}

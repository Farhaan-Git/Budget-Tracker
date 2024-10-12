package com.farhaan.budgettracker.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerBillDto {
    private long billId;

    private long customerId;

    private String customerUsername;

    private long shopId;

    private String shopName;

    private double totalAmount;

    private LocalDateTime billCreatedDate;

    private List<Item> itemsList;
}

package com.farhaan.budgettracker.repository;

import com.farhaan.budgettracker.model.CustomerBillModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BillRepository extends JpaRepository<CustomerBillModel,Long> {

    List<CustomerBillModel> findAllByCustomerId(long CustomerId);

    Optional<List<CustomerBillModel>> findAllByShopId(long ShopId);

    Optional<CustomerBillModel> findByBillId(long BillId);
}

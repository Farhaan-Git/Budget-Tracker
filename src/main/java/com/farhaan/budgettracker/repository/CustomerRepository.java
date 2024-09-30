package com.farhaan.budgettracker.repository;

import com.farhaan.budgettracker.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel,Long> {

    Optional<CustomerModel> findByCustomerId(long customerId);

    Optional<CustomerModel> findByUserId(long userId);


}

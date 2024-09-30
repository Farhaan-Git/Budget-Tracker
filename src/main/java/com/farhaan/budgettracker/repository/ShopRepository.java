package com.farhaan.budgettracker.repository;

import com.farhaan.budgettracker.model.CustomerModel;
import com.farhaan.budgettracker.model.ShopModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShopRepository extends JpaRepository<ShopModel,Long> {

    Optional<ShopModel> findByShopId(long shopId);

    Optional<ShopModel> findByUserId(long userId);
}

package com.farhaan.budgettracker.repository;

import com.farhaan.budgettracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByUsername(String Username);

    @Query("select u.username from User u where u.id= :userId")
    Optional<String> getUsernameByUserId(@Param("userId")Long userId);


}

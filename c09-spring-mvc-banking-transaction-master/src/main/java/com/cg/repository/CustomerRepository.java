package com.cg.repository;

import com.cg.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Modifying
    @Query("UPDATE  Customer c SET c.balance = c.balance + :transactionAmount WHERE c.id = :id")
    void incrementBalance(@Param("transactionAmount") BigDecimal transactionAmount, @Param("id") Long id);

    @Modifying
    @Query("UPDATE  Customer c SET c.balance = c.balance - :transactionAmount WHERE c.id = :id")
    void reduceBalance(@Param("transactionAmount") BigDecimal transactionAmount, @Param("id") Long id);
}

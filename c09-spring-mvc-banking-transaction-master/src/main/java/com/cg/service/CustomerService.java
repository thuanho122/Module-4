package com.cg.service;

import com.cg.model.Customer;
import com.cg.model.Deposit;
import com.cg.model.Withdraw;

import java.math.BigDecimal;

public interface CustomerService extends IGeneralService<Customer> {
    void increment(Long id, Deposit deposit);

    void reduceBalance(Long customerId, Withdraw withdraw);

}

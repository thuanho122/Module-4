package com.cg.service;

import com.cg.model.Customer;
import com.cg.model.Deposit;
import com.cg.model.Transfer;
import com.cg.model.Withdraw;
import com.cg.repository.CustomerRepository;
import com.cg.repository.DepositRepository;
import com.cg.repository.TransferRepository;
import com.cg.repository.WithdrawRepository;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private DepositRepository depositRepository;

    @Autowired
    private WithdrawRepository withdrawRepository;

    @Autowired
    private TransferRepository transferRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer getById(Long id) {
        return customerRepository.getById(id);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public void incrementBalance(Long customerId, Deposit deposit) {
        customerRepository.incrementBalance(deposit.getTransactionAmount(), customerId);

        depositRepository.save(deposit);

    }

    @Override
    public void reduceBalance(Long customerId, Withdraw withdraw) {
        customerRepository.reduceBalance(withdraw.getTransactionAmount(), customerId);

        withdrawRepository.save(withdraw);
    }

    @Override
    public void transferBalance(Long senderId, Long recipientId, Transfer transfer) {
        customerRepository.incrementBalance(transfer.getTransactionAmount(), recipientId);

        customerRepository.reduceBalance(transfer.getTransferAmount(), senderId);

    }

    @Override
    public List<Customer> findAllByIdNot(Long id) {
        return customerRepository.findAllByIdNot(id);
    }
}

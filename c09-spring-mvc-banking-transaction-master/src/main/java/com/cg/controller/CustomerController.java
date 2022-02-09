package com.cg.controller;


import com.cg.model.Customer;
import com.cg.model.Deposit;
import com.cg.model.Withdraw;
import com.cg.service.CustomerService;
import com.cg.service.DepositService;
import com.cg.service.WithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private DepositService depositService;

    @Autowired
    private WithdrawService withdrawService;

    @GetMapping
    public ModelAndView showListPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("customer/list");

        List<Customer> customers = customerService.findAll();

        modelAndView.addObject("customers", customers);

        return modelAndView;
    }


    @GetMapping("/create")
    public ModelAndView showCreatePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("customer/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @GetMapping("/deposit/{id}")
    public ModelAndView showDepositPage(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("customer/deposit");

        Optional<Customer> customer = customerService.findById(id);

        modelAndView.addObject("customer", customer.get());

        modelAndView.addObject("deposit", new Deposit());
        return modelAndView;
    }

    @GetMapping("/withdraw/{id}")
    public ModelAndView showWithdrawPage(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("customer/withdraw");
        modelAndView.addObject("withdraw", new Withdraw());


        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            modelAndView.addObject("customer", customer.get());
        } else {
            modelAndView.addObject("customer", null);
        }
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView doCreatePage(@ModelAttribute Customer customer) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("customer/create");
        modelAndView.addObject("customer", new Customer());

        customerService.save(customer);

        return modelAndView;
    }

    @PostMapping("/deposit/{customerId}")
    public ModelAndView doDepositPage(@PathVariable Long customerId, @ModelAttribute Deposit deposit) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("customer/deposit");

//        Optional<Customer> customer = customerService.findById(customerId);
//        modelAndView.addObject("customer", customer.get());
//        depositService.save(deposit);
//
//    //lấy ra thằng balance hiện tại + với thằng transactionAmount ==> ra được thằng balance mới
//        BigDecimal balance = customer.get().getBalance();
//        BigDecimal transactionAmount = deposit.getTransactionAmount();
//        BigDecimal updatedAmount = balance.add(transactionAmount);

        customerService.increment(customerId, deposit);
        modelAndView.addObject("customer", customerService.getById(customerId));

        return modelAndView;
    }

    @PostMapping("/withdraw/{customerId}")
    public ModelAndView doWithdrawPage(@PathVariable Long customerId, @ModelAttribute Withdraw withdraw) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("customer/withdraw");
        modelAndView.addObject("withdraw", new Withdraw());

        Optional<Customer> customer = customerService.findById(customerId);

        if (customer.isPresent()) {

            BigDecimal currentBalance = customer.get().getBalance();
            BigDecimal transactionAmount = withdraw.getTransactionAmount();

            // compareTo trả về 3 giá trị( 0, 1, -1)
            if (currentBalance.compareTo(transactionAmount) >= 0) {
                customerService.reduceBalance(customerId, withdraw);
            }

            modelAndView.addObject("customer", customerService.findById(customerId).get());

        } else {

            modelAndView.addObject("customer", null);
        }
//        modelAndView.addObject("customer", customerService.getById(customerId));

        return modelAndView;
    }

}

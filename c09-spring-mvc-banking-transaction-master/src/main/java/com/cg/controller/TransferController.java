package com.cg.controller;


import com.cg.model.Customer;
import com.cg.model.Deposit;
import com.cg.model.TransferHistory;
import com.cg.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/transfers")
public class TransferController {

    @Autowired
    private TransferService transferService;

    @GetMapping
    public ModelAndView showHistoryPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("transfer/list");

        List<TransferHistory> transferHistories = transferService.findAllTransfer();
        modelAndView.addObject("transferHistories", transferHistories);

        return modelAndView;
    }

//    @PostMapping
//    public ModelAndView doHistoryPage(@PathVariable Long customerId, @ModelAttribute Deposit deposit) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("customer/deposit");
//
//        customerService.incrementBalance(customerId, deposit);
//
//        Optional<Customer> customer = customerService.findById(customerId);
//        if(customer.isPresent()){
//            modelAndView.addObject("customer", customer.get());
//        } else{
//            modelAndView.addObject("customer", null);
//        }
////        depositService.save(deposit);
////
////    //lấy ra thằng balance hiện tại + với thằng transactionAmount ==> ra được thằng balance mới
////        BigDecimal balance = customer.get().getBalance();
////        BigDecimal transactionAmount = deposit.getTransactionAmount();
////        BigDecimal updatedAmount = balance.add(transactionAmount);
//
////        customerService.incrementBalance(customerId, deposit);
////        modelAndView.addObject("customer", customerService.getById(customerId));
//
//        return modelAndView;
//    }


}

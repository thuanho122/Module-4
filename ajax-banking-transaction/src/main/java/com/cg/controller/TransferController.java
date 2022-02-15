package com.cg.controller;

import com.cg.model.dto.TransferHistoryDTO;
import com.cg.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/transfers")
public class TransferController {

    @Autowired
    private TransferService transferService;

    @GetMapping
    public ModelAndView showHistoryPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("transfer/list");

        List<TransferHistoryDTO> transferHistories = transferService.findAllTransfer();
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

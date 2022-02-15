package com.cg.controller.api;

import com.cg.model.Customer;
import com.cg.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/customers")
public class CustomerRestController {


    @Autowired
    private CustomerService customerService;

    @GetMapping("/{id}")
    private ResponseEntity<Customer> getById(@PathVariable Long id) {
        Optional<Customer> customer = customerService.findById(id);

        if (customer.isPresent()) {
            return new ResponseEntity<>(customer.get(), HttpStatus.OK);
        } else {
            return  new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
//        return customer.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NO_CONTENT));

    }


    @PostMapping("/create")
    private ResponseEntity<Customer> getById(@RequestBody Customer customer) {
        Customer createdCustomer = customerService.save(customer);

//        Optional<Customer> customer = customerService.findById(id);
//        if (customer.isPresent()) {
//            return new ResponseEntity<>(customer.get(), HttpStatus.OK);
//        } else {
//            return  new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
//        }
//        return customer.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NO_CONTENT));

        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }


}

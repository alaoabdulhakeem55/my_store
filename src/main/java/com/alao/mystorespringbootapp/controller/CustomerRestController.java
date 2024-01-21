package com.alao.mystorespringbootapp.controller;

import com.alao.mystorespringbootapp.dto.CustomerRequest;
import com.alao.mystorespringbootapp.entity.Customer;
import com.alao.mystorespringbootapp.entity.Product;
import com.alao.mystorespringbootapp.exceptions.NotFoundException;
import com.alao.mystorespringbootapp.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class CustomerRestController {

    private CustomerService customerService;

    @PostMapping("/customers")
    public Customer saveCustomer(@RequestBody CustomerRequest request) {

        return customerService.saveCustomer(request);
    }

    @DeleteMapping("/customers/{customerId}")
    public Customer removeCustomer (@PathVariable int customerId) {
        Optional<Customer> tempCustomer = customerService.findById((long) customerId);

        if (tempCustomer.isEmpty()) {
            throw new NotFoundException("Customer id not found - " + customerId);
        }
        return customerService.removeCustomer((long) customerId);
    }

    @GetMapping("/customers")
    public Object findAll() {
        return customerService.findAll();
    }

    @GetMapping("/customers/{customerId}")
    public Optional<Customer> findById(@PathVariable int customerId) {
        Optional<Customer> customer = customerService.findById((long) customerId);

        if (customer.isEmpty()) {
            throw new NotFoundException("Customer " + customerId +  " not found.");
        }
        return customer;
    }
    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody CustomerRequest request) {
        return customerService.updateCustomer(request);
    }


}

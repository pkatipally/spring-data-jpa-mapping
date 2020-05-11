package com.priya.jpa.controller;

import com.priya.jpa.dao.OrderRequest;
import com.priya.jpa.model.Customer;
import com.priya.jpa.repository.CustomerRepository;
import com.priya.jpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/createOrder")
    public Customer placeOrder(@RequestBody OrderRequest orderRequest){
        return customerRepository.save(orderRequest.getCustomer());
    }

    @GetMapping("/getAllOrder")
    public List<Customer> getAllOrder(){
        return customerRepository.findAll();
    }
}

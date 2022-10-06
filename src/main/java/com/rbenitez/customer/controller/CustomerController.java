package com.rbenitez.customer.controller;

import com.rbenitez.customer.entity.Customer;
import com.rbenitez.customer.model.Result;
import com.rbenitez.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/listclientes")
    public ResponseEntity<List<Customer>> getAllCustomers (){
        List<Customer> customers = customerService.getAllCustomers();
        if(customers.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(customers);
    }

    @PostMapping("/creacliente")
    public  ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer){
        Customer newCustomer = customerService.insertCustomer(customer);
        return ResponseEntity.ok(newCustomer);
    }

    @GetMapping("/kpideclientes")
    public ResponseEntity<Result> getCalculationCustomer(){
        List<Customer> customers = customerService.getAllCustomers();
        if(customers.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        Result result = customerService.getCalculation(customers);
        return ResponseEntity.ok(result);
    }
}

package com.rbenitez.customer.service.impl;

import com.rbenitez.customer.entity.Customer;
import com.rbenitez.customer.model.Result;
import com.rbenitez.customer.repository.CustomerRepository;
import com.rbenitez.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;


    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer insertCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Result getCalculation(List<Customer> customers) {
        Result result = new Result();
        if(!customers.isEmpty()){
            result.setAverageAges(result.getAverageAges(customers));
            result.setStandardDeviationAges(result.getstandardDeviationAges(customers));
            return result;
        }else {
            result = null;
        }
        return result;
    }

}

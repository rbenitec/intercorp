package com.rbenitez.customer.service;

import com.rbenitez.customer.entity.Customer;
import com.rbenitez.customer.model.Result;

import java.util.List;

public interface CustomerService {

    /**
     * method to list all customers
     * @return
     */
    List<Customer> getAllCustomers();

    /**
     * Method to Add Customer
     * @param customer
     */
    public Customer insertCustomer(Customer customer);

    /**
     * Method calculator
     * @param customers
     * @return
     */
    public Result getCalculation(List<Customer> customers);

}

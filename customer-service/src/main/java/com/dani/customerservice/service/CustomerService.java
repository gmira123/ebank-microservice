package com.dani.customerservice.service;

import com.dani.customerservice.entities.Customer;
import com.dani.customerservice.repository.CustomerRepositorey;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    final private CustomerRepositorey customerRepositorey;

    public CustomerService(CustomerRepositorey customerRepositorey) {
        this.customerRepositorey = customerRepositorey;
    }

    public List<Customer> getAllCustomers() {
        return customerRepositorey.findAll();
    }

    public Customer findCustomerById(Long id) {
        return customerRepositorey.findById(id)
                .orElseThrow(()-> new RuntimeException("Customer not found"));
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepositorey.save(customer);
    }
}

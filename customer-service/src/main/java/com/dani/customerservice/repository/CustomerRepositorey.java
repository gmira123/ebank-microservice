package com.dani.customerservice.repository;

import com.dani.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepositorey extends JpaRepository<Customer,Long> {
}

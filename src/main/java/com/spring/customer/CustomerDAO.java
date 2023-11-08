package com.spring.customer;

import com.spring.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDAO extends JpaRepository<Customer, Integer> {
}

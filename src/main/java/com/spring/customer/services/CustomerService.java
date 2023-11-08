package com.spring.customer.services;

import com.spring.customer.CustomerDAO;
import com.spring.customer.model.Customer;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CustomerService {

    @Autowired
    CustomerDAO customerDAO;

    public List<Customer> getCustomers() {
        return customerDAO.findAll();
    }

    public void saveCustomer(Customer customer) {
        customerDAO.save(customer);
    }

    public Customer getCustomer(int id) {
        return customerDAO.findById(id).get();
    }

    public void deleteCustomer(int id) {
        customerDAO.deleteById(id);
    }

}

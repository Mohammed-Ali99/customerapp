package com.spring.customer.controller;


import com.spring.customer.model.Customer;
import com.spring.customer.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customers")
    public String getCustomers(Model model) {
        List<Customer> customers = customerService.getCustomers();
        model.addAttribute("customers" , customers);

        return "list-customers";
    }

    @GetMapping("/addCustomer")
    public String addCustomer(Model model) {;
        model.addAttribute("customer" , new Customer());
        return "add-customer";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }

    @GetMapping("/getCustomer")
    public String getCustomer(@RequestParam("customerId") int id , Model model) {
        Customer customer = customerService.getCustomer(id);
        model.addAttribute("customer" , customer);
        return "add-customer";
    }

    @GetMapping("/removeCustomer")
    public String removeCustomer(@RequestParam("customerId") int id) {
        customerService.deleteCustomer(id);
        return "redirect:/customers";
    }

}

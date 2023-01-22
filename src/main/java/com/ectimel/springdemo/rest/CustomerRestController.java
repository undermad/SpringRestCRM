package com.ectimel.springdemo.rest;


import com.ectimel.springdemo.entity.Customer;
import com.ectimel.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;


    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/customer/{customerId}")
    public Customer getCustomer(@PathVariable int customerId) {

        Customer customer = customerService.getCustomer(customerId);
        if (customer == null)
            throw new CustomerNotFoundException("Customer id " + customerId + " not found.");

        return customer;
    }


    // I can use postman application to post this request(select body, raw, json and write you json object)
    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer) {
        // let's set customer id to 0 in order to make sure we will save customer instead of updating
        // hibernate when call method saveOrUpdate get null variable as parameter it will create a new object
        customer.setId(0);

        customerService.saveCustomer(customer);

        return customer;
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer) {

        customerService.saveCustomer(customer);

        return customer;
    }

    @DeleteMapping("/customer/{customerId}")
    public String deleteCustomer(@PathVariable int customerId) {

        Customer customer = customerService.getCustomer(customerId);
        if (customer == null){
            throw new CustomerNotFoundException("Customer with id " + customerId + " doesn't exist.");
        }

        customerService.deleteCustomer(customerId);

        return "Customer with id " + customerId + " has been deleted";
    }

}

package com.ecommerce.WomensDressStore.service;

import com.ecommerce.WomensDressStore.entities.Customer;
import com.ecommerce.WomensDressStore.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }
}

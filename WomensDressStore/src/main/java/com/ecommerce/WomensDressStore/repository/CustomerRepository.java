package com.ecommerce.WomensDressStore.repository;

import com.ecommerce.WomensDressStore.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {
}

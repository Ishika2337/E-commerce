package com.ecommerce.WomensDressStore.repository;

import com.ecommerce.WomensDressStore.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {
}

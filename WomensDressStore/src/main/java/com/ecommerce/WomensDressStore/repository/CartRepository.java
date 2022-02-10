package com.ecommerce.WomensDressStore.repository;

import com.ecommerce.WomensDressStore.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
    public List<Cart> findByCustomerUsername(String username);

    public boolean existsByDressesId(Long id);

    public Cart findByDressesId(Long id);
}

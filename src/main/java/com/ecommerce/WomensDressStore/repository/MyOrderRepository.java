package com.ecommerce.WomensDressStore.repository;

import com.ecommerce.WomensDressStore.entities.MyOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MyOrderRepository extends JpaRepository<MyOrder,Long> {
    public List<MyOrder> findByCustomerUsername(String username);

    public boolean existsByDressesId(Long id);

    public MyOrder findByDressesId(Long id);
    public void deleteByDressesId(Long id);
}

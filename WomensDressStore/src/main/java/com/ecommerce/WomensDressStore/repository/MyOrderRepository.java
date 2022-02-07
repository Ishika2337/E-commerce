package com.ecommerce.WomensDressStore.repository;

import com.ecommerce.WomensDressStore.entities.MyOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyOrderRepository extends JpaRepository<MyOrder,Long> {
}

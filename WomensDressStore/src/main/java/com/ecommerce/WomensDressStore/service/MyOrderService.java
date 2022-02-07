package com.ecommerce.WomensDressStore.service;

import com.ecommerce.WomensDressStore.repository.MyOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyOrderService {
    @Autowired
    private MyOrderRepository myOrderRepository;
}

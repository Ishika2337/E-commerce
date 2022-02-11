package com.ecommerce.WomensDressStore.service;

import com.ecommerce.WomensDressStore.entities.Cart;
import com.ecommerce.WomensDressStore.entities.MyOrder;
import com.ecommerce.WomensDressStore.repository.MyOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Service
public class MyOrderService {
    @Autowired
    private MyOrderRepository myOrderRepository;

    public MyOrder addToMyOrder(MyOrder myOrder) {
        return myOrderRepository.save(myOrder);
    }
    public List<MyOrder> myOrders(String username){
        return myOrderRepository.findByCustomerUsername(username);
    }
    public void remove(Long id) {
        myOrderRepository.deleteById(id);
    }
    public void removeByDressesId(Long id) {
        myOrderRepository.deleteByDressesId(id);
    }
    public boolean existsByDressesId(Long id) {
        return myOrderRepository.existsByDressesId(id);
    }

    public MyOrder findByDressesId(Long id) {
        return myOrderRepository.findByDressesId(id);
    }

}

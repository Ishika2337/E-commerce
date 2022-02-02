package com.ecommerce.WomensDressStore.service;

import com.ecommerce.WomensDressStore.entities.IndianWear;
import com.ecommerce.WomensDressStore.repository.IndianWearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndianWearService {
    @Autowired
    private IndianWearRepository indianWearRepository;

    public IndianWear addIndianWear(IndianWear indianWear){
        return indianWearRepository.save(indianWear);
    }
    public List<IndianWear> indianWearList(){
        return indianWearRepository.findAll();
    }
}

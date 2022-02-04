package com.ecommerce.WomensDressStore.service;

import com.ecommerce.WomensDressStore.entities.IndianWear;
import com.ecommerce.WomensDressStore.repository.IndianWearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IndianWearService {
    @Autowired
    private IndianWearRepository indianWearRepository;

    public IndianWear addIndianWear(IndianWear indianWear){
        return indianWearRepository.save(indianWear);
    }
    public IndianWear getById(Long id){
        return indianWearRepository.getById(id);
    }
//    public Optional<IndianWear> findById(Long id){
//        return indianWearRepository.findById(id);
//    }
    public Boolean existsByIndianWearId(Long id){
        return indianWearRepository.existsById(id);
    }

    public List<IndianWear> indianWearList(){
        return indianWearRepository.findAll();
    }
}

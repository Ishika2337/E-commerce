package com.ecommerce.WomensDressStore.service;

import com.ecommerce.WomensDressStore.entities.IndianWear;
import com.ecommerce.WomensDressStore.entities.WesternWear;
import com.ecommerce.WomensDressStore.repository.IndianWearRepository;
import com.ecommerce.WomensDressStore.repository.WesternWearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WesternWearService {
    @Autowired
    private WesternWearRepository westernWearRepository;

    public WesternWear addWesternWear(WesternWear westernWear){
        return westernWearRepository.save(westernWear);
    }
    public List<WesternWear> westernWearList(){
        return westernWearRepository.findAll();
    }

    public Boolean existsByWesternWearId(Long id){
        return westernWearRepository.existsById(id);
    }

    public WesternWear getById(Long id) {
        return westernWearRepository.getById(id);
    }
}

package com.ecommerce.WomensDressStore.service;

import com.ecommerce.WomensDressStore.entities.Dress;
import com.ecommerce.WomensDressStore.repository.DressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DressService {
    @Autowired
    private DressRepository dressRepository;

    public Dress addDress(Dress dress){
        return dressRepository.save(dress);
    }
    public List<Dress> dressList(String dressType){
        return dressRepository.findByDressType(dressType);
    }

    public List<Dress> findAll() {
        return dressRepository.findAll();
    }
}

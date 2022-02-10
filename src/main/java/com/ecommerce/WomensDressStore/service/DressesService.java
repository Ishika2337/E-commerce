package com.ecommerce.WomensDressStore.service;

import com.ecommerce.WomensDressStore.entities.Dresses;
import com.ecommerce.WomensDressStore.repository.DressesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DressesService {
    @Autowired
    private DressesRepository dressesRepository;

    public Dresses save(Dresses dresses) {
        return dressesRepository.save(dresses);
    }
    public List<Dresses> findByDressType(String dressType){
        return dressesRepository.findByDressType(dressType);
    }

    public Dresses getById(Long id) {
        return dressesRepository.getById(id);
    }

    public List<Dresses> allDresses() {
        return dressesRepository.findAll();
    }

    public void remove(Long id) {
        dressesRepository.deleteById(id);
    }
}

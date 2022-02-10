package com.ecommerce.WomensDressStore.repository;

import com.ecommerce.WomensDressStore.entities.Dresses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DressesRepository extends JpaRepository<Dresses, Long> {
    public List<Dresses> findByDressType(String dressType);
}

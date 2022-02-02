package com.ecommerce.WomensDressStore.repository;

import com.ecommerce.WomensDressStore.entities.Dress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DressRepository extends JpaRepository<Dress, Long> {
    public List<Dress> findByDressType(String dressType);
}

package com.ecommerce.WomensDressStore.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Dress {
    @Id
    @GeneratedValue
    private Long id;
    private String dressType;
    @OneToMany(mappedBy = "dress")
    private List<IndianWear> indianWear;
    @OneToMany(mappedBy = "dress")
    private List<WesternWear> westernWear;

    public Dress() {
    }

    public Dress(String dressType) {
        this.dressType = dressType;
    }

    public List<IndianWear> getIndianWear() {
        return indianWear;
    }

    public void setIndianWear(List<IndianWear> indianWear) {
        this.indianWear = indianWear;
    }

    public List<WesternWear> getWesternWear() {
        return westernWear;
    }

    public void setWesternWear(List<WesternWear> westernWear) {
        this.westernWear = westernWear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDressType() {
        return dressType;
    }

    public void setDressType(String dressType) {
        this.dressType = dressType;
    }
}

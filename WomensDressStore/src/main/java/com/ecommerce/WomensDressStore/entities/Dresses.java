package com.ecommerce.WomensDressStore.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Dresses {
    @Id
    @GeneratedValue
    private Long id;
    private String brand;
    private String dressUrl;
    private Double cost;
    private String dressType;

    public Dresses(String brand, String dressUrl, Double cost, String type) {
        this.brand = brand;
        this.dressUrl = dressUrl;
        this.cost = cost;
        this.dressType = type;
    }

    public Dresses() {
    }

    public String getDressType() {
        return dressType;
    }

    public void setDressType(String dressType) {
        this.dressType = dressType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDressUrl() {
        return dressUrl;
    }

    public void setDressUrl(String dressUrl) {
        this.dressUrl = dressUrl;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}

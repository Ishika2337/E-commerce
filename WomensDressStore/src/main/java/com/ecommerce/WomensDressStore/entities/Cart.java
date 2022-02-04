package com.ecommerce.WomensDressStore.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cart {
    @Id
    @GeneratedValue
    private Long id;
    private String brand;
    private String dressUrl;
    private Double cost;
    @ManyToOne
    private Customer customer;

    public Cart() {
    }

    public Cart(String brand, String dressUrl, Double cost) {
        this.brand = brand;
        this.dressUrl = dressUrl;
        this.cost = cost;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

package com.ecommerce.WomensDressStore.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class MyOrder {
    @Id
    @GeneratedValue
    private Long id;
    private String brand;
    private String dressUrl;
    private Double cost;
    private String name;
    @JsonIgnore
    @ManyToOne
    private Customer customer;

    public MyOrder() {
    }

    public MyOrder(String brand, String dressUrl, Double cost, String name) {
        this.brand = brand;
        this.dressUrl = dressUrl;
        this.cost = cost;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

package com.ecommerce.WomensDressStore.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Dresses {
    @Id
    @GeneratedValue
    private Long id;
    private String brand;
    private String dressUrl;
    private Double cost;
    private String dressType;
    private String name;
    @OneToMany(mappedBy = "dresses")
    private List<Cart> cart;

    public Dresses(String brand, String dressUrl, Double cost, String type, String name) {
        this.brand = brand;
        this.dressUrl = dressUrl;
        this.cost = cost;
        this.dressType = type;
        this.name = name;
    }

    public Dresses() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Cart> getCart() {
        return cart;
    }

    public void setCart(List<Cart> cart) {
        this.cart = cart;
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

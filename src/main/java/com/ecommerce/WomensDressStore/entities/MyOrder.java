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
    @JsonIgnore
    @ManyToOne
    private Customer customer;
    @JsonIgnore
    @ManyToOne
    private Dresses dresses;

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

    public Dresses getDresses() {
        return dresses;
    }

    public void setDresses(Dresses dresses) {
        this.dresses = dresses;
    }
}

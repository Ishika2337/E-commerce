package com.ecommerce.WomensDressStore.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Customer {
    @Id
    private String username;
    private String name;
    private String address;
    @Column(nullable = false)
    private Long phoneNumber;
    @Column(nullable = false)
    private String password;
    private String roles;

    @OneToMany(mappedBy = "customer")
    private List<Cart> cart;

    @OneToMany(mappedBy = "customer")
    private List<MyOrder> myOrders;
    public Customer() {
    }

    public Customer(String username, String name, String address, String password, Long phoneNumber, String roles) {
        this.username = username;
        this.name = name;
        this.address = address;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.roles = roles;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<MyOrder> getMyOrders() {
        return myOrders;
    }

    public void setMyOrders(List<MyOrder> myOrders) {
        this.myOrders = myOrders;
    }

    public List<MyOrder> getOrders() {
        return myOrders;
    }

    public void setOrders(List<MyOrder> myOrders) {
        this.myOrders = myOrders;
    }

    public List<Cart> getCart() {
        return cart;
    }

    public void setCart(List<Cart> cart) {
        this.cart = cart;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}

package com.example.test.model;

import jakarta.persistence.*; // for Spring Boot 3

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;

    @Column(name = "usenot")
    private boolean usenot = true;

    public Product() {

    }

    public Product(Long id, String name, int price, Boolean usenot) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.usenot = usenot;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean getUsenot() {
        return usenot;
    }

    public void setUsenot(boolean usenot) {
        this.usenot = usenot;
    }
}

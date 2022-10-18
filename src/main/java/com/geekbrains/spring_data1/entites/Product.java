package com.geekbrains.spring_data1.entites;

import jdk.jfr.DataAmount;

import javax.persistence.*;


@Entity
@Table(name = "products")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long id;

    @Column(name = "name")
    public String name;

    @Column(name = "cost")
    public Integer cost;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Product(int i, String name,Integer a ){
        this.id = i;
        this.name = name;
        this.cost = a;
    }
    public Product(){

    }
    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", title='" + name + '\'' + ", cost = " + cost +
                '}';
    }
}

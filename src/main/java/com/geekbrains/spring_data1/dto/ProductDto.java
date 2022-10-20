package com.geekbrains.spring_data1.dto;

import com.geekbrains.spring_data1.entites.Product;

import javax.persistence.*;




public class ProductDto {

    public long id;


    public String name;


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
// из класса создаем dto
    public ProductDto(Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.cost = product.getCost();
    }
    public ProductDto(){

    }
    @Override
    public String toString() {
        return "ProductDto{" +
                "id='" + id + '\'' +
                ", title='" + name + '\'' + ", cost = " + cost +
                '}';
    }
}

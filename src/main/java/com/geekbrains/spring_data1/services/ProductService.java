package com.geekbrains.spring_data1.services;


import com.geekbrains.spring_data1.entites.Product;
import com.geekbrains.spring_data1.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

// получить всех студентов это метод findAll() взяли из наслодованного класса рекозитория JpaRepository
    public List<Product> findAll() {
        return productRepository.findAll();
    }


// список продуктов по id Optional - пишется если может быть ошибка что продуст не судествует
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }



    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

// списко между мин и макс ценой
    public List<Product> findByCostBetween(Integer min, Integer max) {
        return productRepository.findAllByCostBetween(min, max);
    }
// продукт с ценой больше мин
    public List<Product> findByProductMoreMinCost() {
        return productRepository.findAllProductMoreMinCost();
    }
    // продукт с ценой меньше макс
    public List<Product> findByProductLessMaxCost() {
        return productRepository.findAllProductLessMaxCost();
    }

}

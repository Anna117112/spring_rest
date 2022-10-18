package com.geekbrains.spring_data1.controllers;


import com.geekbrains.spring_data1.entites.Product;
import com.geekbrains.spring_data1.exceptions.ResourceNotFoundException;
import com.geekbrains.spring_data1.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @PostMapping("/products")
    public Product saveNewProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id) {
        //есл продукт по id найден возвращаем его,  если нет то кидаем инфо об ошибке
        return productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found, id: " + id));
    }

//
    @GetMapping("/products/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

    // находим значение между мин и макс , если они не указаны то по умолчанию мин 0 макс 100
    @GetMapping("/products/cost_between")
    public List<Product> findProductsByCostBetween(@RequestParam(defaultValue = "100") Integer min, @RequestParam(defaultValue = "119") Integer max) {
        return productService.findByCostBetween(min, max);
    }
    // находим значение больше мин
    @GetMapping("/products/cost_more_min")
    public List<Product> findProductsMoreMinCost() {
        return productService.findByProductMoreMinCost();
    }
    // находим значение меньше макс
    @GetMapping("/products/cost_less_max")
    public List<Product> findProductsLessMinCost() {
        return productService.findByProductLessMaxCost();
    }


}

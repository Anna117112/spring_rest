package com.geekbrains.spring_data1.controllers;

import com.geekbrains.spring_data1.dto.ProductDto;
import com.geekbrains.spring_data1.entites.Product;
import com.geekbrains.spring_data1.exceptions.ResourceNotFoundException;
import com.geekbrains.spring_data1.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public Page<ProductDto> getAllProducts(
            // метод может пирменять параменты
            @RequestParam (name = "p", defaultValue = "1") Integer page,// номер страницы
            @RequestParam (name = "min_cost", required = false) Integer minCost,// мин значение если не указано то берем за 0
            @RequestParam (name = "max_cost", required = false)  Integer maxCost, // макс значение
            @RequestParam (name = "name_part", required = false)  String namePart // макс значение
    ) {
        if (page < 1){
            page = 1;
        }
        // map(p->new ProductDto(p) преобразователь из продукта получим новый ProductDto и отдадим туда продукт
        return productService.find(minCost,maxCost,namePart,page).map(p->new ProductDto(p));
    }

//    @PostMapping()
//    public Product saveNewProduct(@RequestBody Product product) {
//        product.setId(null);
//        return productService.save(product);
//    }
//
//    @GetMapping("/{id}")
//    public Product getProductById(@PathVariable Long id) {
//        //есл продукт по id найден возвращаем его,  если нет то кидаем инфо об ошибке
//        return productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found, id: " + id));
//    }


    @PostMapping()
    public ProductDto saveNewProduct(@RequestBody ProductDto productDto) {
        // создаем новый продукт и передаем ему параметры нового созданного dto
        productService.save(new Product(productDto.getId(), productDto.getName(), productDto.getCost()));
        // возвращаем dto
        return productDto;
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id) {
        //есл продукт по id найден возвращаем его,  если нет то кидаем инфо об ошибке пакуем в dto
        return new ProductDto(productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found, id: " + id)));
    }
//
    @DeleteMapping ("/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @PutMapping()
    public ProductDto updateProducts (@RequestParam ProductDto productDto) {
        // дастаем продукт вносим изменения которые были внесены к dto
        Product product = productService.findById(productDto.getId()).get();
        product.setName(productDto.getName());
        product.setCost(product.getCost());
        // возвращаем
        return productDto;
    }



    }




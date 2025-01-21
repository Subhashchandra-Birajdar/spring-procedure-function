package com.sb.controller;

import com.sb.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sb.entity.Product;

@RestController
@RequestMapping("/api/products")

public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @PutMapping("/update/{productId}/{quantity}")
    public Product updateInventoryStock(
            @PathVariable Integer productId,
            @PathVariable Integer quantity){
        return productService.updateStockQuantity(productId,quantity);
            }

    @GetMapping("/total-price/{productId}")
    public Double calculateProductPrice(@PathVariable Integer productId){
        return productService.calculateProductPrice(productId);
    }
}

package com.sb.service;

import com.sb.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sb.entity.Product;
@Service
public class ProductService {

     @Autowired
private ProductRepository productRepository;

public Product updateStockQuantity(Integer productId, Integer quantity){
     productRepository.updateStock(productId,quantity);
     return productRepository.findById(productId).get();
}

     public Product addProduct(Product product) {
     return productRepository.save(product);
     }

     public Double calculateProductPrice(int id){
     return productRepository.getTotalPrice(id);
     }
}

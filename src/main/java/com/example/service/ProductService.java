package com.example.service;

import com.example.config.ConfigurationFile;
import com.example.object.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductService {
    
    @Autowired
    ConfigurationFile configurationFile;

    public ResponseEntity<Map<String, List<String>>> getProductCategory(){
        System.out.println(configurationFile.getProductCategory());
        Map<String, List<String>> productCategory = configurationFile.getProductCategory();
        return ResponseEntity.ok(productCategory);
    }

    public ResponseEntity<List<Product>> getProducts(String subCategory){
        List<Product>listOfProducts = configurationFile.getProductMap().get(subCategory);
        return ResponseEntity.of(Optional.of(listOfProducts));
    }

}
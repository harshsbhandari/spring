package com.example.service;

import com.example.config.ConfigurationFile;
import com.example.object.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    
    @Autowired
    ConfigurationFile configurationFile;

    public ResponseEntity<List<String>> getProductCategory(){
        List<String> productCategory = configurationFile.getProductCategory().keySet().stream().toList();
        return ResponseEntity.of(Optional.of(productCategory));
    }

    public ResponseEntity<List<String>> getProductSubCategory(String category){
        List<String> productSubCategory = configurationFile.getProductCategory().get(category);
        return ResponseEntity.of(Optional.of(productSubCategory));
    }

    public ResponseEntity<List<Product>> getProducts(String subCategory){
        List<Product>listOfProducts = configurationFile.getProductMap().get(subCategory);
        return ResponseEntity.of(Optional.of(listOfProducts));
    }

}
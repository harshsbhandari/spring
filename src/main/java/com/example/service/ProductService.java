package com.example.service;

import com.example.config.ProductConfigurationFile;
import com.example.object.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductService {
    
    @Autowired
    ProductConfigurationFile productConfigurationFile;

    public ResponseEntity<List<String>> getProductCategory(){
        var productCategory = productConfigurationFile.getProductCategory().keySet().stream().toList();
        return ResponseEntity.of(Optional.of(productCategory));
    }

    public ResponseEntity<List<String>> getProductSubCategory(String category){
       var productSubCategory = productConfigurationFile.getProductCategory().get(category);
       return ResponseEntity.of(Optional.of(productSubCategory));
    }

    public ResponseEntity<List<Product>> getProducts(String subCategory){
        var listOfProducts = productConfigurationFile.getProductMap().get(subCategory);
        return ResponseEntity.of(Optional.of(listOfProducts));
    }

    public ResponseEntity<Map<String, List<String>>> getProductCategoryMap(){
        var productCategoryMap = productConfigurationFile.getProductCategory();
        return ResponseEntity.of(Optional.of(productCategoryMap));
    }

    public ResponseEntity<Map<String, List<Product>>> getProductMap(){
        var productMap = productConfigurationFile.getProductMap();
        return ResponseEntity.of(Optional.of(productMap));
    }
}
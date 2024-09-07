package com.example.controller;

import com.example.object.Product;
import com.example.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @Operation(summary = "Category list", description = "Get category for all available products")
    @GetMapping("/getProductCategory")
    public ResponseEntity<List<String>> getProductCategory(){
        return productService.getProductCategory();
    }

    @Operation(summary = "Subcategory list", description = "Pass the product category and get different sub-category list")
    @PostMapping("/getProductSubCategory")
    public ResponseEntity<List<String>> getProductSubCategory(@RequestParam("category") String category){
        return productService.getProductSubCategory(category);
    }

    @Operation(summary = "Product list", description = "Pass the product subcategory and get product list")
    @PostMapping("/getProducts")
    public ResponseEntity<List<Product>> getProducts(@RequestParam("subCategory") String subCategory){
        return productService.getProducts(subCategory);
    }

}

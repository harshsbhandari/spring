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
import java.util.Map;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @Operation(summary = "Get category and subcategories for all available products", description = "Simple get operation")
    @GetMapping("/getProductCategory")
    public ResponseEntity<Map<String, List<String>>> getProductCategory(){
        return productService.getProductCategory();
    }

    @Operation(summary = "Get product name and price", description = "Pass product subcategory and get product list")
    @PostMapping("/getProducts")
    public ResponseEntity<List<Product>> getProducts(@RequestParam("subCategory") String subCategory){
        return productService.getProducts(subCategory);
    }

}

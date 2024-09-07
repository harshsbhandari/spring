package com.example.controller;

import com.example.object.Product;
import com.example.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DiscountController {
    @Autowired
    DiscountService discountService;

    @GetMapping("/getNEW_ARRIVALS")
    public ResponseEntity<List<Product>> getNEW_ARRIVALS(){
        return discountService.getNEW_ARRIVALS();
    }

}

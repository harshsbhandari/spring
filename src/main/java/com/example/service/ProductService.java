package com.example.service;

import com.example.config.ConfigurationFile;
import com.example.constants.DiscountType;
import com.example.object.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public ResponseEntity<List<Product>> getNewArrivals(){
        List<String>listOfDiscountedSubCategory = configurationFile.getDiscountMap().get(DiscountType.NEW_ARRIVALS);
        List<String>subCategoryList = configurationFile.getProductCategory().get(listOfDiscountedSubCategory.get(0));
        Map<String, List<Product>> productMap = configurationFile.getProductMap();
        List<Product> response = subCategoryList.stream()
//                Removing extra spaces
                .map(subCategory -> subCategory.replaceAll("\\s+", ""))
                .map(productMap::get)
                .filter(products -> products != null)
                .flatMap(List::stream)
                .peek(product -> {
                    if (!product.getName().contains("Nike") && !product.getName().contains("Adidas"))
                        applyDiscount(product, 15);
                })
                .collect(Collectors.toList());

        return ResponseEntity.of(Optional.of(response));
    }
    private void applyDiscount(Product product, Integer discountPercentage) {
        int originalPrice = product.getPrice();
        int discountedPrice = (int) (originalPrice - (originalPrice * discountPercentage / 100));
        product.setPrice(discountedPrice);
    }

}
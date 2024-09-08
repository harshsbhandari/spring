package com.example.service;

import com.example.config.DiscountConfigurationFile;
import com.example.constants.DiscountType;
import com.example.object.AvailableDiscount;
import com.example.object.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DiscountService {
    @Autowired
    DiscountConfigurationFile discountConfigurationFile;
    @Autowired
    ProductService productService;

    public ResponseEntity<List<Product>> getNEW_ARRIVALS() {
        var availableDiscountList = discountConfigurationFile.getAvailableDiscountList();
        AvailableDiscount availableDiscount = availableDiscountList.stream()
                .filter(discount -> discount.getDiscountType() == DiscountType.NEW_ARRIVALS)
                .findFirst().orElse(null);
        if(availableDiscount == null)
            return ResponseEntity.of(Optional.of(List.of()));
        var productCategory = productService.getProductCategoryMap().getBody();
        var productMap = productService.getProductMap().getBody();
        var subCategoryList = productCategory.keySet().stream().
                filter(i -> availableDiscount.getCategory().contains(i)).toList();

        List<Product> response = subCategoryList.stream()
                // Stream over subcategory list
                .flatMap(i -> productCategory.get(i).stream()
                        // Remove spaces from subcategory name
                        .map(j -> j.replace(" ", ""))
                        // Get product list
                        .flatMap(subCat -> productMap.getOrDefault(subCat, List.of()).stream())
                        // Filter products not in no-discount brands
                        .filter(k -> availableDiscount.getNoDiscountBrands().stream().noneMatch(brand -> k.getName().contains(brand)))
                        // Apply discount to the filtered products
                        .map(k -> {
                            k.setPrice(discountedValue(k.getPrice(), availableDiscount.getDiscountPercentage()));
                            return k;
                        })
                ).collect(Collectors.toList());

        return ResponseEntity.of(Optional.of(response));
    }
    private Integer discountedValue(Integer price, Integer discountPercent){
        Integer discountValue = (price * discountPercent) / 100;
        return price - discountValue;
    }

}

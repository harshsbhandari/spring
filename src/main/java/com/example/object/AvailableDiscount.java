package com.example.object;

import com.example.constants.DiscountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AvailableDiscount {
    DiscountType discountType;
    List<String> category;
    Integer discountPercentage;
    List<String>noDiscountBrands;
}

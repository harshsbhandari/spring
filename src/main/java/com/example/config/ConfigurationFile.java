package com.example.config;

import com.example.constants.DiscountType;
import com.example.object.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "app")
@Setter
@Getter
public class ConfigurationFile {
//    private Map<String, String> userMap;

    private String key;

    private Map<String, List<String>> productCategory;

    private Map<String, List<Product>> productMap;

    private Map<DiscountType, Integer> discountMap;

}

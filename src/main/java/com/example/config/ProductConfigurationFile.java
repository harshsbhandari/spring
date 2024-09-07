package com.example.config;

import com.example.object.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Setter
@Getter
@ConfigurationProperties(prefix = "app")
@PropertySource(value = "classpath:product.yml", factory = YamlPropertySourceFactory.class)
public class ProductConfigurationFile {
    private Map<String, List<String>> productCategory;
    private Map<String, List<Product>> productMap;
}

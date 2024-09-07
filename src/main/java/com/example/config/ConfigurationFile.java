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
@Setter
@Getter
@ConfigurationProperties(prefix = "app")
public class ConfigurationFile {
//    private Map<String, String> userMap;

    private String key;

}

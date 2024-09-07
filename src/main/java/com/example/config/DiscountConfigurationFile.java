package com.example.config;

import com.example.constants.DiscountType;
import com.example.object.AvailableDiscount;
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
@PropertySource(value = "classpath:discount.yml", factory = YamlPropertySourceFactory.class)
public class DiscountConfigurationFile {
    private List<AvailableDiscount>availableDiscountList;
}

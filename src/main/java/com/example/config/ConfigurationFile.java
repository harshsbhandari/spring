package com.example.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
@ConfigurationProperties(prefix = "app")
public class ConfigurationFile {
//    private Map<String, String> userMap;

    private String key;

}

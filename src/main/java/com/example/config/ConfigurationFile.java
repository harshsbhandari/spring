package com.example.config;

import com.example.object.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.jasypt.util.text.AES256TextEncryptor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "app")
@Setter
@Getter
public class ConfigurationFile {
//    @Value("#{${userMap}}")
//    private Map<String, String> userMap;

//    @Value("${key}")
    private String key;

//    @Value("#{${productCategory}}")
    private Map<String, List<String>> productCategory;

//    @Value("#{${productMap}}")
    private Map<String, List<Product>> productMap;

    /*
    * Not working
    * */
//    @Bean
//    public AES256TextEncryptor textEncryptor() {
//        AES256TextEncryptor textEncryptor = new AES256TextEncryptor();
//        textEncryptor.setPassword(this.key);
//        return textEncryptor;
//    }

//    public Map<String, String> getUserMap() {
//        return userMap;
//    }
//
//    public Map<String, List<String>> getProductCategory(){
//        return this.productCategory;
//    }
//
//    public Map<String, List<Product>> getProductMap(){ return this.productMap; }
}

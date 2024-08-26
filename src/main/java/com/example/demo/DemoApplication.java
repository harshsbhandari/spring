package com.example.demo;

import com.example.config.ConfigurationFile;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(scanBasePackages = "com.example")
@EnableConfigurationProperties(ConfigurationFile.class)
public class DemoApplication {
//	http://localhost:8080/swagger-ui/index.html

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

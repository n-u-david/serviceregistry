package com.example.serviceregistry.config;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix="spring.destination")
@Configuration
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Configurations {
    private String service001;
    private String service002;
    private String cam;
}

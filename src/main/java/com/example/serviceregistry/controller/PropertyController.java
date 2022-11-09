package com.example.serviceregistry.controller;


import com.example.serviceregistry.config.Configurations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PropertyController {
    @Value("${spring.application.name}")
    String applicationName;


    @Autowired
    private Environment env;

    @Autowired
    private Configurations config;

    @GetMapping("/destination")
    public Map<String, String> getAppNameVal() {
        Map<String,String> values= new HashMap();
        values.put("using @Value--",applicationName);
        values.put("using Environment--",env.getProperty("spring.application.name"));
        values.put("service1",config.getService001());
        values.put("service2",config.getService002());
        values.put("service3",config.getService003());

        return values;
    }


}

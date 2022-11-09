package com.example.serviceregistry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertyController {

    @Autowired
    private Environment env;


    @GetMapping("/destination/{key}")
    public ResponseEntity<String> getDestination (@PathVariable ("key") String key) {
        if(env.getProperty("spring.datasource."+key)!=null){
            return new ResponseEntity<>((env.getProperty("spring.datasource."+key)), HttpStatus.OK);
        }
            return new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
    }

}

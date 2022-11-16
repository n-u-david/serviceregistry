package com.example.serviceregistry.controller;

import com.example.serviceregistry.model.Destination;
import com.example.serviceregistry.service.Registry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PropertyController {

    @Autowired
    private Environment env;

    @Autowired
    private Registry registry;


    @GetMapping("/destination/{key}")
    public ResponseEntity<String> getDestination (@PathVariable ("key") String key) {
        if(registry.getSize()>0){
            return new ResponseEntity<>((registry.getDestination(key)), HttpStatus.OK);
        }
            return new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
    }

    @PostMapping("/destination")
    public Destination newDestination (@RequestBody Destination destination){
        registry.setDestination(destination.getKey(), destination.getDestination());
        return destination;
    }

}

package com.example.serviceregistry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class Registry {

 //   @Autowired
    Environment env;
    HashMap<String,String> serviceMap;

    public Registry(){
        if(serviceMap==null){
            serviceMap = new HashMap<>();
 //           serviceMap.put("cam",env.getProperty("spring.destination.cam"));
 //           serviceMap.put("service001",env.getProperty("spring.destination.service001"));
 //           serviceMap.put("service002",env.getProperty("spring.destination.service002"));
        }
    }

    public String getDestination(String key){
        if(serviceMap.containsKey(key)){
            return serviceMap.get(key);
        }
        return null;
    }

    public void setDestination(String key, String value){
        if(key!=null && value !=null){
            serviceMap.put(key,value);
        }
    }

    public int getSize(){
        return serviceMap.size();
    }

}

package com.trosko_project.testingCenter.controller;

import com.trosko_project.testingCenter.model.Type;
import com.trosko_project.testingCenter.repository.TypeRepository;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
public class MainController {
    @Autowired
    TypeRepository typeRepository;

    @GetMapping("/api/hello")
    public String start() {
        List<String> list = new ArrayList<>();
//        list.add("first");
//        list.add("second");
//        JSONArray ja = new JSONArray();
//        ja.put(list);
//        JSONObject employeeDetails = new JSONObject();
//        employeeDetails.put("firstName", "Lokesh");
//        employeeDetails.put("lastName", "Gupta");
//        employeeDetails.put("website", "howtodoinjava.com");
//
//        JSONObject employeeObject = new JSONObject();
//        employeeObject.put("employee", employeeDetails);
//        System.out.println(employeeObject);
//        System.out.println(list.toString());
        List<Type> types = typeRepository.findAll();
        for(int i =0; i< types.size(); i++){
            System.out.println(types.get(i).getName());
        }
        JSONArray ja = new JSONArray();
        ja.put(types);
        return ja.toString();
    }
}

package com.trosko_project.testingCenter.controller;

import com.trosko_project.testingCenter.model.User;
import com.trosko_project.testingCenter.repository.UserRepository;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/api/users")
    public String getUsersHandler() {
        List<User> users = userRepository.findAll();
        for(int i =0; i< users.size(); i++){
            System.out.println(users.get(i).getFirstName());
        }
        JSONArray ja = new JSONArray();
        ja.put(users);
        return ja.toString();
    }
}

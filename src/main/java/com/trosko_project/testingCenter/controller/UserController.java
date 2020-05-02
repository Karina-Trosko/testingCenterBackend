package com.trosko_project.testingCenter.controller;

import com.trosko_project.testingCenter.model.User;
import com.trosko_project.testingCenter.payload.UserSignInRequest;
import com.trosko_project.testingCenter.payload.UserSignUpRequest;
import com.trosko_project.testingCenter.repository.UserRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/api/users/{id}")
    public String getUserHandler(@PathVariable int id) {
        User user = userRepository.findById(id).get();
        JSONObject ja = new JSONObject(user);
        return ja.toString();
    }

    @PostMapping(path ="/api/users/signUp", consumes = "application/json", produces = "application/json")
    public String signUp(@RequestBody UserSignUpRequest req) {
        if (userRepository.findByLogin(req.getLogin()).size() != 0) {
            return "This login already exists!";
        } else {
            User user = new User(req.getFirstName(), req.getSurname(), req.getPatronymic(), req.getLogin(), req.getPassword(), req.getContactInformation());
            user.setRole("user");
            userRepository.save(user);
            User newUser = userRepository.findByLogin(req.getLogin()).get(0);
            JSONObject ja = new JSONObject(newUser);
            return ja.toString();
        }
    }

    @PostMapping(path ="/api/users/signIn", consumes = "application/json", produces = "application/json")
    public String signIn(@RequestBody UserSignInRequest req) {
        List<User> authUsers = userRepository.findByLogin(req.getLogin());
        System.out.println(req.getPassword());
        System.out.println(authUsers.get(0).getPassword());

        if(authUsers.size()!= 0 && authUsers.get(0).getPassword().equals(req.getPassword()))
        {
            JSONObject ja = new JSONObject(authUsers.get(0));
            return ja.toString();
        }
        else {
            return "Wrong password!";
        }
    }

    @PostMapping("/api/user/delete/{id}")
    public String delete(@PathVariable int id) {
        userRepository.deleteById(id);
        System.out.println(id);
        return "success";
        //return "redirect:/books";
    }
}

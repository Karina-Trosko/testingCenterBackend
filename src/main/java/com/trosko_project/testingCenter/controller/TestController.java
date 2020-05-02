package com.trosko_project.testingCenter.controller;

import com.trosko_project.testingCenter.model.Category;
import com.trosko_project.testingCenter.model.Record;
import com.trosko_project.testingCenter.model.Test;
import com.trosko_project.testingCenter.model.Type;
import com.trosko_project.testingCenter.payload.TestRequest;
import com.trosko_project.testingCenter.repository.CategoryRepository;
import com.trosko_project.testingCenter.repository.RecordRepository;
import com.trosko_project.testingCenter.repository.TestRepository;
import com.trosko_project.testingCenter.repository.TypeRepository;
import com.trosko_project.testingCenter.utils.JsonFileUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {
    @Autowired
    TypeRepository typeRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    TestRepository testRepository;

    @Autowired
    RecordRepository recordRepository;


    @GetMapping("/api/categories")
    public String getCategoriesHandler() {
        List<Category> categories = categoryRepository.findAll();
        for(int i =0; i< categories.size(); i++){
            System.out.println(categories.get(i).getName());
        }
        JSONArray ja = new JSONArray();
        ja.put(categories);
        return ja.toString();
    }
    @GetMapping("/api/types")
    public String getTypesHandler() {
        List<Type> types = typeRepository.findAll();
        for(int i =0; i< types.size(); i++){
            System.out.println(types.get(i).getName());
        }
        JSONArray ja = new JSONArray();
        ja.put(types);
        return ja.toString();
    }
    @GetMapping("/api/tests")
    public String getTestsHandler() {
        List<Test> tests = testRepository.findAll();
        for(int i =0; i< tests.size(); i++){
            System.out.println(tests.get(i).getName());
        }
        JSONArray ja = new JSONArray();
        ja.put(tests);
        return ja.toString();
    }

    @GetMapping("/api/tests/content")
    public String getContentOfTestsHandler() {
        try {
            String str = (new JsonFileUtils()).ReadAll();
            return str;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return "Error";
        }
    }

    @PostMapping(path ="/api/test/add", consumes = "application/json", produces = "application/json")
    public String addTest(@RequestBody TestRequest req) {
        Test test = new Test(req.getName(),req.getNumberOfQuestions(),req.getDescription(),req.getContentsLink(),req.getDuration());
        test.setCategory(categoryRepository.findById(req.getCategoryId()).get());
        test.setType(typeRepository.findById(req.getTypeId()).get());
        System.out.println(test.getCategory().getName());
        try {
            JsonFileUtils jsu = new JsonFileUtils();
            if(jsu.AddInFile(req.getContent()) ){
            System.out.println(jsu.ReadAll());
            }
            testRepository.save(test);
            return "Success";
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return "Error";
        }
    }

    @PostMapping(path ="/api/test/update", consumes = "application/json", produces = "application/json")
    public String authorSave(@RequestBody TestRequest req) {
        //Test test = testRepository.findById(req.getId()).get();
        //test.setDescription(req.getDescription());
        // testRepository.save(test);
        System.out.println(req.getDescription());
        try {
            JsonFileUtils jsu = new JsonFileUtils();
            //String str = jsu.ReadAll();
            //System.out.println(str);
            //System.out.println(ja.get(0).toString());
            //if(jsu.AddInFile(req.getDescription()) ){
                System.out.println(jsu.ReadAll());
            //}
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "success";
    }

    @PostMapping("/api/test/delete/{id}")
    public String delete(@PathVariable int id) {
        testRepository.deleteById(id);
        System.out.println(id);
        return "success";
        //return "redirect:/books";
    }

    @GetMapping("/api/records")
    public String getRecordsHandler() {
        List<Record> records = recordRepository.findAll();
        for(int i =0; i< records.size(); i++){
            System.out.println(records.get(i).getId());
        }
        JSONArray ja = new JSONArray();
        ja.put(records);
        return ja.toString();
    }

}

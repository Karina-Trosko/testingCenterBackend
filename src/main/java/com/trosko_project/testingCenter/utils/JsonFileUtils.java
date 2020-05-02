package com.trosko_project.testingCenter.utils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonFileUtils {
    public String ReadAll () throws IOException, URISyntaxException {

        String str = new String(Files.readAllBytes(Paths.get(getClass()
                .getClassLoader()
                .getResource("data/data.json")
                .toURI())));
        return str;
    }
    public Boolean AddInFile (String str) throws IOException, URISyntaxException {
        JSONArray data = new JSONArray(this.ReadAll());
        JSONObject newObj = new JSONObject(str);
        data.put(newObj);
        Boolean isOk =false;
        try {
            Files.write(Paths.get(getClass()
                    .getClassLoader()
                    .getResource("data/data.json")
                    .toURI()), (data.toString()).getBytes());
            isOk=true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isOk;
    }

    public Boolean OverwriteFile (String str) throws IOException, URISyntaxException {
        Boolean isOk=false;
        try {
            Files.write(Paths.get(getClass()
                    .getClassLoader()
                    .getResource("data/data.json")
                    .toURI()), (str).getBytes());
            isOk=true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isOk;
    }
}

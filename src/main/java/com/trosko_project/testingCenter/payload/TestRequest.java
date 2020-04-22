package com.trosko_project.testingCenter.payload;

import javax.validation.constraints.NotBlank;

public class TestRequest {
    @NotBlank
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

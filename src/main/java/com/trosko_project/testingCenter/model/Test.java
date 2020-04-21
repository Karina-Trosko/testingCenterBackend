package com.trosko_project.testingCenter.model;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
@Entity
@Table(name="tests")
public class Test {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="number_of_questions")
    private int numberOfQuestions;
    @Column(name="description")
    private String description;
    @Column(name="contents_link")
    private String contentsLink;
    @Column(name="duration")
    private int duration;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContentsLink() {
        return contentsLink;
    }

    public void setContentsLink(String contentsLink) {
        this.contentsLink = contentsLink;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}

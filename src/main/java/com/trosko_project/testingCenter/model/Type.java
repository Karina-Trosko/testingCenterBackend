package com.trosko_project.testingCenter.model;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
@Entity
@Table(name="types")
public class Type {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name="name")
    private String name;

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
}

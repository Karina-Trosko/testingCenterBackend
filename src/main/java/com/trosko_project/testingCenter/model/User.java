package com.trosko_project.testingCenter.model;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="users")
public class User {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="surname")
    private int surname;
    @Column(name="patronymic")
    private String patronymic;
    @Column(name="login")
    private String login;
    @Column(name="password")
    private int password;
    @Column(name="contact_information")
    private int contactInformation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getSurname() {
        return surname;
    }

    public void setSurname(int surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(int contactInformation) {
        this.contactInformation = contactInformation;
    }
}

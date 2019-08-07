package ru.vlad.mystudy.thymeleaf.model;

public class Person {

    public Long id;
    public String name;
    public String email;

    public Person(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}

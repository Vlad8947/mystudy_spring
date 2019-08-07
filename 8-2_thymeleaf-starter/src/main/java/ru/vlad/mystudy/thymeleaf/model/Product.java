package ru.vlad.mystudy.thymeleaf.model;

public class Product {

    public Long id;
    public String code;
    public String name;
    public String image;

    public Product(Long id, String code, String name, String image) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.image = image;
    }

}

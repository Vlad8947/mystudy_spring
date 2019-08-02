package ru.vlad.mystudy.thymeleaf.model;

import javax.validation.constraints.Size;

public class Item {

    @Size(min = 3, max = 20)
    private String header;
    private String text;

    public Item() {
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getText() {
        return text;
    }

    public void setText(String name) {
        this.text = name;
    }
}

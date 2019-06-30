package spring_mvc.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


public class HumanModel {

    private String name;
    private String age;

    public HumanModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}

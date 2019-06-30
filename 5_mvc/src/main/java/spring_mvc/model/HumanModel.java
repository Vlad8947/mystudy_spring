package spring_mvc.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HumanModel {

    private String name;
    private String age;

    public HumanModel() {
    }
}

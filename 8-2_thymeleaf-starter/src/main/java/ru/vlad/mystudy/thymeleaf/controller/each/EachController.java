package ru.vlad.mystudy.thymeleaf.controller.each;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.vlad.mystudy.thymeleaf.model.Person;

import java.util.HashMap;
import java.util.Map;

@Controller
public class EachController {

    public EachController() {
    }

    @RequestMapping(path = "/each")
    public String each(Model model) {
        String[] flowers = new String[] {"Rose","Lily", "Tulip", "Carnation", "Hyacinth" };
        model.addAttribute("flowers", flowers);
        return "each/each";
    }

    @RequestMapping(path = "/each-classappend")
    public String eachClassAppend(Model model) {
        Person tom = new Person(1L, "Tom", "tom@waltdisney.com");
        Person jerry = new Person(2L, "Jerry", "jerry@waltdisney.com");
        Person donald = new Person(3L, "Donald", "donald@waltdisney.com");

        // String: Phone Number.
        Map<String, Person> contacts = new HashMap<String, Person>();

        contacts.put("110033", tom);
        contacts.put("110055", jerry);
        contacts.put("110077", donald);

        model.addAttribute("contacts", contacts);
        return "each/each-class-append";
    }
}

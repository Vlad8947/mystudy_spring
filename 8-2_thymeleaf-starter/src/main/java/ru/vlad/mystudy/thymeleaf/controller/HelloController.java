package ru.vlad.mystudy.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.vlad.mystudy.thymeleaf.model.Item;
import ru.vlad.mystudy.thymeleaf.model.User;

import java.util.List;

@Controller
@RequestMapping("/hello")
public class HelloController {

    private List<Item> list;

    public HelloController() {
    }

    @ModelAttribute("items")
    public List<Item> getList() {
        return list;
    }

    @GetMapping
    public String hello(Model model) {
        User user = new User();
        user.setName("Vladik");
        model.addAttribute("user", user);

        model.addAttribute("item", new Item());

        return "hello";
    }

    @PostMapping("/form")
    public String form(Model model) {
        return "hello";
    }

}

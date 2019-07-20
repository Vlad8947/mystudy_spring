package ru.vlad.mystudy.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.vlad.mystudy.thymeleaf.model.User;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String hello(Model model) {
        User user = new User();
        user.name = "Vladik";
        model.addAttribute("user", user);
        return "hello";
    }

}

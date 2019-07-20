package ru.vlad.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.vlad.thymeleaf.model.User;

@Controller
@RequestMapping("/hello")
public class HelloController {

    public HelloController() {
    }

    @GetMapping
    public String hello(Model model) {
        User user = new User();
        user.setName("Vladik");
        model.addAttribute("user", user);
        return "hello";
    }

}

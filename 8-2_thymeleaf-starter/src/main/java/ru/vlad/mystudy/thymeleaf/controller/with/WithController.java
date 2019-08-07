package ru.vlad.mystudy.thymeleaf.controller.with;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WithController {

    public WithController() {
    }

    @RequestMapping(path = "/with")
    public String withExample(Model model) {
        String[] flowers = new String[] {"Rose","Lily", "Tulip", "Carnation", "Hyacinth" };
        model.addAttribute("flowers", flowers);
        return "with/withExample";
    }
}

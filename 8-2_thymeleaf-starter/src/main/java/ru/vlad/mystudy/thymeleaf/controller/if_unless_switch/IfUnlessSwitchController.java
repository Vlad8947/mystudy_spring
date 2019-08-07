package ru.vlad.mystudy.thymeleaf.controller.if_unless_switch;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.vlad.mystudy.thymeleaf.model.Product;
import ru.vlad.mystudy.thymeleaf.model.User;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IfUnlessSwitchController {

    public IfUnlessSwitchController() {
    }

    @RequestMapping(path = "/if-unless")
    public String ifExample(Model model) {
        Product prod1 = new Product(1L, "SS-S9", "Sam Sung Galaxy S9", "samsung-s9.png");
        Product prod2 = new Product(2L, "NK-5P", "Nokia 5.1 Plus", null);
        Product prod3 = new Product(3L, "IP-7", "iPhone 7", "iphone-7.jpg");

        List<Product> list = new ArrayList<Product>();
        list.add(prod1);
        list.add(prod2);
        list.add(prod3);
        model.addAttribute("products", list);

        return "if_unless_switch/if-unless";
    }

    @RequestMapping(path = "/switch")
    public String switchExample(Model model) {
        User user = new User();
        user.setName("Admin");
        user.role = "admin";
        model.addAttribute("user", user);

        return "if_unless_switch/switch";
    }
}

package spring_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class HomeController {

    public HomeController() {
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(Model model) {
        model.addAttribute("message","Hello! Веб-уровень работает! =)");
        return "hello";
    }

    @GetMapping("/hello-name1/{name}") // ../hello/vlad
    public String hello1(Model model,
                        @PathVariable("name") String name) {
        model.addAttribute("message", "Hello " + name);
        return "hello";
    }

    @GetMapping("/hello-name2") // ../hello?name=vlad
    public String hello2(Model model,
                        @RequestParam(name = "name", required = false, defaultValue = "someone") String name) {
        model.addAttribute("message", "Hello " + name);
        return "hello";
    }

}

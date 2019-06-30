package spring_mvc.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring_mvc.model.HumanModel;

//todo form dosn't work

@Controller
//@RequestMapping("/form")
public class FormController {

    public FormController() {
    }

//    @GetMapping(params = "form")
//    public String getForm(Model model) {
//        HumanModel human = new HumanModel();
//        model.addAttribute("human", human);
//        return "form";
//    }

//    @PostMapping(params = "form")
//    public String form(BindingResult bindingResult, HumanModel human) {
//        if (!bindingResult.hasErrors()) {
//            System.out.println("name" + human.toString());
//        }
//        return "hello";
//    }
}

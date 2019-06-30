package spring_mvc.controller;

import com.sun.tracing.dtrace.ModuleAttributes;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring_mvc.model.HumanModel;

@Controller
@RequestMapping("/form")
public class FormController {

    public FormController() {
    }

    @GetMapping
    public String getForm(Model model) {
        HumanModel human = new HumanModel();
        model.addAttribute("human", human);
        return "form";
    }

    @PostMapping
    public String form(@ModelAttribute("human") HumanModel human,
                       BindingResult bindingResult,
                       Model model) {
        if (!bindingResult.hasErrors()) {
            model.addAttribute("name", human.toString());
        }
        return "redirect:/hello-name2";
    }
}

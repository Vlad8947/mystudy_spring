package code.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.SecurityContextProvider;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sun.plugin.liveconnect.SecurityContextHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Controller
public class LoginController {

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String loginPage(){
// Возвращает путь страницы для авторизации
        return "security/login";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
// Получает данные авторизации из контекста
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
// Если пользователь авторизован, то производится его выход из аккаунта автора
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
// и редирект на главную страницу
        return "redirect:/";
    }

    @RequestMapping(value="/loginfailed")
    public String loginFailed(RedirectAttributes redirectAttributes, Locale locale ){
// Если пользователь ввел неверные данные для авторизации,
// то происходит его редирект на форму входа с выводом информации об ошибке
        redirectAttributes.addFlashAttribute("message", messageSource.getMessage("login_failed", new Object[]{}, locale));
        return "redirect:/login";
    }
}


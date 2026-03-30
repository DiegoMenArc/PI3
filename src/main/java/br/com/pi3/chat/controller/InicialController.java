package br.com.pi3.chat.controller;

import br.com.pi3.chat.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class InicialController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("GlobalChat", "ChatComunidade");
        return "home";  // templates/home.html
    }

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }
}

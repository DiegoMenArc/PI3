package br.com.pi3.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String exibirLogin(){
        return "Login";
    }

    @PostMapping("/login")
    public String fazerLogin(String email, String senha){

        // Aqui futuramente será feita a validação no banco (H2/MySQL)
        System.out.println("Login: " + email);

        return "redirect:/home";
    }
}

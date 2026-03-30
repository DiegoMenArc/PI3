package br.com.pi3.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeAddAmigosController {

    @GetMapping("/addAmigos")
    public String HomeAddAmigos() {
        return "HomeAddAmigos"; // Retorna o nome do template
    }
}

package br.com.pi3.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String Home() {
        return "home/home"; // Retorna o nome do template
    }

    @GetMapping("/todos")
    public String Todos(){
        return "home/todosAmigos";
    }
}

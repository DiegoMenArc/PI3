package br.com.pi3.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodosAmigos {


    @GetMapping("/todos")
    public String Todos(){
        return "todosAmigos";
    }
}

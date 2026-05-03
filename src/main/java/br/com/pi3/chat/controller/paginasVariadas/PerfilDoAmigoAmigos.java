package br.com.pi3.chat.controller.paginasVariadas;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PerfilDoAmigoAmigos {

    @GetMapping("/Perfil-AC")
    String PerfilDoAmigoAmigos(){
        return "PerfilDoAmigoAmigos";
    }
}
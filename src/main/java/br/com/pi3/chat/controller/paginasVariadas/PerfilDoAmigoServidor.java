package br.com.pi3.chat.controller.paginasVariadas;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
    public class PerfilDoAmigoServidor{
    @GetMapping("/Perfil-AS")
    String PerfilDoAmigoServidor(){
        return "PerfilDoAmigoServidor";
    }
}
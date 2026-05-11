package br.com.pi3.chat.controller.paginasVariadas;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EditarPerfilCardController {

    @GetMapping("/EditarPerfilCard")
    public String EditarPerfilCard(){
        return "pages/perfil/EditarPerfilCard";
    }
}

package br.com.pi3.chat.controller.paginasInit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CadastroController {

    @GetMapping("/cadastro")
    public String exibirForm(){
        return "Cadastro";
    }

    @PostMapping("/registrar")
    public String processarCadastro(String email, String senha, String username) {

        // Aqui futuramente será feita a persistência no banco (JPA)
        System.out.println("Usuário registrado: " + username);
        return "redirect:/login";
    }
}

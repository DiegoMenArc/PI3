package br.com.pi3.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CadasrtoController {

    @GetMapping("/cadastro")
    public String exibirForm(){
        return "cadastro";
    }

    @PostMapping("/registrar")
    public String processarCadastro(String email, String senha, String username) {
        // Lógica para salvar o usuário no banco de dados aqui
        System.out.println("Usuário registrado: " + username);
        return "redirect:/login"; // Redireciona após o sucesso
    }
}

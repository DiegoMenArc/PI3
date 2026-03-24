package br.com.pi3.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Servidor")
public class ServidorController {

    @GetMapping("/produto/{id}")
    public String detalhesDoProduto(@PathVariable Long id) {
        // Lógica para buscar informações do produto com o ID fornecido
        .findById(id);

        // Passa os dados do produto para a visualização


        return "detalhesProduto";
    }

}

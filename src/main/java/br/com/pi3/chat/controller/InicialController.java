package br.com.pi3.chat.controller;

import br.com.pi3.chat.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class InicialController {

    @GetMapping("/")
    public String inicial() {
        return "Inicial"; // nome EXATO do arquivo
    }


}

package br.com.pi3.chat.controller.paginasInit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class InicialController {

    @GetMapping("/")
    public String inicial() {
        return "Inicial"; // nome EXATO do arquivo
    }


}

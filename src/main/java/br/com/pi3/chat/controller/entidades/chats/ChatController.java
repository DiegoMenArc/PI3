package br.com.pi3.chat.controller.entidades.chats;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ChatController {

    //O chat é a superclasse que dita o que vai ser servior/chat/comunidade, então é necessário somente o controller dele

    // Note as aspas com o nome da variável DENTRO dos parênteses do PathVariable
    @GetMapping("/me/chat/{amigoNome}")
    public String Chat(@PathVariable("amigoNome") String amigoNome, Model model){

        // Passa a variável para a tela (o HTML que você me mandou já está preparado para recebê-la)
        model.addAttribute("nomeAmigo", amigoNome);

        return "pages/amigo/chat";
    }
}

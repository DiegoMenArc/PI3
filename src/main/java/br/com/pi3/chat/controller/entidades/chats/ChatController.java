package br.com.pi3.chat.controller.entidades.chats;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

    //O chat é a superclasse que dita o que vai ser servior/chat/comunidade, então é necessário somente o controller dele

    @GetMapping("/chat/{}")
    public String Chat(){
        return "chat";
    }


}

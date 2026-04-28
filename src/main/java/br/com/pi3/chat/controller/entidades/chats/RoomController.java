package br.com.pi3.chat.controller.entidades.chats;

import br.com.pi3.chat.model.Mensagem;
import br.com.pi3.chat.model.rooms.Room;
import br.com.pi3.chat.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class RoomController {

    @Autowired
    private RoomService chatService;

    // Buscar chat
    @GetMapping("/{id}")  // ou @GetMapping("/chat/{id}")
    public String procurarChat(@PathVariable Long id, Model model) {
        Room chat = chatService.buscarRoom(id);
        model.addAttribute("chat", chat);
        return "chat";
    }

    // Criar chat
    @PostMapping("/chat")
    public String criarChat() {
        Room chat = null;
        chat = chatService.criarRoom(chat);
        return "redirect:/chat/" + chat.getId();
    }

    // Enviar mensagem
    @PostMapping("/mensagem/{chatId}")
    public String enviarMensagem(
            @PathVariable Long chatId,
            @RequestParam String conteudo) {

        chatService.enviarMensagem(chatId, conteudo);
        return "redirect:/chat/" + chatId;
    }

    //  Editar mensagem


    // Buscar usuário
    @GetMapping("/user/{id}")
    public String procurarUser(@PathVariable Long id, Model model) {
        model.addAttribute("user", chatService.buscarUser(id));
        return "user";
    }
}
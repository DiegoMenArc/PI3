package br.com.pi3.chat.service;

import br.com.pi3.chat.model.Mensagem;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    public ChatService getAccessibleRoom(Long id, Long userId) {
        ChatService room = repo.findById(id).orElseThrow();
        if (!room.hasMember(userId)) throw new AccessDenied();
        // UI adapta via room.getType() ou instanceof
        return room;
    }

    public Mensagem sendToRoom(Long id, Mensagem msg) {
        ChatService room = repo.findById(id).orElseThrow();
        // room.addMessage(msg); polimórfico
        return msgRepo.save(msg);
    }
}

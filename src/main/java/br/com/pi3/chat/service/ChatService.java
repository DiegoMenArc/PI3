package br.com.pi3.chat.service;

import br.com.pi3.chat.model.Mensagem;
import br.com.pi3.chat.model.rooms.Chat;
import br.com.pi3.chat.repository.JpaRepositoryChat;
import br.com.pi3.chat.repository.JpaRepositoryMensagem;
import br.com.pi3.chat.repository.JpaRepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ChatService {

    private JpaRepositoryMensagem msgRepo;
    private final JpaRepositoryChat chatRepo;

    public ChatService(JpaRepositoryChat chatRepo) {
        this.chatRepo = chatRepo;
    }

    public List<Mensagem> getMessages(Long chatId) {
        return msgRepo.findByChatIdOrderByCreatedAtDesc(chatId);
    }
    //Pega todas as mensagens criadas no chat

    //Page é uma interface que divie o conteudo em paginas, invés de guardar tudo num bloco gigante de informação
    //Ajuda na otimização da aplicação
    public Page<Mensagem> getMessagesPaged(Long chatId, int page, int size) {
        return msgRepo.findByChatIdOrderByCreatedAtDesc(chatId,
                PageRequest.of(page, size, Sort.by("createdAt").descending()));
        //PageRequest é um método que pede a Paginna inicial, final e organiza os elementos(de cima pra baixo nesse caso),
    }

    public Chat criaChat(Chat chat){
        if(chatRepo.existsById(chat.))
    }

}
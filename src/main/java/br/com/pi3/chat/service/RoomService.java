package br.com.pi3.chat.service;

import br.com.pi3.chat.DTO.mensagem.MensagemResponseDTO;
import br.com.pi3.chat.model.Mensagem;
import br.com.pi3.chat.model.User;
import br.com.pi3.chat.model.rooms.Room;
import br.com.pi3.chat.repository.JpaRepositoryMensagem;
import br.com.pi3.chat.repository.JpaRepositoryRoom;
import br.com.pi3.chat.repository.JpaRepositoryUser;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class RoomService {

    private final JpaRepositoryMensagem msgRepo;
    private final JpaRepositoryUser userRepo;
    private final JpaRepositoryRoom repo;

    public RoomService(
            JpaRepositoryMensagem msgRepo,
            JpaRepositoryUser userRepo,
            JpaRepositoryRoom repo) {
        this.msgRepo = msgRepo;
        this.userRepo = userRepo;
        this.repo = repo;
    }

    public MensagemResponseDTO enviarMensagem(Long chatId, String conteudo) {
        Room chat = repo.findById(chatId)
                .orElseThrow(() -> new RuntimeException("Chat não encontrado"));

        User user = userRepo.findById(chat.getAdmin().getId())  // ou outro critério
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Mensagem msg = new Mensagem();
        msg.setConteudo(conteudo);
        msg.setAutor(user);
        msg.setChat(chat);

        msgRepo.save(msg);

        return new MensagemResponseDTO(msg);
    }

    public Optional<User> buscarUser(Long id) {
        return userRepo.findById(id);
    }

    public Room criarRoom(Room r) {
        return repo.save(r);
    }

    public Room buscarRoom(Long id) {
        // 👇 aqui você estava chamando buscarRoom dentro de buscarRoom → recursão infinita
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Chat não encontrado"));
    }
}
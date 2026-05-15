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

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class RoomService {

    private MensagemResponseDTO dto;
    private JpaRepositoryMensagem msgRepo;
    private JpaRepositoryUser userRepo;
    private JpaRepositoryRoom repo;

    public MensagemResponseDTO enviarMensagem(Long chat_id, String conteudo){
        Room chat = (Room) repo.findById(dto.getChat().getId()).orElseThrow();
        User user = (User) userRepo.findById(dto.getAutor().getId()).orElseThrow();

        Mensagem msg = new Mensagem();
        msg.setConteudo(dto.getConteudo());
        msg.setAutor(user);
        msg.setChat(chat);

        msgRepo.save(msg);

        return new MensagemResponseDTO(msg);
    }

    public Optional<User> buscarUser(Long id){
        return this.userRepo.findById(id);
    }

    public Room criarRoom(Room r){
        return this.repo.save(r);
    }

    public Room buscarRoom(Long id){
        return this.buscarRoom(id);
    }

    public List<Room> listarRoomsPorUsuario(Long userId) { return this.repo.findAllById(Collections.singleton(userId)); }

    public List<Room> listarTodasRooms() { return this.repo.findAll(); }
}

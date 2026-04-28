package br.com.pi3.chat.service;

import br.com.pi3.chat.dto.mensagem.MensagemResponseDTO;
import br.com.pi3.chat.dto.room.RoomRequestDTO;
import br.com.pi3.chat.dto.room.RoomResponseDTO;
import br.com.pi3.chat.model.Mensagem;
import br.com.pi3.chat.model.User;
import br.com.pi3.chat.model.rooms.Room;
import br.com.pi3.chat.repository.JpaRepositoryMensagem;
import br.com.pi3.chat.repository.JpaRepositoryRoom;
import br.com.pi3.chat.repository.JpaRepositoryUser;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


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

    public Mensagem buscarMensagem(Integer id){
        return this.msgRepo.findMessageById(id);
    }

    public Mensagem editarMensagem(Integer id, String c){
        return this.msgRepo.editMensagem(id, c);
    }

    public User buscarUser(Long id){
        return this.userRepo.userPorId(id);
    }

    public Room criarRoom(){
        return this.repo.saveRoom();
    }

    public Room buscarRoom(Long id){
        return this.buscarRoom(id);
    }

}

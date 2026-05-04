package br.com.pi3.chat.DTO.mensagem;

import br.com.pi3.chat.model.Mensagem;
import br.com.pi3.chat.model.User;
import br.com.pi3.chat.model.rooms.Room;

public class MensagemResponseDTO {

    private Integer id;
    private String conteudo;
    private User autor;
    private Room chat;

    public MensagemResponseDTO(Mensagem msg) {
        this.id = msg.getId();
        this.conteudo = msg.getConteudo();
        this.autor = msg.getAutor();
    }

    // getters


    public String getConteudo() {
        return conteudo;
    }

    public Integer getId() {
        return id;
    }

    public User getAutor() {
        return autor;
    }

    public Room getChat() {
        return chat;
    }
}

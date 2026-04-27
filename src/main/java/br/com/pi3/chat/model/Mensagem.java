package br.com.pi3.chat.model;

import br.com.pi3.chat.model.rooms.Room;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
public class Mensagem {
    @GeneratedValue @Id int id;
    String conteudo;

    @ManyToOne
    User autor;

    @ManyToOne
    Room chat;

    public Mensagem(String m) {
        this.conteudo = m;
    }

    public Mensagem() {

    }

    public Room getChat() {
        return chat;
    }

    public String getConteudo() {
        return conteudo;
    }

    public int getId() {
        return id;
    }

    public User getAutor() {
        return autor;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public void setAutor(User autor) {
        this.autor = autor;
    }

    public void setChat(Room chat) {
        this.chat = chat;
    }
}

package br.com.pi3.chat.model;

import br.com.pi3.chat.model.rooms.Canal;
import br.com.pi3.chat.model.rooms.Inbox;
import br.com.pi3.chat.model.rooms.MensagemDireta;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "canal_id")
    private Canal canal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mensagem_direta_id")
    private MensagemDireta mensagemDireta;

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

    public void setChat(Inbox inbox) {}

    public Canal getCanal() { return canal; }
    public void setCanal(Canal canal) { this.canal = canal; }

    public MensagemDireta getMensagemDireta() { return mensagemDireta; }
    public void setMensagemDireta(MensagemDireta mensagemDireta) {
        this.mensagemDireta = mensagemDireta;
    }
}

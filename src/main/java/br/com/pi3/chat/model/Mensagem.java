package br.com.pi3.chat.model;

import br.com.pi3.chat.model.rooms.Inbox;
import br.com.pi3.chat.model.rooms.MensagemDireta;
import br.com.pi3.chat.model.rooms.Room;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Entity
@AllArgsConstructor
@Data
public class Mensagem {


    @GeneratedValue @Id Integer id;
    String conteudo;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User autor;

    @ManyToOne
    Room chat;

    @Column(name = "data_envio")
    private Instant dataEnvio;  // ← CAMPO FALTANDO!

    private boolean editada = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "canal_id")
    private Room room;

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

    public Instant getDataEnvio() { return dataEnvio;}
    public void setDataEnvio(Instant dataEnvio) { this.dataEnvio = dataEnvio; }

    public void setEditada(boolean editada) { this.editada = editada; }

    public Room getCanal() { return room; }
    public void setCanal(Room room) { this.room = room; }

    public MensagemDireta getMensagemDireta() { return mensagemDireta; }
    public void setMensagemDireta(MensagemDireta mensagemDireta) {
        this.mensagemDireta = mensagemDireta;
    }
}

package br.com.pi3.chat.model;

import br.com.pi3.chat.model.rooms.Canal;
import br.com.pi3.chat.model.rooms.MensagemDireta;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Mensagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String conteudo;

    @ManyToOne
    @JoinColumn(name = "remetente_id")
    private User remetente;

    @ManyToOne
    @JoinColumn(name = "canal_id", nullable = true)
    private Canal canal;

    @ManyToOne
    @JoinColumn(name = "dm_id", nullable = true)
    private MensagemDireta mensagemDireta;

    private LocalDateTime createdAt = LocalDateTime.now();

    public Mensagem() {}

    public Mensagem(String m){
        this.conteudo = m;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public void setRemetente(User remetente) {
        this.remetente = remetente;
    }

    public void setCanal(Canal canal) {
        this.canal = canal;
    }

    public void setDm(MensagemDireta dm) {
        this.mensagemDireta = dm;
    }

}

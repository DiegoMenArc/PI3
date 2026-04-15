package br.com.pi3.chat.model.rooms;

import br.com.pi3.chat.model.Mensagem;
import br.com.pi3.chat.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public abstract class Chat {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoChat tipo;

    @ManyToOne
    private User criador, admin;

    @ManyToMany
    private Set<User> participantes = new HashSet<>();

    @OneToMany(mappedBy = "chat", cascade = CascadeType.ALL)
    private List<Mensagem> mensagens = new ArrayList<>();


    //getters / setters

    public Long getId() {
        return id;
    }

    public TipoChat getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }

    public User getCriador() {
        return criador;
    }

    public User getAdmin() {
        return admin;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setParticipantes(Set<User> participantes) {
        this.participantes = participantes;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public void setTipo(TipoChat tipo) {
        this.tipo = tipo;
    }

    public Set<User> getParticipantes() {
        return participantes;
    }
}


package br.com.pi3.chat.model.rooms;

import br.com.pi3.chat.model.Mensagem;
import br.com.pi3.chat.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Comunidade extends Chat {
    @GeneratedValue @Id Long id;
    String nome;
    @OneToMany List<Mensagem> mensagens;

    // Administrador da comunidade
    @ManyToOne
    @JoinColumn(name = "main_admin_id")
    private User mainAdmin;

    // Lista de usuários participantes da comunidade
    @OneToMany
    @JoinColumn(name = "comunidade_id")
    private List<User> users = new ArrayList<>();

    // getters

    public List<User> getUsers() {
        return users;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public User getMainAdmin() {
        return mainAdmin;
    }

    @Override
    public boolean enviaMensagem(String msg) {
        return false;
    }

    @Override
    public boolean deletaMensagem() {
        return false;
    }

    @Override
    public boolean editaMensagem() {
        return false;
    }
}
package br.com.pi3.chat.model.rooms;

import br.com.pi3.chat.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Comunidade extends Room {

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
        return this.getAdmin();
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
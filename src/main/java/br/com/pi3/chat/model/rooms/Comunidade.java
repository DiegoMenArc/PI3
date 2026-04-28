package br.com.pi3.chat.model.rooms;

import br.com.pi3.chat.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
public class Comunidade extends Room {

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

    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public User getAdmin() {
        return super.getAdmin();
    }


}
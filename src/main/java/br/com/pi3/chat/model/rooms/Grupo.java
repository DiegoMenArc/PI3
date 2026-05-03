package br.com.pi3.chat.model.rooms;

import br.com.pi3.chat.model.tipoRoom;
import jakarta.persistence.Entity;

@Entity
public class Grupo extends Room {

    private tipoRoom Grupo= tipoRoom.Grupo;
    @Override
    public boolean enviaMensagem(String msg) {
        return true; // já implementado
    }

    public boolean deletaMensagem() {
        return true;
    }

    public boolean editaMensagem() {
        return true;
    }
}

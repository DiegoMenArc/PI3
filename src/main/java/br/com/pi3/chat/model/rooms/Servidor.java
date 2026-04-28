package br.com.pi3.chat.model.rooms;

import br.com.pi3.chat.model.User;
import br.com.pi3.chat.model.tipoRoom;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Servidor extends Room {
    private tipoRoom Servidor = tipoRoom.Servidor;

    //getters

    public String getNome() {
        return this.getNome();
    }

    public Long getId() {
        return this.getId();
    }

    @ManyToOne
    public User getAdmin(){return this.getAdmin();}

    public List<User> getUsers() {
        return this.getUsers();
    }

    //setters

    public void setNome(String nome) {
        this.setNome(nome);
    }

    public void setMainAdmin(User admin) {
        this.setMainAdmin(admin);
    }

}


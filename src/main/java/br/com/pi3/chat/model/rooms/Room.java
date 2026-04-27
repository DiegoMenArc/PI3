package br.com.pi3.chat.model.rooms;

import br.com.pi3.chat.model.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public abstract class Room {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private List<User> users;

    @ManyToOne
    private User admin;

    public User getAdmin() {
        return admin;
    }

    public boolean enviaMensagem(String msg){return true;};
    public boolean deletaMensagem(){return true;};
    public boolean editaMensagem(){return true;};


    //getters

    public String getNome() {
        return nome;
    }

    public Long getId() {
        return id;
    }
}

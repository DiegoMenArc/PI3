package br.com.pi3.chat.model.rooms;

import br.com.pi3.chat.model.User;
import br.com.pi3.chat.model.UserRoom;
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
public abstract class Room {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserRoom> userRooms = new ArrayList<>();

    @ManyToMany
    private Set<User> users = new HashSet<>();

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

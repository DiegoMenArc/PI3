package br.com.pi3.chat.model.rooms;

import br.com.pi3.chat.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public abstract class Room {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "chat_room_users",
            joinColumns = @JoinColumn(name = "chat_room_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users = new ArrayList<>();

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

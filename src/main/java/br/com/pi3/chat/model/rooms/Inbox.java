package br.com.pi3.chat.model.rooms;

import br.com.pi3.chat.model.User;
import br.com.pi3.chat.model.tipoRoom;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Inbox {

    private tipoRoom Ibox = tipoRoom.Inbox;
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



}

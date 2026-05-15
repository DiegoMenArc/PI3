package br.com.pi3.chat.model;

import br.com.pi3.chat.model.rooms.Room;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
public class UserRoom {
    //entidade de associação entre room e user
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    private Instant entrouEm;
    private String role; //

    public UserRoom() {}

    public UserRoom(User user, Room room, String papel) {
        this.user = user;
        this.room = room;
        this.role = papel;
        this.entrouEm = Instant.now();
    }


    public Long getId() {
        return id;
    }

    public Instant getEntrouEm() {
        return entrouEm;
    }

    public Room getRoom() {
        return room;
    }

    public String getPapel() {
        return role;
    }

    public User getUser() {
        return user;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setEntrouEm(Instant entrouEm) {
        this.entrouEm = entrouEm;
    }

    public void setPapel(String role) {
        this.role = role;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
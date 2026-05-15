package br.com.pi3.chat.DTO.room;


import br.com.pi3.chat.model.User;

import java.util.List;

public class RoomRequestDTO {

    private Long id;
    private String nome;
    private List<User> users;
    private User admin;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<User> getUsers() {
        return users;
    }

    public User getAdmin() {
        return admin;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}

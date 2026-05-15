package br.com.pi3.chat.DTO.user;

import br.com.pi3.chat.model.Role;
import br.com.pi3.chat.model.rooms.Room;

import java.util.List;

public class UserRequestDTO {

    Long id;
    String nome, email, senha;
    Role role;
    List<Room> rooms;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
    }

    public List<Room> getRooms() {
        return rooms;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}

package br.com.pi3.chat.dto.room;

import br.com.pi3.chat.model.Mensagem;
import br.com.pi3.chat.model.User;

import java.util.List;

public class RoomResponseDTO {

    private Long id;
    private String nome;
    private List<User> users;
    private List<Mensagem> mensagens;
    private User admin;

    public RoomResponseDTO(Long id, String nome, List<User> us, List<Mensagem> ms, User a){
        this.admin =a;
        this.mensagens = ms;
        this.nome=nome;
        this.users=us;
        this.id=id;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public User getAdmin() {
        return admin;
    }

    public List<Mensagem> getMensagens() {
        return mensagens;
    }

    public List<User> getUsers() {
        return users;
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


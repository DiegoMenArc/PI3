package br.com.pi3.chat.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Comunidade {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;

    // Administrador da comunidade
    @ManyToOne
    @JoinColumn(name = "main_admin_id")
    private User mainAdmin;

    // Lista de usuários participantes da comunidade
    @OneToMany
    @JoinColumn(name = "comunidade_id")
    private List<User> users = new ArrayList<>();

    // getters

    public List<User> getUsers() {
        return users;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public User getMainAdmin() {
        return mainAdmin;
    }
}
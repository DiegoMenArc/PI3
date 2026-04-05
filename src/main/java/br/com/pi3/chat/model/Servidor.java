package br.com.pi3.chat.model;

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
public class Servidor {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;

    // Um servidor tem um administrador principal
    @ManyToOne
    @JoinColumn(name = "main_admin_id")
    private User mainAdmin;

    // Um servidor possui vários usuários
    @OneToMany(mappedBy = "servidor")
    private List<User> users = new ArrayList<>();

    //getters

    public String getNome() {
        return nome;
    }

    public Long getId() {
        return id;
    }


    public User getMainAdmin() {
        return mainAdmin;
    }

    public List<User> getUsers() {
        return users;
    }

    //setters

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMainAdmin(User mainAdmin) {
        this.mainAdmin = mainAdmin;
    }

}


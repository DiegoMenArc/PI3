package br.com.pi3.chat.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Servidor {

    @Id @GeneratedValue Long id;
    private String nome;
    private User mainAdmin;
    private ArrayList<User> users;

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

    public ArrayList<User> getUsers() {
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


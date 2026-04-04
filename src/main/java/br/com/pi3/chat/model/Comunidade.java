package br.com.pi3.chat.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Comunidade {

    @Id @GeneratedValue Long id;
    private String nome;
    private User mainAdmin;
    private ArrayList<User> users;

    public ArrayList<User> getUsers() {
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

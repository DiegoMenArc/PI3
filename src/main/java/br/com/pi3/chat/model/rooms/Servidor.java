package br.com.pi3.chat.model.rooms;

import br.com.pi3.chat.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Servidor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    // Um servidor tem um administrador principal
    @ManyToOne
    @JoinColumn(name = "main_admin_id")
    private User mainAdmin;

    // Um servidor possui vários usuários
    @ManyToMany(mappedBy = "servidores")
    private List<User> users = new ArrayList<>();

    // canais
    @OneToMany(mappedBy = "servidor", cascade = CascadeType.ALL)
    private List<Canal> canais = new ArrayList<>();

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


package br.com.pi3.chat.model;

import br.com.pi3.chat.model.rooms.Servidor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity // Indica que essa classe é uma entidade do banco de dados
@Table(name = "Users")
public class User{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    // Dados básicos do usuário
    private Long id;
    private String nome, email, username, senha;
    @Enumerated(EnumType.STRING) // Salva o enum como String no banco h2
    private Role role;

    @ManyToMany
    @JoinTable(
            name = "membros_do_servidor",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "serv_id")
    )
    private List<Servidor> servidores = new ArrayList<>();

    // getters

    public Long getId() {
        return id;
    }

    public Role getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getUsername() {
        return username;
    }

    public String getSenha() {
        return senha;
    }

    //setters

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}


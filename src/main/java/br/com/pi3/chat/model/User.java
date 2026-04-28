package br.com.pi3.chat.model;

import br.com.pi3.chat.model.rooms.Room;
import br.com.pi3.chat.model.rooms.Servidor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity // Indica que essa classe é uma entidade do banco de dados
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User{
    @Id // Chave primária
    @GeneratedValue(strategy = GenerationType.AUTO) // Auto incremento

    // Dados básicos do usuário
    private Long id;
    private String nome, email, senha;
    @Enumerated(EnumType.STRING) // Salva o enum como String no banco h2
    private Role role;

    @ManyToOne  // ou @ManyToMany
    @JoinColumn(name = "chat_room_id")
    private Room chatRoom;  // ou Canal

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

    public void setSenha(String senha) {
        this.senha = senha;
    }
}


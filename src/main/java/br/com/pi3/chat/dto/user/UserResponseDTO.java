package br.com.pi3.chat.DTO.user;

import br.com.pi3.chat.model.Role;

public class UserResponseDTO {

    private Long id;
    private String nome, email, senha;
    private Role role;

    public UserResponseDTO (Long id, String nome, String email, String senha, Role r){
        this.id = id;
        this.nome=nome;
        this.email=email;
        this.senha=senha;
        this.role = r;
    }

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

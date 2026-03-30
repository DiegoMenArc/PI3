package br.com.pi3.chat.model;

public class User {
    private Integer id, cont=1;
    private String nome, email;
    private Role role;

    public User(){
        this.id = cont;
        cont++;
    }

    public User(String nome){

        this.nome = nome;

        this.id = cont;
        cont++;
    }

    // getters

    public Integer getId() {
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

    //setters

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

class Role{
    String role;
}

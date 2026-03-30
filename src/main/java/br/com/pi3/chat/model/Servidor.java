package br.com.pi3.chat.model;

import java.util.Random;

public class Servidor {
    private Random rd;

    private String nome;
    private Long id;
    private User mainAdmin;
    private User[] users;

    public Servidor(){
        this.id = rd.nextLong(1000000);
    }

    public Servidor(String nome){
        this.nome = nome;
    }


    //getters

    public String getNome() {
        return nome;
    }

    public Long getId() {
        return id;
    }

    public Random getRd() {
        return rd;
    }

    public User getMainAdmin() {
        return mainAdmin;
    }

    public User[] getUsers() {
        return users;
    }

    //setters

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMainAdmin(User mainAdmin) {
        this.mainAdmin = mainAdmin;
    }

    public void setRd(Random rd) {
        this.rd = rd;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }
}


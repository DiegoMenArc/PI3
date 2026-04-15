package br.com.pi3.chat.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class Mensagem {
    @GeneratedValue @Id int id;
    String conteudo;

    public Mensagem(String m){
        this.conteudo = m;
    }

    public String getConteudo() {
        return conteudo;
    }
}

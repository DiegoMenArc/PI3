package br.com.pi3.chat.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public abstract class Chat {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;

    public boolean enviaMensagem(String msg){return true;};
    public boolean deletaMensagem(){return true;};
    public boolean editaMensagem(){return true;};

}

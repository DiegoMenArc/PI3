package br.com.pi3.chat.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Inbox {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private List<User> users = new ArrayList<>();



}

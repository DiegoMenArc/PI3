package br.com.pi3.chat.model.rooms;

import br.com.pi3.chat.model.Mensagem;
import br.com.pi3.chat.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Comunidade extends Chat {
    // Administrador da comunidade
    @ManyToOne
    @JoinColumn(name = "main_admin_id")
    private User mainAdmin;

    @ManyToMany
    private List<User> users = new ArrayList<>();


}
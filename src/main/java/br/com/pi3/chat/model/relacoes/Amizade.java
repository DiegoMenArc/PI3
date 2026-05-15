package br.com.pi3.chat.model.relacoes;

import br.com.pi3.chat.model.User;
import jakarta.persistence.*;

@Entity
@IdClass(AmizadeId.class)
public class Amizade {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id_1")
    private User user1;

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id_2")
    private User user2;

    @Enumerated(EnumType.STRING)
    private StatusAmizade status;
}

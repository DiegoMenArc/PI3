package br.com.pi3.chat.model.rooms;

import br.com.pi3.chat.model.Mensagem;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Canal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoCanal tipo;

    @ManyToOne
    @JoinColumn(name = "serv_id")
    private Servidor servidor;

    @OneToMany(mappedBy = "canal", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Mensagem> mensagens = new ArrayList<>();
}
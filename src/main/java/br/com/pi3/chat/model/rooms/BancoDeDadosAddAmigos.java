package br.com.pi3.chat.model.rooms;


import jakarta.persistence.*;

@Entity
@Table(name = "AddAmigos")
public class BancoDeDadosAddAmigos {

    @Id // Chave primária
    @GeneratedValue(strategy = GenerationType.AUTO) // Auto incremento
    private String id;

    private Long idp1;

    @Enumerated(EnumType.STRING)
    private StatusAmizade p1;

    private Long idp2 ;

    @Enumerated(EnumType.STRING)
    private StatusAmizade p2;


    //getters

    public String getId() {
        return id;
    }

    public Long getIdp1() {
        return idp1;
    }

    public StatusAmizade getP1() {
        return p1;
    }

    public Long getIdp2() {
        return idp2;
    }

    public StatusAmizade getP2() {
        return p2;
    }

    //setters

    public void setId(String id) {
        this.id = id;
    }

    public void setIdp1(Long idp1) {
        this.idp1 = idp1;
    }

    public void setP1(StatusAmizade p1) {
        this.p1 = p1;
    }

    public void setIdp2(Long idp2) {
        this.idp2 = idp2;
    }

    public void setP2(StatusAmizade p2) {
        this.p2 = p2;
    }
}

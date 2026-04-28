package br.com.pi3.chat.model;

public enum tipoRoom{

    Inbox("Inbox"),
    Grupo("Grupo"),
    Servidor("Servidor"),
    Comunidade("Comunidade")
    ;

    private String tipo;
    tipoRoom(String tipo){
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

}

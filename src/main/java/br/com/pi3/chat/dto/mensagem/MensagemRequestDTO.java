package br.com.pi3.chat.DTO.mensagem;

import br.com.pi3.chat.model.Mensagem;
import br.com.pi3.chat.model.User;
import br.com.pi3.chat.model.rooms.Room;
import br.com.pi3.chat.repository.JpaRepositoryMensagem;
import br.com.pi3.chat.repository.JpaRepositoryRoom;
import br.com.pi3.chat.repository.JpaRepositoryUser;

public class MensagemRequestDTO {

    private Long chatId;
    private Long userId;
    private String conteudo;

    public String getConteudo() {
        return conteudo;
    }

    public Long getChatId() {
        return chatId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public void setChatId(Long chatId) { this.chatId = chatId; }

    public void setUserId(Long userId) { this.userId = userId; }
}

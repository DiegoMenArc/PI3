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
    private Long canalId;    // se for via canal
    private Long dmId;       // se for via DM
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

    private JpaRepositoryMensagem mensagemRepository;
    private JpaRepositoryUser userRepository;
    private JpaRepositoryRoom chatRepository;

    public br.com.pi3.chat.DTO.mensagem.MensagemResponseDTO enviarMensagem(MensagemRequestDTO dto) {

        Room chat = (Room) chatRepository.findById(dto.getChatId()).orElseThrow();
        User user = (User) userRepository.findById(dto.getUserId()).orElseThrow();

        Mensagem msg = new Mensagem();
        msg.setConteudo(dto.getConteudo());
        msg.setAutor(user);
        msg.setChat(chat);

        mensagemRepository.save(msg);

        return new br.com.pi3.chat.DTO.mensagem.MensagemResponseDTO(msg);
    }

}

package br.com.pi3.chat.repository;

import br.com.pi3.chat.model.Mensagem;
import br.com.pi3.chat.model.User;
import br.com.pi3.chat.model.rooms.Chat;
import br.com.pi3.chat.model.rooms.TipoChat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JpaRepositoryChat extends JpaRepository<Chat, Long> {

    Optional<Chat> findByTipoAndParticipantesContaining(TipoChat tipo, User user);
    //lista todos os chats de um tipo especifico de um user

    List<Chat> findByParticipantesContaining(User user);
    //Lista todos os chats que um user participa


}

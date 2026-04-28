package br.com.pi3.chat.repository;

import br.com.pi3.chat.model.Mensagem;
import br.com.pi3.chat.model.rooms.Room;
import br.com.pi3.chat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaRepositoryRoom extends JpaRepository<Room, Long> {
}

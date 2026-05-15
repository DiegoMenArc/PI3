package br.com.pi3.chat.repository;

import br.com.pi3.chat.model.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaRepositoryMensagem extends JpaRepository<Mensagem, Long> {
    List<Mensagem> findByChat_IdOrderByDataEnvioDesc(Long chatId);
}
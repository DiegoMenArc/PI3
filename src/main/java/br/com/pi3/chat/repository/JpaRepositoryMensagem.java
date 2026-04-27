package br.com.pi3.chat.repository;

import br.com.pi3.chat.model.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaRepositoryMensagem extends JpaRepository {

    Mensagem saveMensage(Mensagem m);
    List<Mensagem> findAllMessages();
    Mensagem findMessageById(Integer id);
    Boolean deleteMensagem(Integer id);
    Mensagem editMensagem(Integer id, String novo);

}

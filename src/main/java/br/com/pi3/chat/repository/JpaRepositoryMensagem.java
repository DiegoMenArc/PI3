package br.com.pi3.chat.repository;


import br.com.pi3.chat.model.Mensagem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface JpaRepositoryMensagem extends JpaRepository<Mensagem, Long> {

    List<Mensagem> findByCanalIdOrderByCreatedAtDesc(Long canalId);
    List<Mensagem> findByMensagemDiretaIdOrderByCreatedAtDesc(Long dmId);

    Page<Mensagem> findByCanalIdOrderByCreatedAtDesc(Long canalId, Pageable pageable);

    Page<Mensagem> findByMensagemDiretaIdOrderByCreatedAtDesc(Long dmId, Pageable pageable);

//    // Lista TODAS msgs do chat, ordenadas por created_at DESC (recentes primeiro)
//    List<Mensagem> findByChatIdOrderByCreatedAtDesc(Long chatId);
//
//    // Com paginação (essencial para servers grandes)
//    Page<Mensagem> findByChatIdOrderByCreatedAtDesc(Long chatId, Pageable pageable);
//
//    // Últimas N mensagens
//    List<Mensagem> findFirst10ByChatIdOrderByCreatedAtDesc(Long chatId);
//
//    // Por chat + sender
//    List<Mensagem> findByChatIdAndSenderIdOrderByCreatedAtDesc(Long chatId, Long senderId);
}

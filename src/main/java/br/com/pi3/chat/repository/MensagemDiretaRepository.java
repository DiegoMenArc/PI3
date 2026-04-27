package br.com.pi3.chat.repository;

import br.com.pi3.chat.model.rooms.MensagemDireta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MensagemDiretaRepository extends JpaRepository<MensagemDireta, Long> {

    Optional<MensagemDireta> findByUser1IdAndUser2Id(Long user1, Long user2);

}
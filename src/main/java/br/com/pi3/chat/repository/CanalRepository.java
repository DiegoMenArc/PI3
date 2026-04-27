package br.com.pi3.chat.repository;

import br.com.pi3.chat.model.rooms.Canal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CanalRepository extends JpaRepository<Canal, Long> {

    List<Canal> findByServidorId(Long servidorId);

}

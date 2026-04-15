package br.com.pi3.chat.repository;

import br.com.pi3.chat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface JpaRepositoryUser extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    boolean existsByUsername(String username); //Vai retornar se o username do paramatro já existe no banco de dados

    boolean existsByEmail(String email); //Vai retornar se o email já estiver sendo usado
}

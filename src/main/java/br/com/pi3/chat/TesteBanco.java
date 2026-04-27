package br.com.pi3.chat;

import br.com.pi3.chat.model.User;
import br.com.pi3.chat.repository.JpaRepositoryUser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("dev")
public class TesteBanco {

    @Bean
    CommandLineRunner testar(JpaRepositoryUser repo) {
        return args -> {
            User u = new User();
            u.setUsername("teste");
            u.setEmail("teste@email.com");
            u.setSenha("123");

            if (repo.findAll().isEmpty()) {
                repo.save(u);
                System.out.println("USUÁRIO SALVO COM SUCESSO!");
            } else {
                System.out.println("JÁ EXISTE USUÁRIO NO BANCO");
            }

            System.out.println(repo.findAll());
        };
    }
}
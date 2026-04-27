package br.com.pi3.chat.controller;

import br.com.pi3.chat.model.User;
import br.com.pi3.chat.repository.JpaRepositoryUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Users")
public class UserController {

    private final JpaRepositoryUser repo;

    public UserController(JpaRepositoryUser repo) {
        this.repo = repo;
    }

    @PostMapping
    public User criarUsuario(@RequestBody User user) {
        return repo.save(user);
    }
}
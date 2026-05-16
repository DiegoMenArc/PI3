package br.com.pi3.chat.runner; // Pode colocar em um pacote de configuração

import br.com.pi3.chat.controller.UserController;
import br.com.pi3.chat.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TesteRunner implements CommandLineRunner {

    // Injetamos o seu Controller aqui
    private final UserController userController;

    public TesteRunner(UserController userController) {
        this.userController = userController;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Iniciando teste pelo Runner...");

        // 1. Criamos um usuário de mentira
        User novoUsuario = new User();
        novoUsuario.setNome("teste");
        novoUsuario.setEmail("teste@teste");
        novoUsuario.setSenha("1234");

        // 1. Criamos um usuário de mentira
        User novoUsuario2 = new User();
        novoUsuario2.setNome("teste2");
        novoUsuario2.setEmail("teste2@teste");
        novoUsuario2.setSenha("1234");

        userController.criarUsuario(novoUsuario);
        userController.criarUsuario(novoUsuario2);
    }
}
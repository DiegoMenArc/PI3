package br.com.pi3.chat.controller.paginasInit;

import br.com.pi3.chat.model.Role;
import br.com.pi3.chat.model.User;
import br.com.pi3.chat.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CadastroController {

    private final UserService userService;

    public CadastroController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/cadastro")
    public String exibirForm() {
        return "Cadastro";
    }

    @PostMapping("/registrar")
    public String processarCadastro(
            @RequestParam String username,
            @RequestParam String email,
            @RequestParam String confirmarEmail,
            @RequestParam String senha,
            @RequestParam String confirmarSenha
    ) {

        if (!email.equals(confirmarEmail)) {
            return "redirect:/cadastro?error=email";
        }

        if (!senha.equals(confirmarSenha)) {
            return "redirect:/cadastro?error=senha";
        }

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setSenha(senha); // depois você melhora com BCrypt
        user.setRole(Role.User);

        userService.criarUser(user);

        return "redirect:/login";
    }
}

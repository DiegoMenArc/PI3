package br.com.pi3.chat.controller.paginasInit;

import br.com.pi3.chat.model.User;
import br.com.pi3.chat.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String exibirLogin(){
        return "Login";
    }

    @PostMapping("/login")
    public String fazerLogin(@RequestParam String email,
                             @RequestParam String senha,
                             org.springframework.ui.Model model) {

        User user = userService.buscarPorEmail(email);

        if (user == null || !user.getSenha().equals(senha)) {
            model.addAttribute("erro", "Email ou senha inválidos");
            return "Login";
        }

        return "redirect:/home";
    }
}
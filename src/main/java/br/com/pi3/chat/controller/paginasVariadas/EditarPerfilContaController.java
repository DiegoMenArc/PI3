package br.com.pi3.chat.controller.paginasVariadas;


import br.com.pi3.chat.model.User;
import br.com.pi3.chat.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EditarPerfilContaController {
    private final UserService userService;

    public EditarPerfilContaController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/EditarPerfilConta")
    public String EditarPerfilConta(HttpSession session, Model model){
        User logado = (User) session.getAttribute("usuarioLogado");

        if (logado == null) {
            return "redirect:/";
        }

        model.addAttribute("nomeUsuario", logado.getNome());
        model.addAttribute("emailUsuario", logado.getEmail());

        return "EditarPerfilConta";
    }

    @PostMapping("/atualizarPerfil")
    public String atualizarPerfil(@RequestParam String username,
                                  @RequestParam String email,
                                  HttpSession session) {

        // 1. Pega o objeto completo que está na sessão
        User logado = (User) session.getAttribute("usuarioLogado");

        if (logado != null) {
            // 2. ATUALIZA os dados do objeto com o que veio do formulário
            logado.setUsername(username);
            logado.setEmail(email);

            // 3. Persiste no Banco de Dados
            userService.atualizar(logado.getId(), logado);

            // 4. SOBRESCREVE o objeto na sessão
            // Isso é vital para que o @GetMapping leia os dados novos no próximo carregamento
            session.setAttribute("usuarioLogado", logado);
        }


}

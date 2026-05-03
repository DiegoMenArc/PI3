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
    public String exibirPaginaEditar(HttpSession session, Model model) {
        User logado = (User) session.getAttribute("usuarioLogado");

        if (logado == null) {
            return "redirect:/";
        }

        model.addAttribute("nomeUsuario", logado.getUsername());
        model.addAttribute("emailUsuario", logado.getEmail());

        return "EditarPerfilConta";
    }

    @PostMapping("/atualizarPerfil")
    public String atualizarPerfil(@RequestParam String username,
                                  @RequestParam String email,
                                  HttpSession session) {

        User logado = (User) session.getAttribute("usuarioLogado");

        if (logado == null) {
            return "redirect:/login"; // Se a sessão caiu, manda pro login
        }

        try {
            // 1. Atualiza apenas os campos permitidos
            logado.setUsername(username);
            logado.setEmail(email);

            // 2. O service deve retornar o objeto atualizado vindo do banco
            User usuarioAtualizado = userService.editarUser(logado.getId(), logado);

            // 3. Atualiza a sessão com a versão "fresca" do banco de dados
            session.setAttribute("usuarioLogado", usuarioAtualizado);

            // Feedback para o usuário (opcional)
            System.out.println("sucesso" + "Perfil atualizado com sucesso!");

        } catch (Exception e) {
            System.out.println("erro" + "Erro ao atualizar perfil.");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

        return "redirect:/EditarPerfilConta";
    }
}
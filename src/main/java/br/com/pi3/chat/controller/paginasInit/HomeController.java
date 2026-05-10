package br.com.pi3.chat.controller.paginasInit;

import br.com.pi3.chat.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping("/{aba}")
    public String carregarAba(@PathVariable String aba, HttpSession session, Model model) {

        // 1. Verificação única de sessão para todas as abas
        User logado = (User) session.getAttribute("usuarioLogado");
        if (logado == null) {
            return "redirect:/";
        }

        // 2. Adiciona o usuário no model uma única vez
        model.addAttribute("nomeUsuario", logado.getNome());

        // 3. Direciona para o template correto baseado na URL
        switch (aba.toLowerCase()) {
            case "disponivel":
                return "pages/home/home";
            case "todos":
                return "pages/home/todosAmigos";
            case "pendentes":
                return "pages/home/pendentes";
            case "bloqueados":
                return "pages/home/bloqueados";
            case "adicionar":
                return "pages/home/addAmigos";
            default:
                // Se o usuário digitar uma aba que não existe, joga ele para a principal
                return "redirect:pages/amigos/disponivel";
        }
    }
}

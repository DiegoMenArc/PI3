package br.com.pi3.chat.controller.paginasInit;

import br.com.pi3.chat.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String Home(HttpSession session, Model model) {
        User logado = (User) session.getAttribute("usuarioLogado");

        if (logado == null) {
            return "redirect:/";
        }

        model.addAttribute("nomeUsuario", logado.getUsername());
        return "home/home"; // Retorna o nome do template
    }

    @GetMapping("/todos")
    public String Todos(HttpSession session, Model model){
        User logado = (User) session.getAttribute("usuarioLogado");

        if (logado == null) {
            return "redirect:/";
        }

        model.addAttribute("nomeUsuario", logado.getUsername());
        return "home/todosAmigos"; // Retorna o nome do template
    }

    @GetMapping("/addAmigos")
    public String HomeAddAmigos(HttpSession session, Model model) {
        User logado = (User) session.getAttribute("usuarioLogado");

        if (logado == null) {
            return "redirect:/";
        }

        model.addAttribute("nomeUsuario", logado.getUsername());

        return "home/HomeAddAmigos"; // Retorna o nome do template
    }
}

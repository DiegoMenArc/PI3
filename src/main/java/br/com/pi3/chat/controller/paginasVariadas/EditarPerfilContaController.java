package br.com.pi3.chat.controller.paginasVariadas;


import br.com.pi3.chat.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EditarPerfilContaController {

    @GetMapping("/EditarPerfilConta")
    public String EditarPerfilConta(HttpSession session, Model model){
        User logado = (User) session.getAttribute("usuarioLogado");

        if (logado == null) {
            return "redirect:/";
        }

        model.addAttribute("nomeUsuario", logado.getUsername());
        model.addAttribute("emailUsuario", logado.getEmail());

        return "EditarPerfilConta";

    }


}

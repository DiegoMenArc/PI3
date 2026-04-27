package br.com.pi3.chat.controller.entidades.chats;

import br.com.pi3.chat.model.User;
import br.com.pi3.chat.model.rooms.Room;
import br.com.pi3.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    //todos os endpoints de user
    @Autowired
    UserService userService;

    @GetMapping("/chat/{id}")
    public String procurarUser(@PathVariable Long id, Model model) {
        User user = userService.buscarUser(id);
        //pega o user dentro do service/bd
        model.addAttribute("user", user);
        return "user";
    }

    @PostMapping("/user")
    public String criaUser(@PathVariable User user){
        User service = userService.saveUser(user);
        return "redirect:/user/" +service.getId();
    }

    @PostMapping("/user")
    public String editUser(@PathVariable Long id, User u, Model m){
        User service = userService.editarUser(id, u);
        m.addAttribute("user", u);
        return "user";
    }

}

package br.com.pi3.chat.controller.entidades.chats;


import br.com.pi3.chat.DTO.userDTO;
import br.com.pi3.chat.model.User;
import br.com.pi3.chat.model.rooms.BancoDeDadosAddAmigos;
import br.com.pi3.chat.model.rooms.StatusAmizade;
import br.com.pi3.chat.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static br.com.pi3.chat.model.rooms.StatusAmizade.PENDENTE;


@Controller
public class PedidoDeAmigoController {

    @Autowired
    private UserService s;

    @PostMapping("/addAmigo/nome")
    public String ADDAmigo(@RequestParam("username") String pessoaP, Model m, HttpSession session)
    {
        User logado = (User) session.getAttribute("usuarioLogado");


        User amigo = s.buscarPorUsername(pessoaP);

        System.out.println(amigo.getEmail());
        System.out.println(amigo.getId());

//
//
//        b.setIdp2(p2.getId());
//
//
//
//        if(p2 != null)
//        {
//

//
//        }
//
//        else
//        {
//            return "redirect:/addAmigo/adicionados";
//        }

        return "redirect:/home/adicionar";
    }



    @GetMapping("/addAmigo/adicionados")
    public String adicionados()
    {

        return "pages/home/addAmigos";
    }



}

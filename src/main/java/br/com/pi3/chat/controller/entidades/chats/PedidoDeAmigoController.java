package br.com.pi3.chat.controller.entidades.chats;


import br.com.pi3.chat.DTO.userDTO;
import br.com.pi3.chat.model.User;
import br.com.pi3.chat.model.rooms.BancoDeDadosAddAmigos;
import br.com.pi3.chat.model.rooms.StatusAmizade;
import br.com.pi3.chat.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static br.com.pi3.chat.model.rooms.StatusAmizade.PENDENTE;


@Controller
public class PedidoDeAmigoController {

    private UserService s;

    @PostMapping("/addAmigo/nome")
    public String ADDAmigo(@RequestParam("PessoaPesquisada") String PessoaP, Model m)
    {
        BancoDeDadosAddAmigos b = new BancoDeDadosAddAmigos();;
        
        User p2 = s.buscarPorUsername(PessoaP);



        b.setIdp2(p2.getId());



        if(p2 != null)
        {

            b.setP1(PENDENTE);
            b.setP2(PENDENTE);

        }

        else
        {
            return "redirect:/addAmigo/adicionados";
        }

        return "redirect:/addAmigo/adicionados";
    }



    @GetMapping("/addAmigo/adicionados")
    public String adicionados()
    {

        return "pages/home/addAmigos";
    }



}

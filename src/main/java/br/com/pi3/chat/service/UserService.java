package br.com.pi3.chat.service;

import br.com.pi3.chat.model.User;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService {

    // Lista em memória (simulando um banco de dados)
    private List<User> users = new ArrayList<>();

//    protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    }

    // "Salva" um usuário na lista
    public User saveUser(User user){
        this.users.add(user);
        Long id = user.getId();

        // Retorna o usuário "salvo"
        return this.buscarUser(user.getId());
    }

    // Busca usuário pelo ID
    public User buscarUser(Long id){
        for(User user : users){
            if(id.equals(user.getId())){
                return user;
            }
        }
        return null;
    }

    public User editarUser(Long id, User user){
        for(User u: users){
            if(id.equals(u.getId())){
                u = user;
                return u;
            }
        }
        System.out.println("Uusuário Não encontrado");
        return null;
    }
}

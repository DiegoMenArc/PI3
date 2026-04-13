package br.com.pi3.chat.service;

import br.com.pi3.chat.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    // Lista em memória (simulando um banco de dados)
    private List<User> users = new ArrayList<>();

//    protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    }

    // "Salva" um usuário na lista
    public String saveUser(User user){
        this.users.add(user);
        Long id = user.getId();

        // Retorna o usuário "salvo"
        return "User: "+getUserById(user.getId());
    }

    // Busca usuário pelo ID
    public User getUserById(Long id){
        for(User user : users){
            if(id.equals(user.getId())){
                return user;
            }
        }
        return null;
    }
}

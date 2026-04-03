package br.com.pi3.chat.servlets;

import br.com.pi3.chat.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

public class UserService extends HttpServlet {

    private ArrayList<User> Users;

    protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    public String saveUser(User user){
        this.Users.add(user);
        Long id = user.getId();
        return "User: "+getUserById(user.getId());
    }

    public User getUserById(Integer id){
        for(User user : Users){
            if(id == user.getId()){
                return user;
            }
        }
        return null;
    }
}

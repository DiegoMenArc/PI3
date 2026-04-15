package br.com.pi3.chat.service;

import br.com.pi3.chat.model.User;
import br.com.pi3.chat.repository.JpaRepositoryUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService {

    private final JpaRepositoryUser userRepository;

    //Os códigos desse service estão autoexplicativos

    public UserService(JpaRepositoryUser userRepository) {
        this.userRepository = userRepository;
    }

    public User criarUser(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Username já existe");
            //se já existir o username, não será criado um igual
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email já existe");
            //se já existir o email, não será criado um igual
        }
        return userRepository.save(user);
        //retorna o user salvo no BD
    }

    public User buscarPorId(Long id) {
        return userRepository.findById(id)//Retorna user pelo id
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        //Ou emite uma mensage por Throw
    }

    public User buscarPorUsername(String username) {
        return userRepository.findByUsername(username)//Retorna user pelo Username
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public List<User> listarTodos() {
        return userRepository.findAll();
    }

    public User atualizar(Long id, User dados) {
        User user = buscarPorId(id);
        user.setUsername(dados.getUsername());
        user.setEmail(dados.getEmail());
        user.setSenha(dados.getSenha());
        return userRepository.save(user);
    }

    public void deletar(Long id) {
        userRepository.deleteById(id);
    }
}

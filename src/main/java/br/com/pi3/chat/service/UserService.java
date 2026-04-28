package br.com.pi3.chat.service;

import br.com.pi3.chat.model.User;
import br.com.pi3.chat.repository.JpaRepositoryMensagem;
import br.com.pi3.chat.repository.JpaRepositoryUser;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    private final JpaRepositoryUser userRepository;

    //Os códigos desse service estão autoexplicativos

    public UserService(JpaRepositoryUser userRepository) {
        this.userRepository = userRepository;
    }

    public User criarUser(User user) {
        if (userRepository.existsByUsername(user.getNome())) {
            throw new RuntimeException("Nome já existe");
            //se já existir o username, não será criado um igual
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email já existe");
            //se já existir o email, não será criado um igual
        }
        return userRepository.save(user);
        //retorna o user salvo no BD
    }

    public User buscarPorId(Long id) throws Throwable {
        return (User) userRepository.findById(id)//Retorna user pelo id
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        //Ou emite uma mensage por Throw
    }

    public User buscarPorUsername(String nome) {
        return userRepository.findByUsername(nome)//Retorna user pelo Username
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public List<User> listarTodos() {
        return userRepository.findAll();
    }

    public User editarUser(Long id, User dados) throws Throwable {
        User user = buscarPorId(id);
        user.setNome(dados.getNome());
        user.setEmail(dados.getEmail());
        user.setSenha(dados.getSenha());
        return userRepository.save(user);
    }

    public void deletar(Long id) {
        userRepository.deleteById(id);
    }

    // "Salva" um usuário na lista
    public User saveUser(User user) throws Throwable {
        this.userRepository.save(user);
        Long id = user.getId();

        // Retorna o usuário "salvo"
        return this.buscarPorId(user.getId());
    }

    // Busca usuário pelo ID

    public User autenticar(String email, String senha) {
        // ✅ findByEmail retorna Optional<User>
        Optional<User> optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isEmpty()) {
            return null;
        }

        User user = optionalUser.get();

        if (!user.getSenha().equals(senha)) {
            return null;
        }

        return user;
    }
}

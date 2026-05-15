package br.com.pi3.chat.service;

import br.com.pi3.chat.DTO.mensagem.MensagemResponseDTO;
import br.com.pi3.chat.model.Mensagem;
import br.com.pi3.chat.model.User;
import br.com.pi3.chat.model.rooms.Room;
import br.com.pi3.chat.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MensagemService {

    private final JpaRepositoryMensagem mensagemRepository;
    private final JpaRepositoryUser userRepository;
    private final JpaRepositoryRoom canalRepository;

    public MensagemService(JpaRepositoryMensagem mensagemRepository,
                           JpaRepositoryUser userRepository,
                           JpaRepositoryRoom canalRepository) {
        this.mensagemRepository = mensagemRepository;
        this.userRepository = userRepository;
        this.canalRepository = canalRepository;
    }

    public MensagemResponseDTO enviarParaCanal(Long userId, Long canalId, String conteudo) {
        // 1. Buscar User e Room (canal)
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        Room canal = canalRepository.findById(canalId)
                .orElseThrow(() -> new IllegalArgumentException("Canal não encontrado"));

        // 2. Criar entidade Mensagem
        Mensagem msg = new Mensagem();
        msg.setConteudo(conteudo);
        msg.setAutor(user);
        msg.setChat(canal);
        // msg.setDataEnvio(Instant.now());

        // 3. Salvar entidade
        Mensagem salva = mensagemRepository.save(msg);

        // 4. Retornar DTO
        return new MensagemResponseDTO(salva);
    }

    public void deletarMensagem(Long mensagemId) {
        mensagemRepository.deleteById(mensagemId);
    }

    public MensagemResponseDTO editarMensagem(Long mensagemId, String conteudo) {
        Mensagem m = mensagemRepository.findById(mensagemId).orElseThrow(() -> new RuntimeException("Mensagem não encontrada"));
        m.setConteudo(conteudo);
        Mensagem mensagemAtualizada = mensagemRepository.save(m);
        return new MensagemResponseDTO(mensagemAtualizada);

    }

    public List<Mensagem> listarPorChat(Long roomId) {
        return this.mensagemRepository.findByChat_IdOrderByDataEnvioDesc(roomId);
    }
}

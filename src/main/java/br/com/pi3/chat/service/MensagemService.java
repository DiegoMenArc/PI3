package br.com.pi3.chat.service;

import br.com.pi3.chat.model.Mensagem;
import br.com.pi3.chat.model.User;
import br.com.pi3.chat.model.rooms.Canal;
import br.com.pi3.chat.model.rooms.MensagemDireta;
import br.com.pi3.chat.repository.CanalRepository;
import br.com.pi3.chat.repository.JpaRepositoryMensagem;
import br.com.pi3.chat.repository.JpaRepositoryUser;
import br.com.pi3.chat.repository.MensagemDiretaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MensagemService {

    private final JpaRepositoryMensagem msgRepo;
    private final JpaRepositoryUser userRepo;
    private final CanalRepository canalRepo;
    private final MensagemDiretaRepository dmRepo;

    public MensagemService(JpaRepositoryMensagem msgRepo,
                           JpaRepositoryUser userRepo,
                           CanalRepository canalRepo,
                           MensagemDiretaRepository dmRepo) {
        this.msgRepo = msgRepo;
        this.userRepo = userRepo;
        this.canalRepo = canalRepo;
        this.dmRepo = dmRepo;
    }

    // Enviar mensagem para canal
    public Mensagem enviarParaCanal(Long userId, Long canalId, String conteudo) {

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Canal canal = canalRepo.findById(canalId)
                .orElseThrow(() -> new RuntimeException("Canal não encontrado"));

        Mensagem msg = new Mensagem();
        msg.setConteudo(conteudo);
        msg.setRemetente(user);
        msg.setCanal(canal);

        return msgRepo.save(msg);
    }

    // 🔹 Enviar mensagem para DM
    public Mensagem enviarParaDM(Long userId, Long dmId, String conteudo) {

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        MensagemDireta dm = dmRepo.findById(dmId)
                .orElseThrow(() -> new RuntimeException("DM não encontrada"));

        Mensagem msg = new Mensagem();
        msg.setConteudo(conteudo);
        msg.setRemetente(user);
        msg.setDm(dm);

        return msgRepo.save(msg);
    }
}
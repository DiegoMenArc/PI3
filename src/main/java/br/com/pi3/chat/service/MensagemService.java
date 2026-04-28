package br.com.pi3.chat.service;

import br.com.pi3.chat.model.Mensagem;
import br.com.pi3.chat.model.User;
import br.com.pi3.chat.model.rooms.Canal;
import br.com.pi3.chat.model.rooms.Inbox;
import br.com.pi3.chat.model.rooms.MensagemDireta;
import br.com.pi3.chat.model.rooms.Room;
import br.com.pi3.chat.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MensagemService {

    private final JpaRepositoryMensagem msgRepo;
    private final JpaRepositoryUser userRepo;
    private final CanalRepository canalRepo;
    private final MensagemDiretaRepository dmRepo;
    private JpaRepositoryRoom repo;

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
    public Mensagem enviarParaCanal(Long userId, Long canalId, String conteudo) throws Throwable {

        User user = (User) userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Room room = (Room) repo.findById(canalId)
                .orElseThrow(() -> new RuntimeException("Canal não encontrado"));

        Mensagem msg = new Mensagem();
        msg.setConteudo(conteudo);
        msg.setAutor(user);
        msg.setChat(room);

        return msgRepo.saveMensage(msg);
    }

    // 🔹 Enviar mensagem para DM
    public Mensagem enviarParaDM(Long userId, Long dmId, String conteudo) throws Throwable {

        User user = (User) userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        MensagemDireta dm = dmRepo.findById(dmId)
                .orElseThrow(() -> new RuntimeException("DM não encontrada"));

        Mensagem msg = new Mensagem();
        msg.setConteudo(conteudo);
        msg.setAutor(user);
        msg.setChat(new Inbox());

        return msgRepo.saveMensage(msg);
    }
}
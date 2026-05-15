package br.com.pi3.chat.controller.entidades.chats;

import br.com.pi3.chat.DTO.mensagem.MensagemRequestDTO;
import br.com.pi3.chat.DTO.mensagem.MensagemResponseDTO;
import br.com.pi3.chat.model.Mensagem;
import br.com.pi3.chat.model.rooms.Room;
import br.com.pi3.chat.service.MensagemService;
import br.com.pi3.chat.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoomController {

    private final RoomService roomService;
    private final MensagemService mensagemService;

    public RoomController(RoomService roomService, MensagemService mensagemService) {
        this.roomService = roomService;
        this.mensagemService = mensagemService;
    }

    // Criar room
    @PostMapping("/rooms")
    public ResponseEntity<Room> criarRoom(@RequestBody Room room) {
        Room criada = roomService.criarRoom(room);
        return ResponseEntity.status(HttpStatus.CREATED).body(criada);
    }

    // Buscar room por ID
    @GetMapping("/rooms/{id}")
    public ResponseEntity<Room> buscarRoom(@PathVariable Long id) {
        Room room = roomService.buscarRoom(id);
        return ResponseEntity.ok(room);
    }

    // Listar todas as rooms (opcional)
    @GetMapping("/rooms")
    public List<Room> listarTodasRooms() {
        return roomService.listarTodasRooms();
    }

    // Listar rooms de um usuário
    @GetMapping("/users/{userId}/rooms")
    public List<Room> listarRoomsPorUsuario(@PathVariable Long userId) {
        return roomService.listarRoomsPorUsuario(userId);
    }

    // Enviar mensagem para um canal (room)
    @PostMapping("/rooms/{roomId}/mensagens")
    public ResponseEntity<MensagemResponseDTO> enviarMensagem(
            @PathVariable Long roomId,
            @RequestBody MensagemRequestDTO dto) {

        MensagemResponseDTO resposta = mensagemService.enviarParaCanal(
                dto.getUserId(),
                roomId,
                dto.getConteudo()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    // Listar mensagens de um canal (ordenadas por data, mais recentes primeiro)
    @GetMapping("/rooms/{roomId}/mensagens")
    public ResponseEntity<List<Mensagem>> listarMensagens(
            @PathVariable Long roomId) {

        List<Mensagem> mensagens = mensagemService.listarPorChat(roomId);
        return ResponseEntity.ok(mensagens);
    }

    // Editar mensagem (opcional)
    @PutMapping("/mensagens/{mensagemId}")
    public ResponseEntity<MensagemResponseDTO> editarMensagem(
            @PathVariable Long mensagemId,
            @RequestBody MensagemRequestDTO dto) {

        MensagemResponseDTO atualizada = mensagemService.editarMensagem(
                mensagemId,
                dto.getConteudo()
        );

        return ResponseEntity.ok(atualizada);
    }

    // Deletar mensagem (opcional)
    @DeleteMapping("/mensagens/{mensagemId}")
    public ResponseEntity<Void> deletarMensagem(@PathVariable Long mensagemId) {
        mensagemService.deletarMensagem(mensagemId);
        return ResponseEntity.noContent().build();
    }
}
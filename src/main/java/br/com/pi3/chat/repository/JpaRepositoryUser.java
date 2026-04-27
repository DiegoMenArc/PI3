package br.com.pi3.chat.repository;

import br.com.pi3.chat.model.rooms.Room;
import br.com.pi3.chat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaRepositoryUser extends JpaRepository {

    User userPorId(Long id);
    List<User> findAllUsers();
    List<Room> findAllRoomsByUser(Long user_id);
    List<User> findAllUsersByRoom(Long room_id);
    User saveUser(User u);
    Boolean deleteUser(Long id);
    User editUser(Long id, User novo);

}

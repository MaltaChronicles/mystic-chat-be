package it.mystic.chat.repo;

import it.mystic.chat.model.dto.Player;
import it.mystic.chat.model.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface PlayerRepo extends JpaRepository<Player, Long> {
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    List<Player> findByUsernameIgnoreCaseLike(String username);
}

package it.mystic.chat.repo;

import it.mystic.chat.model.dto.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepo extends JpaRepository<Character, Long> {
    boolean existsByName(String name);
}

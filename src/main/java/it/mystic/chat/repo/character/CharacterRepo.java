package it.mystic.chat.repo.character;

import it.mystic.chat.model.dto.character.Character;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharacterRepo extends JpaRepository<Character, Long> {
    boolean existsByName(String name);

    List<Character> findByNameIgnoreCaseLike(String name);
}

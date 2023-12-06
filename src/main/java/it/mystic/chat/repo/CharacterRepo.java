package it.mystic.chat.repo;

import it.mystic.chat.model.dto.Character;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharacterRepo extends JpaRepository<Character, Long> {
    boolean existsByName(String name);

    List<Character> findByNameIgnoreCaseLike(String name);
}

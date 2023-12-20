package it.mystic.chat.repo.character;

import it.mystic.chat.model.dto.character.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepo extends JpaRepository<Character, Long> {
    boolean existsByName(String name);

    List<Character> findByNameIgnoreCaseLike(String name);
}

package it.mystic.chat.repo;

import it.mystic.chat.model.dto.CharacterDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepo extends JpaRepository<CharacterDto, Long> {
}

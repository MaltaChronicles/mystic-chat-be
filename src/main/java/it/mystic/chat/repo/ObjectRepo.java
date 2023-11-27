package it.mystic.chat.repo;

import it.mystic.chat.model.dto.ObjectDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObjectRepo extends JpaRepository<ObjectDto, Long> {
}

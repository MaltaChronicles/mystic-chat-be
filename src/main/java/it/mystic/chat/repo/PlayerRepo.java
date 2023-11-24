package it.mystic.chat.repo;

import it.mystic.chat.model.dto.PlayerDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepo extends JpaRepository<PlayerDto, Long> {
}

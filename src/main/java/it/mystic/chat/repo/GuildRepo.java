package it.mystic.chat.repo;

import it.mystic.chat.model.dto.Guild;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuildRepo extends JpaRepository<Guild, Long> {
}

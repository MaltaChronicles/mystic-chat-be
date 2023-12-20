package it.mystic.chat.repo;

import it.mystic.chat.model.dto.Guild;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuildRepo extends JpaRepository<Guild, Long> {
}

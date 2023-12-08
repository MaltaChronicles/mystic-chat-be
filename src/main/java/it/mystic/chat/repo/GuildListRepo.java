package it.mystic.chat.repo;

import it.mystic.chat.model.dto.GuildList;
import it.mystic.chat.model.dto.pk.GuildListPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuildListRepo extends JpaRepository<GuildList, GuildListPk> {
}

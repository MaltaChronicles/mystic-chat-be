package it.mystic.chat.repo.player;

import it.mystic.chat.model.dto.pk.PlayerChatPk;
import it.mystic.chat.model.dto.player.PlayerChat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerChatRepo extends JpaRepository<PlayerChat, PlayerChatPk> {
}

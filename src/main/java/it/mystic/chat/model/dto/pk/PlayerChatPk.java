package it.mystic.chat.model.dto.pk;

import it.mystic.chat.model.dto.chat.Chat;
import it.mystic.chat.model.dto.player.Player;
import it.mystic.chat.model.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerChatPk implements Serializable {
    @ManyToOne
    @JoinColumn(name = "player_id")
    Player player;
    @ManyToOne
    @JoinColumn(name = "chat_id")
    Chat chat;
}

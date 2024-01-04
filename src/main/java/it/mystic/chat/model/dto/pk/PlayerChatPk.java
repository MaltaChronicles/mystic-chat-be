package it.mystic.chat.model.dto.pk;

import it.mystic.chat.model.dto.chat.Chat;
import it.mystic.chat.model.dto.player.Player;
import jakarta.persistence.CascadeType;
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
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "player_id")
    Player player;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "chat_id")
    Chat chat;
}

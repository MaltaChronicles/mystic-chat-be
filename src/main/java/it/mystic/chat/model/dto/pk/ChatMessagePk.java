package it.mystic.chat.model.dto.pk;

import it.mystic.chat.model.dto.chat.Chat;
import it.mystic.chat.model.dto.player.Player;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessagePk implements Serializable {
    @ManyToOne
    @JoinColumn(name = "player_id")
    Player player;
    @ManyToOne
    @JoinColumn(name = "chat_id")
    Chat chat;
    @Column
    Date date;
}

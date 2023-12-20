package it.mystic.chat.model.dto.chat;

import it.mystic.chat.model.dto.pk.ChatMessagePk;
import it.mystic.chat.model.dto.player.PlayerChat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringExclude;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class ChatMessage {
    @EmbeddedId
    ChatMessagePk id;
    @Column(length = 65000)
    String body;
}

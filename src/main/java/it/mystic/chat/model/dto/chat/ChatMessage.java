package it.mystic.chat.model.dto.chat;

import it.mystic.chat.model.dto.pk.ChatMessagePk;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

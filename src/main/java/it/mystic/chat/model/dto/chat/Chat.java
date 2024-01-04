package it.mystic.chat.model.dto.chat;

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
public class Chat {
    @Id
    @Column(updatable = false)
    String chatId;//UUID
    @Column(nullable = false)
    String title;

    @OneToMany(mappedBy = "id.chat", cascade = CascadeType.ALL)
    @ToStringExclude
    List<PlayerChat> members;

    @OneToMany(mappedBy = "id.chat", cascade = CascadeType.ALL)
    @ToStringExclude
    List<ChatMessage> messages;
}

package it.mystic.chat.model.dto.player;

import it.mystic.chat.model.dto.pk.PlayerChatPk;
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
public class PlayerChat {

    @EmbeddedId
    PlayerChatPk id;

    @Column(nullable = false)
    Boolean isAdmin;
}

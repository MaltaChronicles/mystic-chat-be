package it.mystic.chat.security.model;

import it.mystic.chat.model.dto.player.Player;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "security_token")
public class Token {
    @ManyToOne
    @JoinColumn(name = "playerId")
    Player playerId;
    @Id
    String token;
}

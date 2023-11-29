package it.mystic.chat.security;

import it.mystic.chat.model.dto.Player;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "config_token")
public class Token {
    @ManyToOne
    @JoinColumn(name = "playerId")
    Player playerId;
    @Id
    String token;
}

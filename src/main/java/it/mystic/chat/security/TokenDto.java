package it.mystic.chat.security;

import it.mystic.chat.model.dto.PlayerDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "config_token")
public class TokenDto {
    @ManyToOne
    @JoinColumn(name = "playerId")
    PlayerDto playerId;
    @Id
    String token;
}

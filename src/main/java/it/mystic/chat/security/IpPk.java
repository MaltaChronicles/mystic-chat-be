package it.mystic.chat.security;

import it.mystic.chat.model.dto.Player;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IpPk {
    @ManyToOne
    @JoinColumn(name = "playerId")
    Player playerId;
    Integer Ip;
}

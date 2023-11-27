package it.mystic.chat.security;

import it.mystic.chat.model.dto.PlayerDto;
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
    PlayerDto playerId;
    Integer Ip;
}

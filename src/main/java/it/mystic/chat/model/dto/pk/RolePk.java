package it.mystic.chat.model.dto.pk;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.mystic.chat.model.dto.PlayerDto;
import it.mystic.chat.model.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RolePk implements Serializable {
    @ManyToOne
    @JoinColumn(name = "player_id")
    @JsonIgnore
    PlayerDto player;
    @Column
    Role role;

    public RolePk(Long playerId, Role role) {
        PlayerDto playerDto = new PlayerDto();
        playerDto.setPlayerId(playerId);
        this.player = playerDto;
        this.role = role;
    }
}

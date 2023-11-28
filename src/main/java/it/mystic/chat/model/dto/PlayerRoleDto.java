package it.mystic.chat.model.dto;

import it.mystic.chat.model.dto.pk.PlayerRolePk;
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
@Table(name = "player_role")
public class PlayerRoleDto {
    @EmbeddedId
    PlayerRolePk id;
    Boolean isBoss;
}

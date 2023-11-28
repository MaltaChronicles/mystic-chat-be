package it.mystic.chat.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PlayerRoleDto {
    @EmbeddedId
    PlayerRolePk id;
    Boolean isBoss;
}

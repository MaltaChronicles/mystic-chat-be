package it.mystic.chat.model.dto;

import it.mystic.chat.model.dto.pk.RolePk;
import it.mystic.chat.model.enums.Role;
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
@Table(name = "Role")
public class RoleDto {
    @EmbeddedId
    RolePk id;
    Boolean isBoss;

    public RoleDto(Long playerId, Role role) {
        this.id = new RolePk(playerId, role);
        this.isBoss = false;
    }
}

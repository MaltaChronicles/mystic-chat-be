package it.mystic.chat.model.response;

import it.mystic.chat.model.dto.Location;
import it.mystic.chat.model.dto.Player;
import it.mystic.chat.model.dto.pk.PlayerRolePk;
import it.mystic.chat.model.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public record PlayerRoleResponse (
        Role role,
        Boolean isBoss
){}

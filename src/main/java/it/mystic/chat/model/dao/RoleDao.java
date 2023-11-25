package it.mystic.chat.model.dao;

import it.mystic.chat.exception.ValidationException;
import it.mystic.chat.model.enums.Role;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDao {
    @NotNull
    Long playerId;
    @NotNull
    Role role;
    Boolean isBoss;

    public void setRole(Role role) {
        if (role != null && Arrays.asList(Role.values()).contains(role))
            this.role = role;
        else
            throw new ValidationException("role", "Ruolo non valido");
    }
}

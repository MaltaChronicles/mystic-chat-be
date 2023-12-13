package it.mystic.chat.repo.player;

import it.mystic.chat.model.dto.player.PlayerRole;
import it.mystic.chat.model.dto.pk.PlayerRolePk;
import it.mystic.chat.model.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRoleRepo extends JpaRepository<PlayerRole, PlayerRolePk> {
    List<PlayerRole> findByIdRole(Role role);
}

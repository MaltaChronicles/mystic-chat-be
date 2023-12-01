package it.mystic.chat.repo;

import it.mystic.chat.model.dto.PlayerRole;
import it.mystic.chat.model.dto.pk.PlayerRolePk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRoleRepo extends JpaRepository<PlayerRole, PlayerRolePk> {
}

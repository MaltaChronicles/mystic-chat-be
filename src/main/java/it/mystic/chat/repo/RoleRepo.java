package it.mystic.chat.repo;

import it.mystic.chat.model.dto.RoleDto;
import it.mystic.chat.model.dto.pk.RolePk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<RoleDto, RolePk> {
}

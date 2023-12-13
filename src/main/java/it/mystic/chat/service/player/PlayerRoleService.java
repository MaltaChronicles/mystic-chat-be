package it.mystic.chat.service.player;

import it.mystic.chat.mapper.PlayerMapper;
import it.mystic.chat.model.dto.player.Player;
import it.mystic.chat.model.dto.player.PlayerRole;
import it.mystic.chat.model.dto.pk.PlayerRolePk;
import it.mystic.chat.model.enums.Role;
import it.mystic.chat.model.response.EssentialData;
import it.mystic.chat.repo.player.PlayerRepo;
import it.mystic.chat.repo.player.PlayerRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerRoleService {

    @Autowired
    private PlayerRoleRepo playerRoleRepo;
    @Autowired
    private PlayerRepo playerRepo;

    @Autowired
    private PlayerMapper playerMapper;

    public void removeRole(Long playerId, Role role) {
        playerRoleRepo.deleteById(getPk(playerId, role));
    }

    public PlayerRole addRole(Long playerId, Role role) {

        PlayerRole playerRole = new PlayerRole(getPk(playerId, role), false);
        return playerRoleRepo.save(playerRole);
    }

    public void changeBoss(Long playerId, Role role) {
        PlayerRole playerRole = playerRoleRepo.getReferenceById(getPk(playerId, role));
        playerRole.setIsBoss(!playerRole.getIsBoss());
        playerRoleRepo.save(playerRole);
    }

    private PlayerRolePk getPk(Long playerId, Role role) {
        Player player = playerRepo.getReferenceById(playerId);
        return new PlayerRolePk(player, role);
    }

    public List<EssentialData> getPlayerByRole(Role role) {
        return playerMapper.roleListToMap(playerRoleRepo.findByIdRole(role));
    }
}

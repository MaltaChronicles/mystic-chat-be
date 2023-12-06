package it.mystic.chat.service;

import it.mystic.chat.model.dto.Player;
import it.mystic.chat.model.dto.PlayerRole;
import it.mystic.chat.model.dto.pk.PlayerRolePk;
import it.mystic.chat.model.enums.Role;
import it.mystic.chat.repo.PlayerRepo;
import it.mystic.chat.repo.PlayerRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PlayerRoleService {

    @Autowired
    private PlayerRoleRepo playerRoleRepo;
    @Autowired
    private PlayerRepo playerRepo;

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

    private PlayerRolePk getPk(Long playerId, Role role){
        Player player = playerRepo.getReferenceById(playerId);
        return new PlayerRolePk(player, role);
    }

    public Map<Long, String> getPlayerByRole(Role role) {
        return playerRoleRepo.findAll().stream()
                .filter(playerRole -> {return playerRole.getId().getRole() == role;})
                .map(playerRole -> {return playerRole.getId().getPlayer();})
                .collect(Collectors.toMap(Player::getPlayerId, Player::getUsername));
    }
}

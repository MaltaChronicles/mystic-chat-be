package it.mystic.chat.mapper;


import it.mystic.chat.model.dao.PlayerDao;
import it.mystic.chat.model.dto.Character;
import it.mystic.chat.model.dto.Player;
import it.mystic.chat.model.dto.PlayerRole;
import it.mystic.chat.model.response.EssentialData;
import it.mystic.chat.model.response.MedalResponse;
import it.mystic.chat.model.response.PlayerResponse;
import it.mystic.chat.model.response.PlayerRoleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;


@Component
public class PlayerMapper {

    @Autowired
    private MedalMapper medalMapper;

    public Player daoToDto(PlayerDao playerDao) {
        return new Player(
                null,
                playerDao.getUsername(),
                playerDao.getPassword(),
                playerDao.getEmail(),
                new Date(),
                null,
                null,
                null,
                null,
                null, null, null,
                null,
                null,
                null
        );
    }

    public List<EssentialData> playerListToMap(List<Player> playerList) {
        return playerList.stream().map(character -> {
            return new EssentialData(character.getPlayerId(), character.getUsername());
        }).toList();
    }

    public List<EssentialData> roleListToMap(List<PlayerRole> playerRoleList) {
        return playerRoleList.stream().map(playerRole -> {
            return new EssentialData(playerRole.getId().getPlayer().getPlayerId(), playerRole.getId().getPlayer().getUsername());
        }).toList();
    }

    public PlayerResponse dtoToResponse(Player player) {
        return new  PlayerResponse(
                player.getPlayerId(),
                player.getUsername(),
                player.getDataIscrizione(),
                player.getUltimaAzione(),
                player.getUltimoAccesso(),
                player.getUltimaGiocata(),

                roleListToResponseList(player.getRoles()),

                new EssentialData(player.getCharacter1().getCharacterId(), player.getCharacter1().getName()),
                new EssentialData(player.getCharacter2().getCharacterId(), player.getCharacter2().getName()),
                new EssentialData(player.getCharacter3().getCharacterId(), player.getCharacter3().getName()),
                new EssentialData(player.getActiveCharacter().getCharacterId(), player.getActiveCharacter().getName()),

                new EssentialData(player.getLocation().getLocationId(), player.getLocation().getName()),

                medalMapper.medalListToResponseList(player.getMedals())
        );
    }

    private List<PlayerRoleResponse> roleListToResponseList(List<PlayerRole> playerRoleList) {
        return playerRoleList.stream().map(playerRole -> {
            return new PlayerRoleResponse(playerRole.getId().getRole(), playerRole.getIsBoss());
        }).toList();
    }

}

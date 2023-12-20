package it.mystic.chat.mapper;


import it.mystic.chat.model.dao.PlayerDao;
import it.mystic.chat.model.dto.character.Character;
import it.mystic.chat.model.dto.location.Location;
import it.mystic.chat.model.dto.player.Player;
import it.mystic.chat.model.dto.player.PlayerRole;
import it.mystic.chat.model.response.EssentialData;
import it.mystic.chat.model.response.player.PlayerResponse;
import it.mystic.chat.model.response.player.PlayerRoleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Objects;


@Component
public class PlayerMapper {

    @Autowired
    private MedalMapper medalMapper;

    public Player daoToDto(PlayerDao playerDao) {
        if (Objects.isNull(playerDao))
            return null;
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
                null,
                null, null
        );
    }

    public List<EssentialData> playerListToMap(List<Player> playerList) {
        if (Objects.isNull(playerList))
            return null;
        return playerList.stream().map(character -> {
            return new EssentialData(character.getPlayerId(), character.getUsername());
        }).toList();
    }

    public List<EssentialData> roleListToMap(List<PlayerRole> playerRoleList) {
        if (Objects.isNull(playerRoleList))
            return null;
        return playerRoleList.stream().map(playerRole -> {
            return new EssentialData(playerRole.getId().getPlayer().getPlayerId(), playerRole.getId().getPlayer().getUsername());
        }).toList();
    }

    public PlayerResponse dtoToResponse(Player player) {
        if (Objects.isNull(player))
            return null;
        return new PlayerResponse(
                player.getPlayerId(),
                player.getUsername(),
                player.getDataIscrizione(),
                player.getUltimaAzione(),
                player.getUltimoAccesso(),
                player.getUltimaGiocata(),

                roleListToResponseList(player.getRoles()),

                characterToEssentialData(player.getCharacter1()),
                characterToEssentialData(player.getCharacter2()),
                characterToEssentialData(player.getCharacter3()),
                characterToEssentialData(player.getActiveCharacter()),

                locationToEssentialData(player.getLocation()),

                medalMapper.medalListToResponseList(player.getMedals())
        );
    }

    private List<PlayerRoleResponse> roleListToResponseList(List<PlayerRole> playerRoleList) {
        if (Objects.isNull(playerRoleList))
            return null;
        return playerRoleList.stream().map(playerRole -> {
            return new PlayerRoleResponse(playerRole.getId().getRole(), playerRole.getIsBoss());
        }).toList();
    }

    private EssentialData characterToEssentialData(Character character) {
        if (Objects.isNull(character))
            return null;
        return new EssentialData(character.getCharacterId(), character.getName());
    }

    private EssentialData locationToEssentialData(Location location) {
        if (Objects.isNull(location))
            return null;
        return new EssentialData(location.getLocationId(), location.getName());
    }

}

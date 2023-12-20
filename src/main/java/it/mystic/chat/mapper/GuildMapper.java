package it.mystic.chat.mapper;

import it.mystic.chat.model.dao.GuildDao;
import it.mystic.chat.model.dto.Guild;
import it.mystic.chat.model.dto.character.CharacterGuild;
import it.mystic.chat.model.response.GuildResponse;
import it.mystic.chat.model.response.character.CharacterGuildResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class GuildMapper {
    @Value("${upload.dir}")
    private String uploadDir;

    public Guild daoToDto(GuildDao guildDao) {
        if (Objects.isNull(guildDao))
            return null;
        return new Guild(
                null,
                guildDao.name(),
                uploadDir + "img/guild/default.jpeg",
                guildDao.description(),
                null
        );
    }

    public GuildResponse guildToResponse(Guild guild) {
        if (Objects.isNull(guild))
            return null;
        return new GuildResponse(
                guild.getGuildId(),
                guild.getName(),
                guild.getImageUrl(),
                guild.getDescription(),
                guildersToResponse(guild.getGuilders())
        );
    }

    private List<CharacterGuildResponse> guildersToResponse(List<CharacterGuild> guilders) {
        if (Objects.isNull(guilders))
            return null;
        return guilders.stream().map(guildList -> {
            return new CharacterGuildResponse(
                    guildList.getCharacter().getCharacterId(),
                    guildList.getCharacter().getName(),
                    guildList.getRank()
            );
        }).toList();
    }
}

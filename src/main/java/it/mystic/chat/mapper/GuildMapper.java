package it.mystic.chat.mapper;

import it.mystic.chat.model.dao.GuildDao;
import it.mystic.chat.model.dto.Guild;
import it.mystic.chat.model.dto.GuildList;
import it.mystic.chat.model.response.GuildListResponse;
import it.mystic.chat.model.response.GuildResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class GuildMapper {
    @Value("${upload.dir}")
    private String uploadDir;

    public Guild daoToDto(GuildDao guildDao) {
        if(Objects.isNull(guildDao))
            return null;
        return new Guild(
                null,
                guildDao.getName(),
                uploadDir + "img/guild/default.jpeg",
                guildDao.getDescription(),
                null
        );
    }

    public GuildResponse guildToResponse(Guild guild) {
        if(Objects.isNull(guild))
            return null;
        return new GuildResponse(
                guild.getGuildId(),
                guild.getName(),
                guild.getImageUrl(),
                guild.getDescription(),
                guildersToResponse(guild.getGuilders())
        );
    }

    private List<GuildListResponse> guildersToResponse(List<GuildList> guilders) {
        if(Objects.isNull(guilders))
            return null;
        return guilders.stream().map(guildList -> {
            return new GuildListResponse(
                guildList.getId().getCharacter().getCharacterId(),
                    guildList.getId().getCharacter().getName(),
                    guildList.getRank()
            );
        }).toList();
    }
}

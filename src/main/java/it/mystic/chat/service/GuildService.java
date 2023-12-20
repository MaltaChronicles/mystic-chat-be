package it.mystic.chat.service;

import it.mystic.chat.mapper.GuildMapper;
import it.mystic.chat.model.dao.GuildDao;
import it.mystic.chat.model.dto.Guild;
import it.mystic.chat.model.dto.character.Character;
import it.mystic.chat.model.dto.character.CharacterGuild;
import it.mystic.chat.model.enums.GuildRank;
import it.mystic.chat.model.response.GuildResponse;
import it.mystic.chat.repo.GuildRepo;
import it.mystic.chat.repo.character.CharacterRepo;
import it.mystic.chat.util.MultipartFileConverter;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

@Service
public class GuildService {
    @Autowired
    private GuildRepo guildRepo;
    @Autowired
    private CharacterRepo characterRepo;

    @Autowired
    private GuildMapper guildMapper;
    @Autowired
    private MultipartFileConverter converter;

    public GuildResponse create(GuildDao guildDao) {
        Guild guild = guildMapper.daoToDto(guildDao);
        return guildMapper.guildToResponse(guildRepo.save(guild));
    }

    public void update(Long guildId, GuildDao guildDao) {
        Guild guild = guildRepo.getReferenceById(guildId);
        guild.setName(guildDao.getName());
        guild.setDescription(guildDao.getDescription());
        guildRepo.save(guild);
    }

    @SuppressWarnings("ConstantConditions")
    public void uploadImage(Long guildId, MultipartFile file) throws IOException {
        Guild guild = guildRepo.getReferenceById(guildId);
        Hibernate.initialize(guild);
        if (guild != null) {
            guild.setImageUrl(converter.saveMultipartFile(file, "guild", guildId, "jpeg"));
            guildRepo.save(guild);
        }
    }

    public GuildResponse getById(Long guildId) {
        return guildMapper.guildToResponse(guildRepo.getReferenceById(guildId));
    }

    public void delete(Long guildId) {
        guildRepo.deleteById(guildId);
    }

    public void addGuilder(Long guildId, Long characterId) {
        Guild guild = guildRepo.getReferenceById(guildId);
        Character character = characterRepo.getReferenceById(characterId);

        CharacterGuild characterGuild = new CharacterGuild(
                character,
                guild,
                GuildRank.Iniziato,
                new Date()
        );

        character.setGuild(characterGuild);
        characterRepo.save(character);
    }

    public void removeGuilder(Long characterId) {
        Character character = characterRepo.getReferenceById(characterId);

        CharacterGuild characterGuild = new CharacterGuild(
                character,
                null,
                null,
                new Date()
        );

        character.setGuild(characterGuild);
        characterRepo.save(character);
    }

    public void increaseRank(Long characterId) {
        Character character = characterRepo.getReferenceById(characterId);
        GuildRank next = GuildRank.values()[(character.getGuild().getRank().ordinal() + 1)];

        CharacterGuild characterGuild = character.getGuild();
        characterGuild.setRank(next);

        characterRepo.save(character);
    }

    public void decreaseRank(Long characterId) {
        Character character = characterRepo.getReferenceById(characterId);
        GuildRank previous = GuildRank.values()[(character.getGuild().getRank().ordinal() + 1)];

        CharacterGuild characterGuild = character.getGuild();
        characterGuild.setRank(previous);

        characterRepo.save(character);
    }
}

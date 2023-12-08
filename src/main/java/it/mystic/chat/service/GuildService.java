package it.mystic.chat.service;

import it.mystic.chat.mapper.GuildMapper;
import it.mystic.chat.model.dao.GuildDao;
import it.mystic.chat.model.dto.Ability;
import it.mystic.chat.model.dto.Character;
import it.mystic.chat.model.dto.Guild;
import it.mystic.chat.model.dto.GuildList;
import it.mystic.chat.model.dto.pk.GuildListPk;
import it.mystic.chat.model.enums.DiceValue;
import it.mystic.chat.model.enums.GuildRank;
import it.mystic.chat.model.response.GuildResponse;
import it.mystic.chat.repo.CharacterRepo;
import it.mystic.chat.repo.GuildListRepo;
import it.mystic.chat.repo.GuildRepo;
import it.mystic.chat.util.MultipartFileConverter;
import jakarta.persistence.Column;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.OptionalInt;
import java.util.stream.IntStream;

@Service
public class GuildService {
    @Autowired
    private GuildRepo guildRepo;
    @Autowired
    private CharacterRepo characterRepo;
    @Autowired
    private GuildListRepo guildListRepo;

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

        GuildList guildList = new GuildList(
                new GuildListPk(character, guild),
                GuildRank.Iniziato,
                new Date()
        );
        guildListRepo.save(guildList);
    }

    public void removeGuilder(Long characterId) {
        Character character = characterRepo.getReferenceById(characterId);
        Guild guild = character.getGuild().getId().getGuild();

        guildListRepo.deleteById(new GuildListPk(character, guild));
    }

    public void increaseRank(Long characterId) {
        Character character = characterRepo.getReferenceById(characterId);
        GuildRank next = GuildRank.values()[(character.getGuild().getRank().ordinal() + 1)];

        GuildList guildList = character.getGuild();
        guildList.setRank(next);

        characterRepo.save(character);
    }

    public void decreaseRank(Long characterId) {
        Character character = characterRepo.getReferenceById(characterId);
        GuildRank previous = GuildRank.values()[(character.getGuild().getRank().ordinal() + 1)];

        GuildList guildList = character.getGuild();
        guildList.setRank(previous);

        characterRepo.save(character);
    }
}

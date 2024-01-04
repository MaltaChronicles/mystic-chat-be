package it.mystic.chat.service.character;

import it.mystic.chat.exception.ValidationException;
import it.mystic.chat.mapper.CharacterMapper;
import it.mystic.chat.model.dao.character.CharacterDao;
import it.mystic.chat.model.dao.character.CharacterDescriptionDao;
import it.mystic.chat.model.dto.character.Character;
import it.mystic.chat.model.dto.character.*;
import it.mystic.chat.model.enums.*;
import it.mystic.chat.model.response.EssentialData;
import it.mystic.chat.model.response.character.CharacterResponse;
import it.mystic.chat.repo.character.CharacterRepo;
import it.mystic.chat.util.MultipartFileConverter;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static it.mystic.chat.util.CharacterStatsUtil.resetActualStats;
import static it.mystic.chat.util.CharacterStatsUtil.setRaceAffinity;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepo characterRepo;
    @Autowired
    private CharacterMapper characterMapper;
    @Autowired
    private MultipartFileConverter converter;

    public CharacterResponse create(CharacterDao characterDao) {
        nameNotUsed(characterDao.name());

        Character characterToSave = characterMapper.daoToDto(characterDao);
        Character character = characterRepo.save(characterToSave);
        createOtherTable(character);
        return characterMapper.dtoToResponse(character);
    }

    private void createOtherTable(Character character) {
        CharacterStats characterStats = new CharacterStats(character);
        setRaceAffinity(characterStats, character.getRace());
        resetActualStats(characterStats);
        character.setStatus(characterStats);

        character.setDescription(new CharacterDescription(character));
        character.setEquipment(new CharacterEquipment(character));
        character.setGuild(new CharacterGuild(character));
        characterRepo.save(character);
    }

    public CharacterResponse getById(Long characterId) {
        Character character = characterRepo.getReferenceById(characterId);
        character.setStatus(null);
        character.setEquipment(null);
        character.setInventory(null);
        return characterMapper.dtoToResponse(character);
    }

    public List<EssentialData> getAll() {
        return characterMapper.characterListToMap(characterRepo.findAll());
    }

    public List<EssentialData> getAllLikeName(String name) {
        name = "%" + name + "%";
        return characterMapper.characterListToMap(characterRepo.findByNameIgnoreCaseLike(name));
    }

    public void deleteById(Long characterId) {
        characterRepo.deleteById(characterId);
    }

    public void updateNameById(Long characterId, String name) {
        nameNotUsed(name);
        Character character = characterRepo.getReferenceById(characterId);
        character.setName(name);
        characterRepo.save(character);
    }

    public void updateIdentityById(Long characterId, String identity) {
        Character character = characterRepo.getReferenceById(characterId);
        character.setIdentity(identity);
        characterRepo.save(character);
    }

    public void updateOriginById(Long characterId, Origin origin) {
        Character character = characterRepo.getReferenceById(characterId);
        character.setOrigin(origin);
        characterRepo.save(character);
    }

    public void updateThemeById(Long characterId, Theme theme) {
        Character character = characterRepo.getReferenceById(characterId);
        character.setTheme(theme);
        characterRepo.save(character);
    }

    public void updateStandardOfLivingById(Long characterId, StandardOfLiving standardOfLiving) {
        Character character = characterRepo.getReferenceById(characterId);
        character.setStandardOfLiving(standardOfLiving);
        characterRepo.save(character);
    }

    public void updateJobById(Long characterId, Job job) {
        Character character = characterRepo.getReferenceById(characterId);
        character.setJob(job);
        characterRepo.save(character);
    }

    public void updateMasterNoteById(Long characterId, String masterNote) {
        Character character = characterRepo.getReferenceById(characterId);
        character.setMasterNote(masterNote);
        characterRepo.save(character);
    }

    public void updatePersonalNoteById(Long characterId, String personalNote) {
        Character character = characterRepo.getReferenceById(characterId);
        character.setPersonalNote(personalNote);
        characterRepo.save(character);
    }

    public void updateRumorsById(Long characterId, String rumors) {
        Character character = characterRepo.getReferenceById(characterId);
        character.setRumors(rumors);
        characterRepo.save(character);
    }

    public void updateRaceById(Long characterId, Race race) {
        Character character = characterRepo.getReferenceById(characterId);
        character.setRace(race);
        characterRepo.save(character);
    }

    public void updateDivinityById(Long characterId, Divinity divinity) {
        Character character = characterRepo.getReferenceById(characterId);
        character.setDivinity(divinity);
        characterRepo.save(character);
    }

    public void updateDescriptionById(Long characterId, CharacterDescriptionDao characterDescriptionDao) {
        Character character = characterRepo.getReferenceById(characterId);
        CharacterDescription characterDescription = characterMapper.descriptionDaoToDto(characterDescriptionDao, character);
        character.setDescription(characterDescription);
        characterRepo.save(character);
    }

    @SuppressWarnings("ConstantConditions")
    public void uploadImage(Long characterId, MultipartFile file) throws IOException {
        Character character = characterRepo.getReferenceById(characterId);
        Hibernate.initialize(character);
        if (character != null) {
            character.getDescription().setImageUrl(converter.saveMultipartFile(file, "character", characterId, "jpeg"));
            characterRepo.save(character);
        }
    }

    private void nameNotUsed(String name) {
        if (characterRepo.existsByName(name)) {
            throw new ValidationException("name", "nome già in uso");
        }
    }

    public String getPersonalNote(Long characterId) {
        return characterRepo.getReferenceById(characterId).getPersonalNote();
    }

}

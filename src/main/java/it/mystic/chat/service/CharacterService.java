package it.mystic.chat.service;

import it.mystic.chat.mapper.CharacterMapper;
import it.mystic.chat.model.dao.CharacterDao;
import it.mystic.chat.model.dao.CharacterDescriptionDao;
import it.mystic.chat.model.dto.CharacterDescription;
import it.mystic.chat.model.dto.Character;
import it.mystic.chat.model.dto.CharacterEquipment;
import it.mystic.chat.model.dto.CharacterStats;
import it.mystic.chat.model.enums.*;
import it.mystic.chat.repo.CharacterRepo;
import it.mystic.chat.util.BeanValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepo characterRepo;
    @Autowired
    private CharacterMapper characterMapper;
    @Autowired
    private BeanValidator validator;

    public Character create(CharacterDao characterDao) {
        validator.validate(characterDao);
        //TODO aggiungere validazione Nome

        Character character = characterMapper.daoTo(characterDao);
        character.setStandardOfLiving(StandardOfLiving.Nullo);

        character.setStatus(new CharacterStats(character));
        character.setEquipment(new CharacterEquipment(character));
        character.setDescription(new CharacterDescription(character));
        return characterRepo.save(character);
    }

    public Character getById(Long characterId) {
        Character character = characterRepo.getReferenceById(characterId);
        character.setStatus(null);
        character.setEquipment(null);
        character.setInventory(null);
        return character;
    }

    public List<Character> getAll() {
        return characterRepo.findAll();
    }

    public void deleteById(Long characterId) {
        characterRepo.deleteById(characterId);
    }

    public void updateNameById(Long characterId, String name) {
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

    public void updateDescriptionById(Long characterId, CharacterDescriptionDao characterDescriptionDao) {
        Character character = characterRepo.getReferenceById(characterId);
        CharacterDescription characterDescription = characterMapper.descriptionDaoToDescription(characterDescriptionDao, character);
        character.setDescription(characterDescription);
        characterRepo.save(character);
    }
}

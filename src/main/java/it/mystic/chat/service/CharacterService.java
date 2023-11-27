package it.mystic.chat.service;

import it.mystic.chat.mapper.CharacterMapper;
import it.mystic.chat.model.dao.CharacterDao;
import it.mystic.chat.model.dao.CharacterDescriptionDao;
import it.mystic.chat.model.dto.CharacterDescriptionDto;
import it.mystic.chat.model.dto.CharacterDto;
import it.mystic.chat.model.dto.CharacterEquipmentDto;
import it.mystic.chat.model.dto.CharacterStatsDto;
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

    public CharacterDto create(CharacterDao characterDao) {
        validator.validate(characterDao);
        //TODO aggiungere validazione Nome

        CharacterDto characterDto = characterMapper.daoToDto(characterDao);
        characterDto.setStandardOfLiving(StandardOfLiving.Nullo);

        characterDto.setStatus(new CharacterStatsDto(characterDto));
        characterDto.setEquipment(new CharacterEquipmentDto(characterDto));
        characterDto.setDescription(new CharacterDescriptionDto(characterDto));
        return characterRepo.save(characterDto);
    }

    public CharacterDto readById(Long characterId) {
        return characterRepo.getReferenceById(characterId);
    }

    public List<CharacterDto> readAll() {
        return characterRepo.findAll();
    }

    public void deleteById(Long characterId) {
        characterRepo.deleteById(characterId);
    }

    public void updateNameById(Long characterId, String name) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.setName(name);
        characterRepo.save(characterDto);
    }

    public void updateIdentityById(Long characterId, String identity) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.setIdentity(identity);
        characterRepo.save(characterDto);
    }

    public void updateOriginById(Long characterId, Origin origin) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.setOrigin(origin);
        characterRepo.save(characterDto);
    }

    public void updateThemeById(Long characterId, Theme theme) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.setTheme(theme);
        characterRepo.save(characterDto);
    }

    public void updateStandardOfLivingById(Long characterId, StandardOfLiving standardOfLiving) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.setStandardOfLiving(standardOfLiving);
        characterRepo.save(characterDto);
    }

    public void updateJobById(Long characterId, Job job) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.setJob(job);
        characterRepo.save(characterDto);
    }

    public void updateMasterNoteById(Long characterId, String masterNote) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.setMasterNote(masterNote);
        characterRepo.save(characterDto);
    }

    public void updatePersonalNoteById(Long characterId, String personalNote) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.setPersonalNote(personalNote);
        characterRepo.save(characterDto);
    }

    public void updateRumorsById(Long characterId, String rumors) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.setRumors(rumors);
        characterRepo.save(characterDto);
    }

    public void updateRaceById(Long characterId, Race race) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.setRace(race);
        characterRepo.save(characterDto);
    }

    public void updateDescriptionById(Long characterId, CharacterDescriptionDao characterDescriptionDao) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        CharacterDescriptionDto characterDescriptionDto = characterMapper.descriptionDaoToDescriptionDto(characterDescriptionDao, characterDto);
        characterDto.setDescription(characterDescriptionDto);
        characterRepo.save(characterDto);
    }
}

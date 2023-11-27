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

    public CharacterDto updateNameById(Long characterId, String name) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.setName(name);
        return characterRepo.save(characterDto);
    }

    public CharacterDto updateIdentityById(Long characterId, String identity) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.setIdentity(identity);
        return characterRepo.save(characterDto);
    }

    public CharacterDto updateOriginById(Long characterId, Origin origin) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.setOrigin(origin);
        return characterRepo.save(characterDto);
    }

    public CharacterDto updateThemeById(Long characterId, Theme theme) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.setTheme(theme);
        return characterRepo.save(characterDto);
    }

    public CharacterDto updateStandardOfLivingById(Long characterId, StandardOfLiving standardOfLiving) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.setStandardOfLiving(standardOfLiving);
        return characterRepo.save(characterDto);
    }

    public CharacterDto updateJobById(Long characterId, Job job) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.setJob(job);
        return characterRepo.save(characterDto);
    }

    public CharacterDto updateMasterNoteById(Long characterId, String masterNote) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.setMasterNote(masterNote);
        return characterRepo.save(characterDto);
    }

    public CharacterDto updatePersonalNoteById(Long characterId, String personalNote) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.setPersonalNote(personalNote);
        return characterRepo.save(characterDto);
    }

    public CharacterDto updateRumorsById(Long characterId, String rumors) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.setRumors(rumors);
        return characterRepo.save(characterDto);
    }

    public CharacterDto updateRaceById(Long characterId, Race race) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.setRace(race);
        return characterRepo.save(characterDto);
    }

    public CharacterDto updateDescriptionById(Long characterId, CharacterDescriptionDao characterDescriptionDao) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        CharacterDescriptionDto characterDescriptionDto = characterMapper.descriptionDaoToDescriptionDto(characterDescriptionDao, characterDto);
        characterDto.setDescription(characterDescriptionDto);
        return characterRepo.save(characterDto);
    }
}

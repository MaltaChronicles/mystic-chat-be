package it.mystic.chat.service;

import it.mystic.chat.mapper.CharacterMapper;
import it.mystic.chat.model.dao.CharacterDao;
import it.mystic.chat.model.dto.CharacterDescriptionDto;
import it.mystic.chat.model.dto.CharacterDto;
import it.mystic.chat.model.dto.CharacterEquipmentDto;
import it.mystic.chat.model.dto.CharacterStatsDto;
import it.mystic.chat.model.enums.StandardOfLiving;
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

    public CharacterDto create(CharacterDao characterDao){
        validator.validate(characterDao);

        CharacterDto characterDto =  characterMapper.daoToDto(characterDao);
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
}

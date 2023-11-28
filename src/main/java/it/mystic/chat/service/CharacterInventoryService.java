package it.mystic.chat.service;

import it.mystic.chat.model.dto.CharacterDto;
import it.mystic.chat.model.dto.CharacterInventoryDto;
import it.mystic.chat.model.dto.ObjectDto;
import it.mystic.chat.model.dto.pk.CharacterInventoryPk;
import it.mystic.chat.repo.CharacterInventoryRepo;
import it.mystic.chat.repo.CharacterRepo;
import it.mystic.chat.repo.ObjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterInventoryService {

    @Autowired
    private CharacterInventoryRepo characterInventoryRepo;
    @Autowired
    private CharacterRepo characterRepo;
    @Autowired
    private ObjectRepo objectRepo;

    public void equipObject(Long characterId, Long objectId){
        CharacterInventoryDto characterInventoryDto = getReferenceByCharacterIdAndObjectId(characterId, objectId);
        characterInventoryDto.setIsEquip(true);
        characterInventoryRepo.save(characterInventoryDto);
    }

    public void unequipObject(Long characterId, Long objectId){
        CharacterInventoryDto characterInventoryDto = getReferenceByCharacterIdAndObjectId(characterId, objectId);
        characterInventoryDto.setIsEquip(false);
        characterInventoryRepo.save(characterInventoryDto);
    }

    public void addObject(Long characterId, Long objectId){
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        ObjectDto objectDto = objectRepo.getReferenceById(objectId);
        CharacterInventoryDto characterInventoryDto = new CharacterInventoryDto();
        characterInventoryDto.setId(new CharacterInventoryPk(characterDto, objectDto));
        characterInventoryRepo.save(characterInventoryDto);
    }

    public void removeObject(Long characterId, Long objectId) {
        CharacterInventoryDto characterInventoryDto = getReferenceByCharacterIdAndObjectId(characterId, objectId);
        characterInventoryRepo.delete(characterInventoryDto);
    }

    public List<CharacterInventoryDto> getAllByCharacterId(Long characterId) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        return characterDto.getInventory();
    }

    private CharacterInventoryDto getReferenceByCharacterIdAndObjectId(Long characterId, Long objectId){
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        ObjectDto objectDto = objectRepo.getReferenceById(objectId);
        return characterInventoryRepo.getReferenceById(new CharacterInventoryPk(characterDto,objectDto));
    }
}
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

@Service
public class CharacterInventoryService {

    @Autowired
    private CharacterInventoryRepo characterInventoryRepo;
    @Autowired
    private CharacterRepo characterRepo;
    @Autowired
    private ObjectRepo objectRepo;

    public void equipObject(Long characterId, Long objectId){
        CharacterInventoryDto characterInventoryDto = characterInventoryRepo.getReferenceByCharacterIdAndObjectId(characterId, objectId);
        characterInventoryDto.setIsEquip(true);
        characterInventoryRepo.save(characterInventoryDto);
    }

    public void unequipObject(Long characterId, Long objectId){
        CharacterInventoryDto characterInventoryDto = characterInventoryRepo.getReferenceByCharacterIdAndObjectId(characterId, objectId);
        characterInventoryDto.setIsEquip(false);
        characterInventoryRepo.save(characterInventoryDto);
    }
}

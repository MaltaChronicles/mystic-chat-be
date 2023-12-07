package it.mystic.chat.service;

import it.mystic.chat.mapper.CharacterMapper;
import it.mystic.chat.model.dto.Character;
import it.mystic.chat.model.dto.CharacterInventory;
import it.mystic.chat.model.dto.Object;
import it.mystic.chat.model.dto.pk.CharacterInventoryPk;
import it.mystic.chat.model.response.CharacterInventoryResponse;
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
    @Autowired
    private CharacterMapper characterMapper;

    public void equipObject(Long characterId, Long objectId) {
        CharacterInventory characterInventory = getReferenceByCharacterIdAndObjectId(characterId, objectId);
        characterInventory.setIsEquip(true);
        characterInventoryRepo.save(characterInventory);
    }

    public void unequipObject(Long characterId, Long objectId) {
        CharacterInventory characterInventory = getReferenceByCharacterIdAndObjectId(characterId, objectId);
        characterInventory.setIsEquip(false);
        characterInventoryRepo.save(characterInventory);
    }

    public void addObject(Long characterId, Long objectId) {
        Character character = characterRepo.getReferenceById(characterId);
        Object object = objectRepo.getReferenceById(objectId);
        CharacterInventory characterInventory = new CharacterInventory();
        characterInventory.setId(new CharacterInventoryPk(character, object));
        characterInventoryRepo.save(characterInventory);
    }

    public void removeObject(Long characterId, Long objectId) {
        CharacterInventory characterInventory = getReferenceByCharacterIdAndObjectId(characterId, objectId);
        characterInventoryRepo.delete(characterInventory);
    }

    public List<CharacterInventoryResponse> getAllByCharacterId(Long characterId) {
        Character character = characterRepo.getReferenceById(characterId);
        return characterMapper.inventoryToInventoryResponse(character.getInventory());
    }

    private CharacterInventory getReferenceByCharacterIdAndObjectId(Long characterId, Long objectId) {
        Character character = characterRepo.getReferenceById(characterId);
        Object object = objectRepo.getReferenceById(objectId);
        return characterInventoryRepo.getReferenceById(new CharacterInventoryPk(character, object));
    }
}

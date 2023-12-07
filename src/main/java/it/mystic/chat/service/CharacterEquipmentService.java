package it.mystic.chat.service;

import it.mystic.chat.exception.GenericException;
import it.mystic.chat.mapper.CharacterMapper;
import it.mystic.chat.model.dto.Character;
import it.mystic.chat.model.dto.CharacterEquipment;
import it.mystic.chat.model.dto.Object;
import it.mystic.chat.model.enums.RangeType;
import it.mystic.chat.model.response.CharacterEquipmentResponse;
import it.mystic.chat.repo.CharacterRepo;
import it.mystic.chat.repo.ObjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterEquipmentService {
    @Autowired
    private CharacterRepo characterRepo;
    @Autowired
    private ObjectRepo objectRepo;

    @Autowired
    private CharacterInventoryService characterInventoryService;

    @Autowired
    private CharacterMapper characterMapper;


    //TODO update delle stats IN e OUT

    public void equipRightHand(Long characterId, Long objectId) throws GenericException {
        Character character = characterRepo.getReferenceById(characterId);
        Object object = objectRepo.getReferenceById(objectId);
        if (object.getIsMartial() && (
                object.getRangeType().equals(RangeType.Mischia) && !character.getStatus().getMartialMeleeWeapons() ||
                        object.getRangeType().equals(RangeType.Distanza) && !character.getStatus().getMartialDistanceWeapons()))
            throw new GenericException("Non puoi equipaggaire questa arma!");

        if (character.getEquipment().getRightHand() != null && character.getEquipment().getLeftHand() == null) {
            equipLeftHand(characterId, objectId);
        } else {
            if (character.getEquipment().getRightHand() != null)
                characterInventoryService.unequipObject(characterId, character.getEquipment().getRightHand().getObjectId());
            character.getEquipment().setRightHand(object);
            characterInventoryService.equipObject(characterId, character.getEquipment().getRightHand().getObjectId());
            characterRepo.save(character);
        }
    }

    public void unequipRightHand(Long characterId) {
        Character character = characterRepo.getReferenceById(characterId);
        characterInventoryService.unequipObject(characterId, character.getEquipment().getRightHand().getObjectId());
        character.getEquipment().setRightHand(null);
        characterRepo.save(character);
    }

    public void equipLeftHand(Long characterId, Long objectId) throws GenericException {
        Character character = characterRepo.getReferenceById(characterId);
        Object object = objectRepo.getReferenceById(objectId);
        if (object.getIsMartial()) {
            if (object.getRangeType().equals(RangeType.Mischia) && !character.getStatus().getMartialMeleeWeapons() ||
                    object.getRangeType().equals(RangeType.Distanza) && !character.getStatus().getMartialDistanceWeapons())
                throw new GenericException("Non puoi equipaggaire questa arma!");
            else if (!character.getStatus().getMartialShields())
                throw new GenericException("Non puoi equipaggaire questo scudo!");
        }
        if (character.getEquipment().getLeftHand() != null)
            characterInventoryService.unequipObject(characterId, character.getEquipment().getLeftHand().getObjectId());
        character.getEquipment().setLeftHand(object);
        characterInventoryService.equipObject(characterId, character.getEquipment().getLeftHand().getObjectId());
        characterRepo.save(character);
    }

    public void unequipLeftHand(Long characterId) {
        Character character = characterRepo.getReferenceById(characterId);
        characterInventoryService.unequipObject(characterId, character.getEquipment().getLeftHand().getObjectId());
        character.getEquipment().setLeftHand(null);
        characterRepo.save(character);
    }

    public void equipDress(Long characterId, Long objectId) throws GenericException {
        Character character = characterRepo.getReferenceById(characterId);
        Object object = objectRepo.getReferenceById(objectId);
        if (object.getIsMartial() && !character.getStatus().getMartialArmors()) {
            throw new GenericException("Non puoi equipaggaire questa armatura!");
        }
        if (character.getEquipment().getDress() != null)
            characterInventoryService.unequipObject(characterId, character.getEquipment().getDress().getObjectId());
        character.getEquipment().setDress(object);
        characterInventoryService.equipObject(characterId, character.getEquipment().getDress().getObjectId());
        characterRepo.save(character);
    }

    public void unequipDress(Long characterId) {
        Character character = characterRepo.getReferenceById(characterId);
        characterInventoryService.unequipObject(characterId, character.getEquipment().getDress().getObjectId());
        character.getEquipment().setDress(null);
        characterRepo.save(character);
    }

    public void equipAccessory(Long characterId, Long objectId) {
        Character character = characterRepo.getReferenceById(characterId);
        Object object = objectRepo.getReferenceById(objectId);
        if (character.getEquipment().getAccessory() != null)
            characterInventoryService.unequipObject(characterId, character.getEquipment().getAccessory().getObjectId());
        character.getEquipment().setAccessory(object);
        characterInventoryService.equipObject(characterId, character.getEquipment().getAccessory().getObjectId());
        characterRepo.save(character);
    }

    public void unequipAccessory(Long characterId) {
        Character character = characterRepo.getReferenceById(characterId);
        characterInventoryService.unequipObject(characterId, character.getEquipment().getAccessory().getObjectId());
        character.getEquipment().setAccessory(null);
        characterRepo.save(character);
    }

    public void equipPet(Long characterId, Long objectId) {
        Character character = characterRepo.getReferenceById(characterId);
        Object object = objectRepo.getReferenceById(objectId);
        if (character.getEquipment().getPet() != null)
            characterInventoryService.unequipObject(characterId, character.getEquipment().getPet().getObjectId());
        character.getEquipment().setPet(object);
        characterInventoryService.equipObject(characterId, character.getEquipment().getPet().getObjectId());
        characterRepo.save(character);
    }

    public void unequipPet(Long characterId) {
        Character character = characterRepo.getReferenceById(characterId);
        characterInventoryService.unequipObject(characterId, character.getEquipment().getPet().getObjectId());
        character.getEquipment().setPet(null);
        characterRepo.save(character);
    }

    public void equipMount(Long characterId, Long objectId) {
        Character character = characterRepo.getReferenceById(characterId);
        Object object = objectRepo.getReferenceById(objectId);
        if (character.getEquipment().getMount() != null)
            characterInventoryService.unequipObject(characterId, character.getEquipment().getMount().getObjectId());
        character.getEquipment().setMount(object);
        characterInventoryService.equipObject(characterId, character.getEquipment().getMount().getObjectId());
        characterRepo.save(character);
    }

    public void unequipMount(Long characterId) {
        Character character = characterRepo.getReferenceById(characterId);
        characterInventoryService.unequipObject(characterId, character.getEquipment().getMount().getObjectId());
        character.getEquipment().setMount(null);
        characterRepo.save(character);
    }

    public CharacterEquipmentResponse getById(Long characterId) {
        return characterMapper.equipmentToEquipmentResponse(characterRepo.getReferenceById(characterId).getEquipment());
    }
}

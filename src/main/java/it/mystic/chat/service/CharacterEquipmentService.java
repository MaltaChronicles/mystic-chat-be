package it.mystic.chat.service;

import it.mystic.chat.exception.GenericException;
import it.mystic.chat.model.dto.CharacterDto;
import it.mystic.chat.model.dto.CharacterEquipmentDto;
import it.mystic.chat.model.dto.ObjectDto;
import it.mystic.chat.model.enums.RangeType;
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


    //TODO update delle stats IN e OUT

    public void equipRightHand(Long characterId, Long objectId) throws GenericException {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        ObjectDto objectDto = objectRepo.getReferenceById(objectId);
        if(objectDto.getIsMartial() && (
                objectDto.getRangeType().equals(RangeType.Mischia) && !characterDto.getStatus().getMartialMeleeWeapons() ||
                objectDto.getRangeType().equals(RangeType.Distanza) && !characterDto.getStatus().getMartialDistanceWeapons()))
            throw new GenericException("Non puoi equipaggaire questa arma!");

        if(characterDto.getEquipment().getRightHand()!=null && characterDto.getEquipment().getLeftHand()==null){
            equipLeftHand(characterId, objectId);
        }
        else {
            if(characterDto.getEquipment().getRightHand()!=null)
                characterInventoryService.unequipObject(characterId, characterDto.getEquipment().getRightHand().getObjectId());
            characterDto.getEquipment().setRightHand(objectDto);
            characterInventoryService.equipObject(characterId, characterDto.getEquipment().getRightHand().getObjectId());
            characterRepo.save(characterDto);
        }
    }

    public void unequipRightHand(Long characterId) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterInventoryService.unequipObject(characterId, characterDto.getEquipment().getRightHand().getObjectId());
        characterDto.getEquipment().setRightHand(null);
        characterRepo.save(characterDto);
    }

    public void equipLeftHand(Long characterId, Long objectId) throws GenericException {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        ObjectDto objectDto = objectRepo.getReferenceById(objectId);
        if(objectDto.getIsMartial()) {
            if(objectDto.getRangeType().equals(RangeType.Mischia) && !characterDto.getStatus().getMartialMeleeWeapons() ||
                    objectDto.getRangeType().equals(RangeType.Distanza) && !characterDto.getStatus().getMartialDistanceWeapons())
                throw new GenericException("Non puoi equipaggaire questa arma!");
            else if (!characterDto.getStatus().getMartialShields())
                    throw new GenericException("Non puoi equipaggaire questo scudo!");
        }
        if(characterDto.getEquipment().getLeftHand()!=null)
            characterInventoryService.unequipObject(characterId, characterDto.getEquipment().getLeftHand().getObjectId());
        characterDto.getEquipment().setLeftHand(objectDto);
        characterInventoryService.equipObject(characterId, characterDto.getEquipment().getLeftHand().getObjectId());
        characterRepo.save(characterDto);
    }

    public void unequipLeftHand(Long characterId) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterInventoryService.unequipObject(characterId, characterDto.getEquipment().getLeftHand().getObjectId());
        characterDto.getEquipment().setLeftHand(null);
        characterRepo.save(characterDto);
    }

    public void equipDress(Long characterId, Long objectId) throws GenericException {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        ObjectDto objectDto = objectRepo.getReferenceById(objectId);
        if(objectDto.getIsMartial() && !characterDto.getStatus().getMartialArmors()) {
            throw new GenericException("Non puoi equipaggaire questa armatura!");
        }
        if(characterDto.getEquipment().getDress()!=null)
            characterInventoryService.unequipObject(characterId, characterDto.getEquipment().getDress().getObjectId());
        characterDto.getEquipment().setDress(objectDto);
        characterInventoryService.equipObject(characterId, characterDto.getEquipment().getDress().getObjectId());
        characterRepo.save(characterDto);
    }

    public void unequipDress(Long characterId) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterInventoryService.unequipObject(characterId, characterDto.getEquipment().getDress().getObjectId());
        characterDto.getEquipment().setDress(null);
        characterRepo.save(characterDto);
    }

    public void equipAccessory(Long characterId, Long objectId) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        ObjectDto objectDto = objectRepo.getReferenceById(objectId);
        if(characterDto.getEquipment().getAccessory()!=null)
            characterInventoryService.unequipObject(characterId, characterDto.getEquipment().getAccessory().getObjectId());
        characterDto.getEquipment().setAccessory(objectDto);
        characterInventoryService.equipObject(characterId, characterDto.getEquipment().getAccessory().getObjectId());
        characterRepo.save(characterDto);
    }

    public void unequipAccessory(Long characterId) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterInventoryService.unequipObject(characterId, characterDto.getEquipment().getAccessory().getObjectId());
        characterDto.getEquipment().setAccessory(null);
        characterRepo.save(characterDto);
    }

    public void equipPet(Long characterId, Long objectId) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        ObjectDto objectDto = objectRepo.getReferenceById(objectId);
        if(characterDto.getEquipment().getPet()!=null)
            characterInventoryService.unequipObject(characterId, characterDto.getEquipment().getPet().getObjectId());
        characterDto.getEquipment().setPet(objectDto);
        characterInventoryService.equipObject(characterId, characterDto.getEquipment().getPet().getObjectId());
        characterRepo.save(characterDto);
    }

    public void unequipPet(Long characterId) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterInventoryService.unequipObject(characterId, characterDto.getEquipment().getPet().getObjectId());
        characterDto.getEquipment().setPet(null);
        characterRepo.save(characterDto);
    }

    public void equipMount(Long characterId, Long objectId) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        ObjectDto objectDto = objectRepo.getReferenceById(objectId);
        if(characterDto.getEquipment().getMount()!=null)
            characterInventoryService.unequipObject(characterId, characterDto.getEquipment().getMount().getObjectId());
        characterDto.getEquipment().setMount(objectDto);
        characterInventoryService.equipObject(characterId, characterDto.getEquipment().getMount().getObjectId());
        characterRepo.save(characterDto);
    }

    public void unequipMount(Long characterId) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterInventoryService.unequipObject(characterId, characterDto.getEquipment().getMount().getObjectId());
        characterDto.getEquipment().setMount(null);
        characterRepo.save(characterDto);
    }

    public CharacterEquipmentDto getById(Long characterId) {
        return characterRepo.getReferenceById(characterId).getEquipment();
    }
}

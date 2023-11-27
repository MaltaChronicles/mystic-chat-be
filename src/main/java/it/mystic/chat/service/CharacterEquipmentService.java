package it.mystic.chat.service;

import it.mystic.chat.model.dto.CharacterDto;
import it.mystic.chat.model.dto.ObjectDto;
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


    //TODO update delle stats IN e OUT
    //TODO Aggiugere ad Object le varie stats

    public void equipRightHand(Long characterId, Long objectId) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        ObjectDto objectDto = objectRepo.getReferenceById(objectId);
        characterDto.getEquipment().setRightHand(objectDto);
        characterRepo.save(characterDto);
    }

    public void unequipRightHand(Long characterId) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.getEquipment().setRightHand(null);
        characterRepo.save(characterDto);
    }

    public void equipLeftHand(Long characterId, Long objectId) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        ObjectDto objectDto = objectRepo.getReferenceById(objectId);
        characterDto.getEquipment().setLeftHand(objectDto);
        characterRepo.save(characterDto);
    }

    public void unequipLeftHand(Long characterId) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.getEquipment().setLeftHand(null);
        characterRepo.save(characterDto);
    }

    public void equipDress(Long characterId, Long objectId) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        ObjectDto objectDto = objectRepo.getReferenceById(objectId);
        characterDto.getEquipment().setDress(objectDto);
        characterRepo.save(characterDto);
    }

    public void unequipDress(Long characterId) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.getEquipment().setDress(null);
        characterRepo.save(characterDto);
    }

    public void equipAccessory(Long characterId, Long objectId) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        ObjectDto objectDto = objectRepo.getReferenceById(objectId);
        characterDto.getEquipment().setAccessory(objectDto);
        characterRepo.save(characterDto);
    }

    public void unequipAccessory(Long characterId) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.getEquipment().setAccessory(null);
        characterRepo.save(characterDto);
    }

    public void equipPet(Long characterId, Long objectId) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        ObjectDto objectDto = objectRepo.getReferenceById(objectId);
        characterDto.getEquipment().setPet(objectDto);
        characterRepo.save(characterDto);
    }

    public void unequipPet(Long characterId) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.getEquipment().setPet(null);
        characterRepo.save(characterDto);
    }

    public void equipMount(Long characterId, Long objectId) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        ObjectDto objectDto = objectRepo.getReferenceById(objectId);
        characterDto.getEquipment().setMount(objectDto);
        characterRepo.save(characterDto);
    }

    public void unequipMount(Long characterId) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.getEquipment().setMount(null);
        characterRepo.save(characterDto);
    }
}

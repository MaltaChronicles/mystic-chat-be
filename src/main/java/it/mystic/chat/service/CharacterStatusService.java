package it.mystic.chat.service;

import it.mystic.chat.exception.GenericException;
import it.mystic.chat.model.dto.Character;
import it.mystic.chat.model.dto.CharacterStats;
import it.mystic.chat.model.enums.Affinity;
import it.mystic.chat.model.enums.DiceValue;
import it.mystic.chat.repo.CharacterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterStatusService {

    @Autowired
    private CharacterRepo characterRepo;

    public CharacterStats getById(Long characterId) {
        return characterRepo.getReferenceById(characterId).getStatus();
    }
    
    public void sleep(Long characterId) {
        Character character = characterRepo.getReferenceById(characterId);
        character.getStatus().sleep();
        characterRepo.save(character);
    }

    public void updateTotalLife(Long characterId, Integer value) {
        Character character = characterRepo.getReferenceById(characterId);
        if (character.getStatus().getTotalLife().equals(character.getStatus().getActualLife()))
            character.getStatus().setActualLife(character.getStatus().getActualLife() + value);
        character.getStatus().setTotalLife(character.getStatus().getTotalLife() + value);
        character.getStatus().setCrisis(character.getStatus().getTotalLife() / 2);
        characterRepo.save(character);
    }

    public void updateActualLife(Long characterId, Integer value) {
        Character character = characterRepo.getReferenceById(characterId);
        character.getStatus().setActualLife(character.getStatus().getActualLife() + value);
        characterRepo.save(character);
    }

    public void updateTotalMana(Long characterId, Integer value) {
        Character character = characterRepo.getReferenceById(characterId);
        if (character.getStatus().getTotalMana().equals(character.getStatus().getActualMana()))
            character.getStatus().setActualMana(character.getStatus().getActualMana() + value);
        character.getStatus().setTotalMana(character.getStatus().getTotalMana() + value);
        characterRepo.save(character);
    }

    public void updateActualMana(Long characterId, Integer value) {
        Character character = characterRepo.getReferenceById(characterId);
        character.getStatus().setActualMana(character.getStatus().getActualMana() + value);
        characterRepo.save(character);
    }

    public void addExperience(Long characterId, Integer value) throws GenericException {
        if (value > 0) {
            Character character = characterRepo.getReferenceById(characterId);
            character.getStatus().setTotalExperience(character.getStatus().getTotalExperience() + value);
            character.getStatus().setActualExperience(character.getStatus().getActualExperience() + value);
            characterRepo.save(character);
        } else
            throw new GenericException("Valore non valido!");
    }

    public void subExperience(Long characterId, Integer value) throws GenericException {
        if (value < 0) {
            Character character = characterRepo.getReferenceById(characterId);
            character.getStatus().setActualExperience(character.getStatus().getActualExperience() + value);
            characterRepo.save(character);
        } else
            throw new GenericException("Valore non valido!");
    }

    public void levelUp(Long characterId) throws GenericException {
        Character character = characterRepo.getReferenceById(characterId);
        if (character.getStatus().getActualExperience() >= 10) {
            character.getStatus().levelUp();
            characterRepo.save(character);
        } else
            throw new GenericException("Esperienza insufficiente!");
    }

    public void updateTotalInitiative(Long characterId, Integer value) {
        Character character = characterRepo.getReferenceById(characterId);
        if (character.getStatus().getTotalInitiative().equals(character.getStatus().getActualInitiative()))
            character.getStatus().setActualInitiative(value);
        character.getStatus().setTotalInitiative(value);
        characterRepo.save(character);
    }

    public void updateActualInitiative(Long characterId, Integer value) {
        Character character = characterRepo.getReferenceById(characterId);
        character.getStatus().setActualInitiative(value);
        characterRepo.save(character);
    }

    public void updateCoin(Long characterId, Integer value) throws GenericException {
        Character character = characterRepo.getReferenceById(characterId);
        if(value < 0 && value <= character.getStatus().getCoin())
            character.getStatus().setCoin(character.getStatus().getCoin() + value);
        else
            throw new GenericException("Monete insufficienti!");
        characterRepo.save(character);
    }

    public void upTotalDexterity(Long characterId) {
        Character character = characterRepo.getReferenceById(characterId);
        DiceValue next = DiceValue.values()[(character.getStatus().getTotalDexterity().ordinal() + 1)];
        if (character.getStatus().getTotalDexterity().equals(character.getStatus().getActualDexterity()))
            character.getStatus().setActualDexterity(next);
        character.getStatus().setTotalDexterity(next);
        characterRepo.save(character);
    }

    public void updateTotalDexterity(Long characterId, DiceValue value) {
        Character character = characterRepo.getReferenceById(characterId);
        if (character.getStatus().getTotalDexterity().equals(character.getStatus().getActualDexterity()))
            character.getStatus().setActualDexterity(value);
        character.getStatus().setTotalDexterity(value);
        characterRepo.save(character);
    }

    public void updateActualDexterity(Long characterId, DiceValue value) {
        Character character = characterRepo.getReferenceById(characterId);
        character.getStatus().setActualDexterity(value);
        characterRepo.save(character);
    }

    public void upTotalInsight(Long characterId) {
        Character character = characterRepo.getReferenceById(characterId);
        DiceValue next = DiceValue.values()[(character.getStatus().getTotalInsight().ordinal() + 1)];
        if (character.getStatus().getTotalInsight().equals(character.getStatus().getActualInsight()))
            character.getStatus().setActualInsight(next);
        character.getStatus().setTotalInsight(next);
        characterRepo.save(character);
    }

    public void upTotalInsight(Long characterId, DiceValue value) {
        Character character = characterRepo.getReferenceById(characterId);
        if (character.getStatus().getTotalInsight().equals(character.getStatus().getActualInsight()))
            character.getStatus().setActualInsight(value);
        character.getStatus().setTotalInsight(value);
        characterRepo.save(character);
    }

    public void updateActualInsight(Long characterId, DiceValue value) {
        Character character = characterRepo.getReferenceById(characterId);
        character.getStatus().setActualInsight(value);
        characterRepo.save(character);
    }

    public void upTotalVigor(Long characterId) {
        Character character = characterRepo.getReferenceById(characterId);
        DiceValue next = DiceValue.values()[(character.getStatus().getTotalVigor().ordinal() + 1)];
        if (character.getStatus().getTotalVigor().equals(character.getStatus().getActualVigor()))
            character.getStatus().setActualVigor(next);
        character.getStatus().setTotalVigor(next);
        characterRepo.save(character);
    }

    public void updateTotalVigor(Long characterId, DiceValue value) {
        Character character = characterRepo.getReferenceById(characterId);
        if (character.getStatus().getTotalVigor().equals(character.getStatus().getActualVigor()))
            character.getStatus().setActualVigor(value);
        character.getStatus().setTotalVigor(value);
        characterRepo.save(character);
    }

    public void updateActualVigor(Long characterId, DiceValue value) {
        Character character = characterRepo.getReferenceById(characterId);
        character.getStatus().setActualVigor(value);
        characterRepo.save(character);
    }

    public void upTotalWill(Long characterId) {
        Character character = characterRepo.getReferenceById(characterId);
        DiceValue next = DiceValue.values()[(character.getStatus().getTotalWill().ordinal() + 1)];
        if (character.getStatus().getTotalWill().equals(character.getStatus().getActualWill()))
            character.getStatus().setActualWill(next);
        character.getStatus().setTotalWill(next);
        characterRepo.save(character);
    }

    public void updateTotalWill(Long characterId, DiceValue value) {
        Character character = characterRepo.getReferenceById(characterId);
        if (character.getStatus().getTotalWill().equals(character.getStatus().getActualWill()))
            character.getStatus().setActualWill(value);
        character.getStatus().setTotalWill(value);
        characterRepo.save(character);
    }

    public void updateActualWill(Long characterId, DiceValue value) {
        Character character = characterRepo.getReferenceById(characterId);
        character.getStatus().setActualWill(value);
        characterRepo.save(character);
    }

    public void updateTotalDefense(Long characterId, Integer value) {
        Character character = characterRepo.getReferenceById(characterId);
        character.getStatus().setTotalDefense(character.getStatus().getTotalDefense() + value);
        characterRepo.save(character);
    }

    public void updateActualDefense(Long characterId, Integer value) {
        Character character = characterRepo.getReferenceById(characterId);
        character.getStatus().setActualDefense(character.getStatus().getActualDefense() + value);
        characterRepo.save(character);
    }

    public void updateTotalResistance(Long characterId, Integer value) {
        Character character = characterRepo.getReferenceById(characterId);
        character.getStatus().setTotalResistance(character.getStatus().getTotalResistance() + value);
        characterRepo.save(character);
    }

    public void updateActualResistance(Long characterId, Integer value) {
        Character character = characterRepo.getReferenceById(characterId);
        character.getStatus().setActualResistance(character.getStatus().getActualResistance() + value);
        characterRepo.save(character);
    }

    public void updateMartialArmors(Long characterId, Boolean value) {
        Character character = characterRepo.getReferenceById(characterId);
        character.getStatus().setMartialArmors(value);
        characterRepo.save(character);
    }

    public void updateMartialShield(Long characterId, Boolean value) {
        Character character = characterRepo.getReferenceById(characterId);
        character.getStatus().setMartialShields(value);
        characterRepo.save(character);
    }

    public void updateMartialMeleeWeapons(Long characterId, Boolean value) {
        Character character = characterRepo.getReferenceById(characterId);
        character.getStatus().setMartialMeleeWeapons(value);
        characterRepo.save(character);
    }

    public void updateMartialDistanceWeapons(Long characterId, Boolean value) {
        Character character = characterRepo.getReferenceById(characterId);
        character.getStatus().setMartialDistanceWeapons(value);
        characterRepo.save(character);
    }

    public void updatePhysicalAffinity(Long characterId, Affinity value) {
        Character character = characterRepo.getReferenceById(characterId);
        if (character.getStatus().getPhysicalAffinity().equals(character.getStatus().getActualPhysicalAffinity()))
            character.getStatus().setActualPhysicalAffinity(value);
        character.getStatus().setPhysicalAffinity(value);
        characterRepo.save(character);
    }

    public void updateActualPhysicalAffinity(Long characterId, Affinity value) {
        Character character = characterRepo.getReferenceById(characterId);
        character.getStatus().setActualPhysicalAffinity(value);
        characterRepo.save(character);
    }

    public void updateWaterAffinity(Long characterId, Affinity value) {
        Character character = characterRepo.getReferenceById(characterId);
        if (character.getStatus().getWaterAffinity().equals(character.getStatus().getActualWaterAffinity()))
            character.getStatus().setActualWaterAffinity(value);
        character.getStatus().setWaterAffinity(value);
        characterRepo.save(character);
    }

    public void updateActualWaterAffinity(Long characterId, Affinity value) {
        Character character = characterRepo.getReferenceById(characterId);
        character.getStatus().setActualWaterAffinity(value);
        characterRepo.save(character);
    }

    public void updateEarthAffinity(Long characterId, Affinity value) {
        Character character = characterRepo.getReferenceById(characterId);
        if (character.getStatus().getEarthAffinity().equals(character.getStatus().getActualEarthAffinity()))
            character.getStatus().setActualEarthAffinity(value);
        character.getStatus().setEarthAffinity(value);
        characterRepo.save(character);
    }

    public void updateActualEarthAffinity(Long characterId, Affinity value) {
        Character character = characterRepo.getReferenceById(characterId);
        character.getStatus().setActualEarthAffinity(value);
        characterRepo.save(character);
    }

    public void updateFireAffinity(Long characterId, Affinity value) {
        Character character = characterRepo.getReferenceById(characterId);
        if (character.getStatus().getFireAffinity().equals(character.getStatus().getActualFireAffinity()))
            character.getStatus().setActualFireAffinity(value);
        character.getStatus().setFireAffinity(value);
        characterRepo.save(character);
    }

    public void updateActualFireAffinity(Long characterId, Affinity value) {
        Character character = characterRepo.getReferenceById(characterId);
        character.getStatus().setActualFireAffinity(value);
        characterRepo.save(character);
    }

    public void updateAirAffinity(Long characterId, Affinity value) {
        Character character = characterRepo.getReferenceById(characterId);
        if (character.getStatus().getAirAffinity().equals(character.getStatus().getActualAirAffinity()))
            character.getStatus().setActualAirAffinity(value);
        character.getStatus().setAirAffinity(value);
        characterRepo.save(character);
    }

    public void updateActualAirAffinity(Long characterId, Affinity value) {
        Character character = characterRepo.getReferenceById(characterId);
        character.getStatus().setActualAirAffinity(value);
        characterRepo.save(character);
    }

    public void updateElectricityAffinity(Long characterId, Affinity value) {
        Character character = characterRepo.getReferenceById(characterId);
        if (character.getStatus().getElectricityAffinity().equals(character.getStatus().getActualElectricityAffinity()))
            character.getStatus().setActualElectricityAffinity(value);
        character.getStatus().setElectricityAffinity(value);
        characterRepo.save(character);
    }

    public void updateActualElectricityAffinity(Long characterId, Affinity value) {
        Character character = characterRepo.getReferenceById(characterId);
        character.getStatus().setActualElectricityAffinity(value);
        characterRepo.save(character);
    }

    public void updateIceAffinity(Long characterId, Affinity value) {
        Character character = characterRepo.getReferenceById(characterId);
        if (character.getStatus().getIceAffinity().equals(character.getStatus().getActualIceAffinity()))
            character.getStatus().setActualIceAffinity(value);
        character.getStatus().setIceAffinity(value);
        characterRepo.save(character);
    }

    public void updateActualIceAffinity(Long characterId, Affinity value) {
        Character character = characterRepo.getReferenceById(characterId);
        character.getStatus().setActualIceAffinity(value);
        characterRepo.save(character);
    }

    public void updateLightAffinity(Long characterId, Affinity value) {
        Character character = characterRepo.getReferenceById(characterId);
        if (character.getStatus().getLightAffinity().equals(character.getStatus().getActualLightAffinity()))
            character.getStatus().setActualLightAffinity(value);
        character.getStatus().setLightAffinity(value);
        characterRepo.save(character);
    }

    public void updateActualLightAffinity(Long characterId, Affinity value) {
        Character character = characterRepo.getReferenceById(characterId);
        character.getStatus().setActualLightAffinity(value);
        characterRepo.save(character);
    }

    public void updateDarkAffinity(Long characterId, Affinity value) {
        Character character = characterRepo.getReferenceById(characterId);
        if (character.getStatus().getDarkAffinity().equals(character.getStatus().getActualDarkAffinity()))
            character.getStatus().setActualDarkAffinity(value);
        character.getStatus().setDarkAffinity(value);
        characterRepo.save(character);
    }

    public void updateActualDarkAffinity(Long characterId, Affinity value) {
        Character character = characterRepo.getReferenceById(characterId);
        character.getStatus().setActualDarkAffinity(value);
        characterRepo.save(character);
    }

    public void updatePoisonAffinity(Long characterId, Affinity value) {
        Character character = characterRepo.getReferenceById(characterId);
        if (character.getStatus().getPoisonAffinity().equals(character.getStatus().getActualPoisonAffinity()))
            character.getStatus().setActualPoisonAffinity(value);
        character.getStatus().setPoisonAffinity(value);
        characterRepo.save(character);
    }

    public void updateActualPoisonAffinity(Long characterId, Affinity value) {
        Character character = characterRepo.getReferenceById(characterId);
        character.getStatus().setActualPoisonAffinity(value);
        characterRepo.save(character);
    }


}

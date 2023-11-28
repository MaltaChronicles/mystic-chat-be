package it.mystic.chat.service;

import it.mystic.chat.exception.GenericException;
import it.mystic.chat.model.dto.CharacterDto;
import it.mystic.chat.model.dto.CharacterStatsDto;
import it.mystic.chat.model.enums.Affinity;
import it.mystic.chat.model.enums.DiceValue;
import it.mystic.chat.repo.CharacterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterStatusService {

    @Autowired
    private CharacterRepo characterRepo;

    public CharacterStatsDto getById(Long characterId) {
        return characterRepo.getReferenceById(characterId).getStatus();
    }
    
    public void sleep(Long characterId) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.getStatus().sleep();
        characterRepo.save(characterDto);
    }

    public void updateTotalLife(Long characterId, Integer value) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        if (characterDto.getStatus().getTotalLife().equals(characterDto.getStatus().getActualLife()))
            characterDto.getStatus().setActualLife(characterDto.getStatus().getActualLife() + value);
        characterDto.getStatus().setTotalLife(characterDto.getStatus().getTotalLife() + value);
        characterDto.getStatus().setCrisis(characterDto.getStatus().getTotalLife() / 2);
        characterRepo.save(characterDto);
    }

    public void updateActualLife(Long characterId, Integer value) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.getStatus().setActualLife(characterDto.getStatus().getActualLife() + value);
        characterRepo.save(characterDto);
    }

    public void updateTotalMana(Long characterId, Integer value) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        if (characterDto.getStatus().getTotalMana().equals(characterDto.getStatus().getActualMana()))
            characterDto.getStatus().setActualMana(characterDto.getStatus().getActualMana() + value);
        characterDto.getStatus().setTotalMana(characterDto.getStatus().getTotalMana() + value);
        characterRepo.save(characterDto);
    }

    public void updateActualMana(Long characterId, Integer value) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.getStatus().setActualMana(characterDto.getStatus().getActualMana() + value);
        characterRepo.save(characterDto);
    }

    public void addExperience(Long characterId, Integer value) throws GenericException {
        if (value > 0) {
            CharacterDto characterDto = characterRepo.getReferenceById(characterId);
            characterDto.getStatus().setTotalExperience(characterDto.getStatus().getTotalExperience() + value);
            characterDto.getStatus().setActualExperience(characterDto.getStatus().getActualExperience() + value);
            characterRepo.save(characterDto);
        } else
            throw new GenericException("Valore non valido!");
    }

    public void subExperience(Long characterId, Integer value) throws GenericException {
        if (value < 0) {
            CharacterDto characterDto = characterRepo.getReferenceById(characterId);
            characterDto.getStatus().setActualExperience(characterDto.getStatus().getActualExperience() + value);
            characterRepo.save(characterDto);
        } else
            throw new GenericException("Valore non valido!");
    }

    public void levelUp(Long characterId) throws GenericException {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        if (characterDto.getStatus().getActualExperience() >= 10) {
            characterDto.getStatus().levelUp();
            characterRepo.save(characterDto);
        } else
            throw new GenericException("Esperienza insufficiente!");
    }

    public void updateTotalInitiative(Long characterId, Integer value) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        if (characterDto.getStatus().getTotalInitiative().equals(characterDto.getStatus().getActualInitiative()))
            characterDto.getStatus().setActualInitiative(value);
        characterDto.getStatus().setTotalInitiative(value);
        characterRepo.save(characterDto);
    }

    public void updateActualInitiative(Long characterId, Integer value) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.getStatus().setActualInitiative(value);
        characterRepo.save(characterDto);
    }

    public void updateCoin(Long characterId, Integer value) throws GenericException {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        if(value < 0 && value <= characterDto.getStatus().getCoin())
            characterDto.getStatus().setCoin(characterDto.getStatus().getCoin() + value);
        else
            throw new GenericException("Monete insufficienti!");
        characterRepo.save(characterDto);
    }

    public void upTotalDexterity(Long characterId) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        DiceValue next = DiceValue.values()[(characterDto.getStatus().getTotalDexterity().ordinal() + 1)];
        if (characterDto.getStatus().getTotalDexterity().equals(characterDto.getStatus().getActualDexterity()))
            characterDto.getStatus().setActualDexterity(next);
        characterDto.getStatus().setTotalDexterity(next);
        characterRepo.save(characterDto);
    }

    public void updateTotalDexterity(Long characterId, DiceValue value) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        if (characterDto.getStatus().getTotalDexterity().equals(characterDto.getStatus().getActualDexterity()))
            characterDto.getStatus().setActualDexterity(value);
        characterDto.getStatus().setTotalDexterity(value);
        characterRepo.save(characterDto);
    }

    public void updateActualDexterity(Long characterId, DiceValue value) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.getStatus().setActualDexterity(value);
        characterRepo.save(characterDto);
    }

    public void upTotalInsight(Long characterId) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        DiceValue next = DiceValue.values()[(characterDto.getStatus().getTotalInsight().ordinal() + 1)];
        if (characterDto.getStatus().getTotalInsight().equals(characterDto.getStatus().getActualInsight()))
            characterDto.getStatus().setActualInsight(next);
        characterDto.getStatus().setTotalInsight(next);
        characterRepo.save(characterDto);
    }

    public void upTotalInsight(Long characterId, DiceValue value) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        if (characterDto.getStatus().getTotalInsight().equals(characterDto.getStatus().getActualInsight()))
            characterDto.getStatus().setActualInsight(value);
        characterDto.getStatus().setTotalInsight(value);
        characterRepo.save(characterDto);
    }

    public void updateActualInsight(Long characterId, DiceValue value) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.getStatus().setActualInsight(value);
        characterRepo.save(characterDto);
    }

    public void upTotalVigor(Long characterId) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        DiceValue next = DiceValue.values()[(characterDto.getStatus().getTotalVigor().ordinal() + 1)];
        if (characterDto.getStatus().getTotalVigor().equals(characterDto.getStatus().getActualVigor()))
            characterDto.getStatus().setActualVigor(next);
        characterDto.getStatus().setTotalVigor(next);
        characterRepo.save(characterDto);
    }

    public void updateTotalVigor(Long characterId, DiceValue value) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        if (characterDto.getStatus().getTotalVigor().equals(characterDto.getStatus().getActualVigor()))
            characterDto.getStatus().setActualVigor(value);
        characterDto.getStatus().setTotalVigor(value);
        characterRepo.save(characterDto);
    }

    public void updateActualVigor(Long characterId, DiceValue value) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.getStatus().setActualVigor(value);
        characterRepo.save(characterDto);
    }

    public void upTotalWill(Long characterId) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        DiceValue next = DiceValue.values()[(characterDto.getStatus().getTotalWill().ordinal() + 1)];
        if (characterDto.getStatus().getTotalWill().equals(characterDto.getStatus().getActualWill()))
            characterDto.getStatus().setActualWill(next);
        characterDto.getStatus().setTotalWill(next);
        characterRepo.save(characterDto);
    }

    public void updateTotalWill(Long characterId, DiceValue value) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        if (characterDto.getStatus().getTotalWill().equals(characterDto.getStatus().getActualWill()))
            characterDto.getStatus().setActualWill(value);
        characterDto.getStatus().setTotalWill(value);
        characterRepo.save(characterDto);
    }

    public void updateActualWill(Long characterId, DiceValue value) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.getStatus().setActualWill(value);
        characterRepo.save(characterDto);
    }

    public void updateTotalDefense(Long characterId, Integer value) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.getStatus().setTotalDefense(characterDto.getStatus().getTotalDefense() + value);
        characterRepo.save(characterDto);
    }

    public void updateActualDefense(Long characterId, Integer value) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.getStatus().setActualDefense(characterDto.getStatus().getActualDefense() + value);
        characterRepo.save(characterDto);
    }

    public void updateTotalResistance(Long characterId, Integer value) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.getStatus().setTotalResistance(characterDto.getStatus().getTotalResistance() + value);
        characterRepo.save(characterDto);
    }

    public void updateActualResistance(Long characterId, Integer value) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.getStatus().setActualResistance(characterDto.getStatus().getActualResistance() + value);
        characterRepo.save(characterDto);
    }

    public void updateMartialArmors(Long characterId, Boolean value) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.getStatus().setMartialArmors(value);
        characterRepo.save(characterDto);
    }

    public void updateMartialShield(Long characterId, Boolean value) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.getStatus().setMartialShields(value);
        characterRepo.save(characterDto);
    }

    public void updateMartialMeleeWeapons(Long characterId, Boolean value) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.getStatus().setMartialMeleeWeapons(value);
        characterRepo.save(characterDto);
    }

    public void updateMartialDistanceWeapons(Long characterId, Boolean value) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.getStatus().setMartialDistanceWeapons(value);
        characterRepo.save(characterDto);
    }

    public void updatePhysicalAffinity(Long characterId, Affinity value) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        if (characterDto.getStatus().getPhysicalAffinity().equals(characterDto.getStatus().getActualPhysicalAffinity()))
            characterDto.getStatus().setActualPhysicalAffinity(value);
        characterDto.getStatus().setPhysicalAffinity(value);
        characterRepo.save(characterDto);
    }

    public void updateActualPhysicalAffinity(Long characterId, Affinity value) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.getStatus().setActualPhysicalAffinity(value);
        characterRepo.save(characterDto);
    }

    public void updateWaterAffinity(Long characterId, Affinity value) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        if (characterDto.getStatus().getWaterAffinity().equals(characterDto.getStatus().getActualWaterAffinity()))
            characterDto.getStatus().setActualWaterAffinity(value);
        characterDto.getStatus().setWaterAffinity(value);
        characterRepo.save(characterDto);
    }

    public void updateActualWaterAffinity(Long characterId, Affinity value) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.getStatus().setActualWaterAffinity(value);
        characterRepo.save(characterDto);
    }

    public void updateEarthAffinity(Long characterId, Affinity value) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        if (characterDto.getStatus().getEarthAffinity().equals(characterDto.getStatus().getActualEarthAffinity()))
            characterDto.getStatus().setActualEarthAffinity(value);
        characterDto.getStatus().setEarthAffinity(value);
        characterRepo.save(characterDto);
    }

    public void updateActualEarthAffinity(Long characterId, Affinity value) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.getStatus().setActualEarthAffinity(value);
        characterRepo.save(characterDto);
    }

    public void updateFireAffinity(Long characterId, Affinity value) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        if (characterDto.getStatus().getFireAffinity().equals(characterDto.getStatus().getActualFireAffinity()))
            characterDto.getStatus().setActualFireAffinity(value);
        characterDto.getStatus().setFireAffinity(value);
        characterRepo.save(characterDto);
    }

    public void updateActualFireAffinity(Long characterId, Affinity value) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.getStatus().setActualFireAffinity(value);
        characterRepo.save(characterDto);
    }

    public void updateAirAffinity(Long characterId, Affinity value) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        if (characterDto.getStatus().getAirAffinity().equals(characterDto.getStatus().getActualAirAffinity()))
            characterDto.getStatus().setActualAirAffinity(value);
        characterDto.getStatus().setAirAffinity(value);
        characterRepo.save(characterDto);
    }

    public void updateActualAirAffinity(Long characterId, Affinity value) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.getStatus().setActualAirAffinity(value);
        characterRepo.save(characterDto);
    }

    public void updateElectricityAffinity(Long characterId, Affinity value) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        if (characterDto.getStatus().getElectricityAffinity().equals(characterDto.getStatus().getActualElectricityAffinity()))
            characterDto.getStatus().setActualElectricityAffinity(value);
        characterDto.getStatus().setElectricityAffinity(value);
        characterRepo.save(characterDto);
    }

    public void updateActualElectricityAffinity(Long characterId, Affinity value) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.getStatus().setActualElectricityAffinity(value);
        characterRepo.save(characterDto);
    }

    public void updateIceAffinity(Long characterId, Affinity value) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        if (characterDto.getStatus().getIceAffinity().equals(characterDto.getStatus().getActualIceAffinity()))
            characterDto.getStatus().setActualIceAffinity(value);
        characterDto.getStatus().setIceAffinity(value);
        characterRepo.save(characterDto);
    }

    public void updateActualIceAffinity(Long characterId, Affinity value) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.getStatus().setActualIceAffinity(value);
        characterRepo.save(characterDto);
    }

    public void updateLightAffinity(Long characterId, Affinity value) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        if (characterDto.getStatus().getLightAffinity().equals(characterDto.getStatus().getActualLightAffinity()))
            characterDto.getStatus().setActualLightAffinity(value);
        characterDto.getStatus().setLightAffinity(value);
        characterRepo.save(characterDto);
    }

    public void updateActualLightAffinity(Long characterId, Affinity value) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.getStatus().setActualLightAffinity(value);
        characterRepo.save(characterDto);
    }

    public void updateDarkAffinity(Long characterId, Affinity value) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        if (characterDto.getStatus().getDarkAffinity().equals(characterDto.getStatus().getActualDarkAffinity()))
            characterDto.getStatus().setActualDarkAffinity(value);
        characterDto.getStatus().setDarkAffinity(value);
        characterRepo.save(characterDto);
    }

    public void updateActualDarkAffinity(Long characterId, Affinity value) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.getStatus().setActualDarkAffinity(value);
        characterRepo.save(characterDto);
    }

    public void updatePoisonAffinity(Long characterId, Affinity value) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        if (characterDto.getStatus().getPoisonAffinity().equals(characterDto.getStatus().getActualPoisonAffinity()))
            characterDto.getStatus().setActualPoisonAffinity(value);
        characterDto.getStatus().setPoisonAffinity(value);
        characterRepo.save(characterDto);
    }

    public void updateActualPoisonAffinity(Long characterId, Affinity value) {
        CharacterDto characterDto = characterRepo.getReferenceById(characterId);
        characterDto.getStatus().setActualPoisonAffinity(value);
        characterRepo.save(characterDto);
    }


}

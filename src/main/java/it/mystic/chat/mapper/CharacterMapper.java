package it.mystic.chat.mapper;


import it.mystic.chat.model.dao.CharacterDao;
import it.mystic.chat.model.dao.CharacterDescriptionDao;
import it.mystic.chat.model.dto.*;
import it.mystic.chat.model.dto.Character;
import it.mystic.chat.model.response.CharacterEquipmentResponse;
import it.mystic.chat.model.response.CharacterInventoryResponse;
import it.mystic.chat.model.response.CharacterResponse;
import it.mystic.chat.model.response.CharacterStatsResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Component
public class CharacterMapper {

    @Value("${upload.dir}")
    private String uploadDir;

    public Character daoToDto(CharacterDao characterDao) {
        return new Character(
                characterDao.getName(),
                characterDao.getIdentity(),
                characterDao.getOrigin(),
                characterDao.getTheme(),
                characterDao.getJob(),
                characterDao.getRace()
        );
    }

    public CharacterDescription descriptionDaoToDescription(CharacterDescriptionDao characterDescriptionDao, Character character) {
        return new CharacterDescription(
                characterDescriptionDao.getRightEye(),
                characterDescriptionDao.getLeftEye(),
                characterDescriptionDao.getHair(),
                characterDescriptionDao.getHeight(),
                characterDescriptionDao.getWeight(),
                characterDescriptionDao.getAge(),
                characterDescriptionDao.getGender(),
                uploadDir + "img/character/default.jpeg",
                character
        );
    }

    public CharacterResponse dtoToResponse(Character character) {
        return new CharacterResponse(
                character.getCharacterId(),
                character.getName(),
                character.getIdentity(),
                character.getOrigin(),
                character.getTheme(),
                character.getStandardOfLiving(),
                character.getJob(),
                character.getRace(),
                character.getMasterNote(),
                character.getRumors(),
                character.getDescription().getRightEye(),
                character.getDescription().getLeftEye(),
                character.getDescription().getHair(),
                character.getDescription().getHeight(),
                character.getDescription().getWeight(),
                character.getDescription().getAge(),
                character.getDescription().getGender(),
                character.getDescription().getImageUrl()
        );
    }

    public Map<Long, String> characterListToMap(List<Character> characterList) {
        return characterList.stream().collect(Collectors.toMap(Character::getCharacterId, Character::getName));
    }

    public CharacterEquipmentResponse equipmentToEquipmentResponse(CharacterEquipment equipment) {
        return new CharacterEquipmentResponse(
                equipment.getRightHand(),
                equipment.getLeftHand(),
                equipment.getDress(),
                equipment.getAccessory(),
                equipment.getPet(),
                equipment.getMount()
        );
    }

    public List<CharacterInventoryResponse> inventoryToInventoryResponse(List<CharacterInventory> inventory) {
        return inventory.stream().map(inv->{
            return new CharacterInventoryResponse(inv.getId().getObject(), inv.getIsEquip());
        }).toList();
    }

    public CharacterStatsResponse statsToStatsResponse(CharacterStats status) {
        return new CharacterStatsResponse(
                status.getLevel(),
                status.getTotalLife(),
                status.getActualLife(),
                status.getCrisis(),
                status.getTotalMana(),
                status.getActualMana(),
                status.getTotalExperience(),
                status.getActualExperience(),
                status.getTotalInitiative(),
                status.getActualInitiative(),
                status.getCoin(),

                status.getTotalDexterity(),
                status.getActualDexterity(),
                status.getTotalInsight(),
                status.getActualInsight(),
                status.getTotalVigor(),
                status.getActualVigor(),
                status.getTotalWill(),
                status.getActualWill(),

                status.getTotalDefense(),
                status.getActualDefense(),
                status.getTotalResistance(),
                status.getActualResistance(),

                status.getMartialArmors(),
                status.getMartialShields(),
                status.getMartialMeleeWeapons(),
                status.getMartialDistanceWeapons(),

                status.getPhysicalAffinity(),
                status.getWaterAffinity(),
                status.getEarthAffinity(),
                status.getFireAffinity(),
                status.getAirAffinity(),
                status.getElectricityAffinity(),
                status.getIceAffinity(),
                status.getLightAffinity(),
                status.getDarkAffinity(),
                status.getPoisonAffinity(),
                status.getActualPhysicalAffinity(),
                status.getActualWaterAffinity(),
                status.getActualEarthAffinity(),
                status.getActualFireAffinity(),
                status.getActualAirAffinity(),
                status.getActualElectricityAffinity(),
                status.getActualIceAffinity(),
                status.getActualLightAffinity(),
                status.getActualDarkAffinity(),
                status.getActualPoisonAffinity()
        );
    }
}

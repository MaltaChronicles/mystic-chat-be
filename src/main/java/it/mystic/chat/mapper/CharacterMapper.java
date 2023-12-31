package it.mystic.chat.mapper;


import it.mystic.chat.model.dao.character.CharacterDao;
import it.mystic.chat.model.dao.character.CharacterDescriptionDao;
import it.mystic.chat.model.dto.character.Character;
import it.mystic.chat.model.dto.character.*;
import it.mystic.chat.model.enums.StandardOfLiving;
import it.mystic.chat.model.response.EssentialData;
import it.mystic.chat.model.response.character.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;


@Component
public class CharacterMapper {

    @Value("${upload.dir}")
    private String uploadDir;

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private AbilityMapper abilityMapper;

    public Character daoToDto(CharacterDao characterDao) {
        if (Objects.isNull(characterDao))
            return null;
        return new Character(
                StringUtils.capitalize(characterDao.name()),
                characterDao.identity(),
                characterDao.origin(),
                characterDao.theme(),
                StandardOfLiving.Nullo,
                characterDao.job(),
                characterDao.race(),
                characterDao.divinity()
        );
    }

    public CharacterDescription descriptionDaoToDto(CharacterDescriptionDao characterDescriptionDao, Character character) {
        if (Objects.isNull(characterDescriptionDao) || Objects.isNull(character))
            return null;
        return new CharacterDescription(
                characterDescriptionDao.rightEye(),
                characterDescriptionDao.leftEye(),
                characterDescriptionDao.hair(),
                characterDescriptionDao.height(),
                characterDescriptionDao.weight(),
                characterDescriptionDao.age(),
                characterDescriptionDao.gender(),
                uploadDir + "img/character/default.jpeg",
                character
        );
    }

    public CharacterResponse dtoToResponse(Character character) {
        if (Objects.isNull(character))
            return null;
        return new CharacterResponse(
                character.getCharacterId(),
                character.getName(),
                character.getIdentity(),
                character.getOrigin(),
                character.getTheme(),
                character.getStandardOfLiving(),
                character.getJob(),
                character.getRace(),
                character.getDivinity(),
                character.getMasterNote(),
                character.getRumors(),
                descriptionDtoToResponse(character.getDescription())
        );
    }

    private CharacterDescriptionResponse descriptionDtoToResponse(CharacterDescription characterDescription) {
        if (Objects.isNull(characterDescription))
            return null;
        return new CharacterDescriptionResponse(
                characterDescription.getRightEye(),
                characterDescription.getLeftEye(),
                characterDescription.getHair(),
                characterDescription.getHeight(),
                characterDescription.getWeight(),
                characterDescription.getAge(),
                characterDescription.getGender(),
                characterDescription.getImageUrl()
        );
    }

    public List<EssentialData> characterListToMap(List<Character> characterList) {
        if (Objects.isNull(characterList))
            return null;
        return characterList.stream().map(character -> {
            return new EssentialData(character.getCharacterId(), character.getName());
        }).toList();
    }

    public CharacterEquipmentResponse equipmentDtoToResponse(CharacterEquipment equipment) {
        if (Objects.isNull(equipment))
            return null;
        return new CharacterEquipmentResponse(
                equipment.getRightHand(),
                equipment.getLeftHand(),
                equipment.getDress(),
                equipment.getAccessory(),
                equipment.getPet(),
                equipment.getMount()
        );
    }

    public List<CharacterInventoryResponse> inventoryDtoToResponse(List<CharacterInventory> inventory) {
        if (Objects.isNull(inventory))
            return null;
        return inventory.stream().map(inv -> {
            return new CharacterInventoryResponse(objectMapper.dtoToResponse(inv.getId().getObject()), inv.getIsEquip());
        }).toList();
    }

    public CharacterStatsResponse statsDtoToResponse(CharacterStats status) {
        if (Objects.isNull(status))
            return null;
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

    public List<CharacterAbilityThreeResponse> abilityThreeDtoToResponse(List<CharacterAbilityThree> characterAbilityThreeList) {
        if (Objects.isNull(characterAbilityThreeList))
            return null;
        return characterAbilityThreeList.stream().map(abilityThree -> {
            return new CharacterAbilityThreeResponse(
                    abilityMapper.dtoToResponse(abilityThree.getId().getAbility()),
                    abilityThree.getLevel()
            );
        }).toList();
    }
}

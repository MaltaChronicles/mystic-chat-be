package it.mystic.chat.mapper;


import it.mystic.chat.model.dao.CharacterDao;
import it.mystic.chat.model.dao.CharacterDescriptionDao;
import it.mystic.chat.model.dto.Character;
import it.mystic.chat.model.dto.*;
import it.mystic.chat.model.enums.StandardOfLiving;
import it.mystic.chat.model.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Component
public class CharacterMapper {

    @Value("${upload.dir}")
    private String uploadDir;

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private AbilityMapper abilityMapper;

    public Character daoToDto(CharacterDao characterDao) {
        return new Character(
                null,
                characterDao.getName(),
                characterDao.getIdentity(),
                characterDao.getOrigin(),
                characterDao.getTheme(),
                StandardOfLiving.Nullo,
                characterDao.getJob(),
                characterDao.getRace(),
                "",
                "",
                "",

                new CharacterStats(),
                new CharacterDescription(),
                new CharacterEquipment(),
                null,
                null,
                null
        );
    }

    public CharacterDescription descriptionDaoToDto(CharacterDescriptionDao characterDescriptionDao, Character character) {
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

    public List<EssentialData> characterListToMap(List<Character> characterList) {
        return characterList.stream().map(character -> {
            return new EssentialData(character.getCharacterId(), character.getName());
        }).toList();
    }

    public CharacterEquipmentResponse equipmentDtoToResponse(CharacterEquipment equipment) {
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
        return inventory.stream().map(inv -> {
            return new CharacterInventoryResponse(objectMapper.dtoToResponse(inv.getId().getObject()), inv.getIsEquip());
        }).toList();
    }

    public CharacterStatsResponse statsDtoToResponse(CharacterStats status) {
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
        return characterAbilityThreeList.stream().map(abilityThree -> {
            return new CharacterAbilityThreeResponse(
                    abilityMapper.dtoToResponse(abilityThree.getId().getAbility()),
                    abilityThree.getLevel()
            );
        }).toList();
    }
}

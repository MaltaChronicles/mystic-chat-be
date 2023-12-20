package it.mystic.chat.service.character;

import it.mystic.chat.mapper.CharacterMapper;
import it.mystic.chat.model.dto.Ability;
import it.mystic.chat.model.dto.character.Character;
import it.mystic.chat.model.dto.character.CharacterAbilityThree;
import it.mystic.chat.model.dto.pk.CharacterAbilityThreePk;
import it.mystic.chat.model.response.character.CharacterAbilityThreeResponse;
import it.mystic.chat.repo.AbilityRepo;
import it.mystic.chat.repo.character.CharacterAbilityThreeRepo;
import it.mystic.chat.repo.character.CharacterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterAbilityThreeService {

    @Autowired
    private CharacterAbilityThreeRepo characterAbilityThreeRepo;
    @Autowired
    private CharacterRepo characterRepo;
    @Autowired
    private AbilityRepo abilityRepo;
    @Autowired
    private CharacterMapper characterMapper;

    @SuppressWarnings("ConstantConditions")
    public void addAbility(Long characterId, Long abilityId) {
        Character character = characterRepo.getReferenceById(characterId);
        Ability ability = abilityRepo.getReferenceById(abilityId);

        boolean isPossessed = character.getAbilityThree().stream().anyMatch(characterAbilityThree -> {
            return characterAbilityThree.getId().equals(new CharacterAbilityThreePk(character, ability));
        });

        CharacterAbilityThree characterAbilityThree;
        if (isPossessed) {
            characterAbilityThree = characterAbilityThreeRepo.getReferenceById(new CharacterAbilityThreePk(character, ability));
            characterAbilityThree.setLevel(characterAbilityThree.getLevel() + 1);
        } else {
            characterAbilityThree = new CharacterAbilityThree(
                    new CharacterAbilityThreePk(character, ability),
                    1
            );
        }
        characterAbilityThreeRepo.save(characterAbilityThree);
    }

    public List<CharacterAbilityThreeResponse> getAllByCharacterId(Long characterId) {
        Character character = characterRepo.getReferenceById(characterId);
        return characterMapper.abilityThreeDtoToResponse(character.getAbilityThree());
    }
}

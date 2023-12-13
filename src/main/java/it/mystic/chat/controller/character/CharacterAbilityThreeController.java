package it.mystic.chat.controller.character;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.mystic.chat.model.response.character.CharacterAbilityThreeResponse;
import it.mystic.chat.service.character.CharacterAbilityThreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/on/character/ability")
@Tag(name = "CHARACTER ABILITY THREE")
public class CharacterAbilityThreeController {

    @Autowired
    private CharacterAbilityThreeService characterAbilityThreeService;

    @PostMapping("/addAbility/{characterId}/{abilityId}")
    public ResponseEntity<Void> addObject(@PathVariable Long characterId, @PathVariable Long abilityId) {
        characterAbilityThreeService.addAbility(characterId, abilityId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getCharacterAbilityThreeById/{characterId}")
    public ResponseEntity<List<CharacterAbilityThreeResponse>> getCharacterAbilityThree(@PathVariable Long characterId) {
        List<CharacterAbilityThreeResponse> responseList = characterAbilityThreeService.getAllByCharacterId(characterId);
        return ResponseEntity.ok(responseList);
    }
}

package it.mystic.chat.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.mystic.chat.model.dto.CharacterDto;
import it.mystic.chat.service.CharacterEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/on/character/equipment")
@Tag(name = "CHARACTER EQUIPMENT")
public class CharacterEquipmentController {
    @Autowired
    private CharacterEquipmentService characterService;

    @PatchMapping("/equipRightHand/{characterId}/{objectId}")
    public ResponseEntity<CharacterDto> equipRightHand(@PathVariable Long characterId, @PathVariable Long objectId) {
        characterService.equipRightHand(characterId, objectId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/unequipRightHand/{characterId}/{objectId}")
    public ResponseEntity<CharacterDto> unequipRightHand(@PathVariable Long characterId) {
        characterService.unequipRightHand(characterId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/equipLeftHand/{characterId}/{objectId}")
    public ResponseEntity<CharacterDto> equipLeftHand(@PathVariable Long characterId, @PathVariable Long objectId) {
        characterService.equipLeftHand(characterId, objectId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/unequipLeftHand/{characterId}/{objectId}")
    public ResponseEntity<CharacterDto> unequipLeftHand(@PathVariable Long characterId) {
        characterService.unequipLeftHand(characterId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/equipDress/{characterId}/{objectId}")
    public ResponseEntity<CharacterDto> equipDress(@PathVariable Long characterId, @PathVariable Long objectId) {
        characterService.equipDress(characterId, objectId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/unequipDress/{characterId}/{objectId}")
    public ResponseEntity<CharacterDto> unequipDress(@PathVariable Long characterId) {
        characterService.unequipDress(characterId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/equipAccessory/{characterId}/{objectId}")
    public ResponseEntity<CharacterDto> equipAccessory(@PathVariable Long characterId, @PathVariable Long objectId) {
        characterService.equipAccessory(characterId, objectId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/unequipAccessory/{characterId}/{objectId}")
    public ResponseEntity<CharacterDto> unequipAccessory(@PathVariable Long characterId) {
        characterService.unequipAccessory(characterId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/equipPet/{characterId}/{objectId}")
    public ResponseEntity<CharacterDto> equipPet(@PathVariable Long characterId, @PathVariable Long objectId) {
        characterService.equipPet(characterId, objectId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/unequipPet/{characterId}/{objectId}")
    public ResponseEntity<CharacterDto> unequipPet(@PathVariable Long characterId) {
        characterService.unequipPet(characterId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/equipMount/{characterId}/{objectId}")
    public ResponseEntity<CharacterDto> equipMount(@PathVariable Long characterId, @PathVariable Long objectId) {
        characterService.equipMount(characterId, objectId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/unequipMount/{characterId}/{objectId}")
    public ResponseEntity<CharacterDto> unequipMount(@PathVariable Long characterId) {
        characterService.unequipMount(characterId);
        return ResponseEntity.ok().build();
    }
}

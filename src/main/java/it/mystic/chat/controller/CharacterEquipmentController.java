package it.mystic.chat.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.mystic.chat.exception.GenericException;
import it.mystic.chat.model.dto.CharacterEquipment;
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

    @GetMapping("/getCharacterEquipmentById/{characterId}")
    public ResponseEntity<CharacterEquipment> getCharacterStatsById(@PathVariable Long characterId) {
        CharacterEquipment characterStats = characterService.getById(characterId);
        return ResponseEntity.ok(characterStats);
    }

    @PatchMapping("/equipRightHand/{characterId}/{objectId}")
    public ResponseEntity<Void> equipRightHand(@PathVariable Long characterId, @PathVariable Long objectId) throws GenericException {
        characterService.equipRightHand(characterId, objectId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/unequipRightHand/{characterId}/{objectId}")
    public ResponseEntity<Void> unequipRightHand(@PathVariable Long characterId) {
        characterService.unequipRightHand(characterId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/equipLeftHand/{characterId}/{objectId}")
    public ResponseEntity<Void> equipLeftHand(@PathVariable Long characterId, @PathVariable Long objectId) throws GenericException {
        characterService.equipLeftHand(characterId, objectId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/unequipLeftHand/{characterId}/{objectId}")
    public ResponseEntity<Void> unequipLeftHand(@PathVariable Long characterId) {
        characterService.unequipLeftHand(characterId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/equipDress/{characterId}/{objectId}")
    public ResponseEntity<Void> equipDress(@PathVariable Long characterId, @PathVariable Long objectId) throws GenericException {
        characterService.equipDress(characterId, objectId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/unequipDress/{characterId}/{objectId}")
    public ResponseEntity<Void> unequipDress(@PathVariable Long characterId) {
        characterService.unequipDress(characterId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/equipAccessory/{characterId}/{objectId}")
    public ResponseEntity<Void> equipAccessory(@PathVariable Long characterId, @PathVariable Long objectId) {
        characterService.equipAccessory(characterId, objectId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/unequipAccessory/{characterId}/{objectId}")
    public ResponseEntity<Void> unequipAccessory(@PathVariable Long characterId) {
        characterService.unequipAccessory(characterId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/equipPet/{characterId}/{objectId}")
    public ResponseEntity<Void> equipPet(@PathVariable Long characterId, @PathVariable Long objectId) {
        characterService.equipPet(characterId, objectId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/unequipPet/{characterId}/{objectId}")
    public ResponseEntity<Void> unequipPet(@PathVariable Long characterId) {
        characterService.unequipPet(characterId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/equipMount/{characterId}/{objectId}")
    public ResponseEntity<Void> equipMount(@PathVariable Long characterId, @PathVariable Long objectId) {
        characterService.equipMount(characterId, objectId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/unequipMount/{characterId}/{objectId}")
    public ResponseEntity<Void> unequipMount(@PathVariable Long characterId) {
        characterService.unequipMount(characterId);
        return ResponseEntity.ok().build();
    }
}

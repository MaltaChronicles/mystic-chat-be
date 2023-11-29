package it.mystic.chat.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.mystic.chat.model.dto.CharacterInventory;
import it.mystic.chat.service.CharacterInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/on/character/inventory")
@Tag(name = "CHARACTER INVENTORY")
public class CharacterInventoryController {

    @Autowired
    private CharacterInventoryService characterInventoryService;

    @PostMapping("/addObject/{characterId}/{objectId}")
    public ResponseEntity<Void> addObject(@PathVariable Long characterId, @PathVariable Long objectId) {
        characterInventoryService.addObject(characterId, objectId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/removeObject/{characterId}/{objectId}")
    public ResponseEntity<Void> removeObject(@PathVariable Long characterId, @PathVariable Long objectId) {
        characterInventoryService.removeObject(characterId, objectId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getCharacterInventoryById/{characterId}")
    public ResponseEntity<List<CharacterInventory>> getCharacterInventory(@PathVariable Long characterId) {
        List<CharacterInventory> characterInventoryList = characterInventoryService.getAllByCharacterId(characterId);
        return ResponseEntity.ok(characterInventoryList);
    }
}

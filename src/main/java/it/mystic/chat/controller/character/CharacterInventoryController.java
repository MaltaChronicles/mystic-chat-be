package it.mystic.chat.controller.character;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.mystic.chat.model.response.character.CharacterInventoryResponse;
import it.mystic.chat.service.character.CharacterInventoryService;
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
    public ResponseEntity<List<CharacterInventoryResponse>> getCharacterInventory(@PathVariable Long characterId) {
        List<CharacterInventoryResponse> responseList = characterInventoryService.getAllByCharacterId(characterId);
        return ResponseEntity.ok(responseList);
    }
}

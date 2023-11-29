package it.mystic.chat.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.mystic.chat.model.dao.CharacterDao;
import it.mystic.chat.model.dao.CharacterDescriptionDao;
import it.mystic.chat.model.dto.Character;
import it.mystic.chat.model.enums.*;
import it.mystic.chat.service.CharacterService;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/on/character")
@Tag(name = "CHARACTER")
public class CharacterController {
    @Autowired
    private CharacterService characterService;

    @PostMapping("/create")
    public ResponseEntity<Character> createCharacter(@RequestBody CharacterDao characterDao) {
        Character character = characterService.create(characterDao);
        return ResponseEntity.ok(character);
    }

    @GetMapping("/getById/{characterId}")
    public ResponseEntity<Character> getCharacterById(@PathVariable Long characterId) {
        Character character = characterService.getById(characterId);
        return ResponseEntity.ok(character);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Character>> getCharacterById() {
        List<Character> characterList = characterService.getAll();
        return ResponseEntity.ok(characterList);
    }

    @DeleteMapping("/deleteById/{characterId}")
    public ResponseEntity<Void> deleteCharacterById(@PathVariable Long characterId) {
        characterService.deleteById(characterId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/updateName/{characterId}/{name}")
    public ResponseEntity<Void> updateNameById(@PathVariable Long characterId, @PathVariable @Pattern(regexp = "^[A-Za-z]+$") String name) {
        characterService.updateNameById(characterId, name);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/updateIdentity/{characterId}/{identity}")
    public ResponseEntity<Void> updateIdentityById(@PathVariable Long characterId, @PathVariable @Pattern(regexp = "^[A-Za-z]+$") String identity) {
        characterService.updateIdentityById(characterId, identity);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/updateOrigin/{characterId}/{origin}")
    public ResponseEntity<Void> updateOriginById(@PathVariable Long characterId, @PathVariable Origin origin) {
        characterService.updateOriginById(characterId, origin);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/updateTheme/{characterId}/{theme}")
    public ResponseEntity<Void> updateThemeById(@PathVariable Long characterId, @PathVariable Theme theme) {
        characterService.updateThemeById(characterId, theme);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/updateStandardOfLiving/{characterId}/{standardOfLiving}")
    public ResponseEntity<Void> updateStandardOfLivingById(@PathVariable Long characterId, @PathVariable StandardOfLiving standardOfLiving) {
        characterService.updateStandardOfLivingById(characterId, standardOfLiving);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/updateJob/{characterId}/{job}")
    public ResponseEntity<Void> updateJobById(@PathVariable Long characterId, @PathVariable Job job) {
        characterService.updateJobById(characterId, job);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/updateMasterNote/{characterId}")
    public ResponseEntity<Void> updateMasterNoteById(@PathVariable Long characterId, @RequestBody String masterNote) {
        characterService.updateMasterNoteById(characterId, masterNote);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/updatePersonalNote/{characterId}")
    public ResponseEntity<Void> updatePersonalNoteById(@PathVariable Long characterId, @RequestBody String personalNote) {
        characterService.updatePersonalNoteById(characterId, personalNote);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/updateRumors/{characterId}")
    public ResponseEntity<Void> updateRumorsById(@PathVariable Long characterId, @RequestBody String rumors) {
        characterService.updateRumorsById(characterId, rumors);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/updateRace/{characterId}/{race}")
    public ResponseEntity<Void> updateRaceById(@PathVariable Long characterId, @PathVariable Race race) {
        characterService.updateRaceById(characterId, race);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/updateDescription/{characterId}")
    public ResponseEntity<Void> updateDescription(@PathVariable Long characterId, @RequestBody CharacterDescriptionDao characterDescription) {
        characterService.updateDescriptionById(characterId, characterDescription);
        return ResponseEntity.ok().build();
    }

    //TODO rimuovere in caso di sovraccarico del DB
    @PatchMapping(value = "/uploadImage/{characterId}", consumes = "multipart/form-data")
    public ResponseEntity<Void> uploadImage(@PathVariable Long characterId, @RequestParam("file") MultipartFile file) throws IOException {
        characterService.uploadImage(characterId, file);
        return ResponseEntity.ok().build();
    }
}

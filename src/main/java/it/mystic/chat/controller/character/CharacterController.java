package it.mystic.chat.controller.character;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.mystic.chat.model.dao.character.CharacterDao;
import it.mystic.chat.model.dao.character.CharacterDescriptionDao;
import it.mystic.chat.model.enums.*;
import it.mystic.chat.model.response.EssentialData;
import it.mystic.chat.model.response.character.CharacterResponse;
import it.mystic.chat.service.character.CharacterService;
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
    public ResponseEntity<CharacterResponse> createCharacter(@RequestBody CharacterDao characterDao) {
        CharacterResponse response = characterService.create(characterDao);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getById/{characterId}")
    public ResponseEntity<CharacterResponse> getCharacterById(@PathVariable Long characterId) {
        CharacterResponse response = characterService.getById(characterId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<EssentialData>> getCharacterById() {
        List<EssentialData> characterList = characterService.getAll();
        return ResponseEntity.ok(characterList);
    }

    @DeleteMapping("/deleteById/{characterId}")
    public ResponseEntity<Void> deleteCharacterById(@PathVariable Long characterId) {
        characterService.deleteById(characterId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/updateName/{characterId}/{name}")
    public ResponseEntity<Void> updateNameById(@PathVariable Long characterId, @PathVariable String name) {
        characterService.updateNameById(characterId, name);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/updateIdentity/{characterId}/{identity}")
    public ResponseEntity<Void> updateIdentityById(@PathVariable Long characterId, @PathVariable String identity) {
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

    @PatchMapping("/updateDivinity/{characterId}/{identity}")
    public ResponseEntity<Void> updateDivinityById(@PathVariable Long characterId, @PathVariable Divinity divinity) {
        characterService.updateDivinityById(characterId, divinity);
        return ResponseEntity.ok().build();
    }

    //TODO rimuovere in caso di sovraccarico del DB
    @PatchMapping(value = "/uploadImage/{characterId}", consumes = "multipart/form-data")
    public ResponseEntity<Void> uploadImage(@PathVariable Long characterId, @RequestParam("file") MultipartFile file) throws IOException {
        characterService.uploadImage(characterId, file);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getAllLikeName/{name}")
    public ResponseEntity<List<EssentialData>> getAllLikeName(@PathVariable String name) {
        List<EssentialData> characterList = characterService.getAllLikeName(name);
        return ResponseEntity.ok(characterList);
    }

    @GetMapping("/getPersonalNote/{characterId}")
    public ResponseEntity<String> getPersonalNote(@PathVariable Long characterId) {
        String personalNote = characterService.getPersonalNote(characterId);
        return ResponseEntity.ok(personalNote);
    }
}

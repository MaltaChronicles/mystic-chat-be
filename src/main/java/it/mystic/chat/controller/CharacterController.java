package it.mystic.chat.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.mystic.chat.exception.ValidationException;
import it.mystic.chat.model.dao.CharacterDao;
import it.mystic.chat.model.dao.CharacterDescriptionDao;
import it.mystic.chat.model.dto.CharacterDto;
import it.mystic.chat.model.enums.*;
import it.mystic.chat.service.CharacterService;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/on/character")
@Tag(name = "CHARACTER")
public class CharacterController {
    @Autowired
    private CharacterService characterService;

    @PostMapping("/create")
    public ResponseEntity<Object> createCharacter(@RequestBody CharacterDao characterDao) {
        try {
            CharacterDto characterDto = characterService.create(characterDao);
            return ResponseEntity.ok(characterDto);
        } catch (ValidationException e) {
            return ResponseEntity.badRequest().body(e.getViolations());
        }
    }

    @GetMapping("/getById/{characterId}")
    public ResponseEntity<CharacterDto> getCharacterById(@PathVariable Long characterId) {
        CharacterDto characterDto = characterService.readById(characterId);
        return ResponseEntity.ok(characterDto);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CharacterDto>> getCharacterById() {
        List<CharacterDto> characterDtoList = characterService.readAll();
        return ResponseEntity.ok(characterDtoList);
    }

    @DeleteMapping("/deleteById/{characterId}")
    public ResponseEntity<Object> deleteCharacterById(@PathVariable Long characterId) {
        characterService.deleteById(characterId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/updateName/{characterId}/{name}")
    public ResponseEntity<CharacterDto> updateNameById(@PathVariable Long characterId, @PathVariable @Pattern(regexp = "^[A-Za-z]+$") String name) {
        characterService.updateNameById(characterId, name);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/updateIdentity/{characterId}/{identity}")
    public ResponseEntity<CharacterDto> updateIdentityById(@PathVariable Long characterId, @PathVariable @Pattern(regexp = "^[A-Za-z]+$") String identity) {
        characterService.updateIdentityById(characterId, identity);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/updateOrigin/{characterId}/{origin}")
    public ResponseEntity<CharacterDto> updateOriginById(@PathVariable Long characterId, @PathVariable Origin origin) {
        characterService.updateOriginById(characterId, origin);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/updateTheme/{characterId}/{theme}")
    public ResponseEntity<CharacterDto> updateThemeById(@PathVariable Long characterId, @PathVariable Theme theme) {
        characterService.updateThemeById(characterId, theme);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/updateStandardOfLiving/{characterId}/{standardOfLiving}")
    public ResponseEntity<CharacterDto> updateStandardOfLivingById(@PathVariable Long characterId, @PathVariable StandardOfLiving standardOfLiving) {
        characterService.updateStandardOfLivingById(characterId, standardOfLiving);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/updateJob/{characterId}/{job}")
    public ResponseEntity<CharacterDto> updateJobById(@PathVariable Long characterId, @PathVariable Job job) {
        characterService.updateJobById(characterId, job);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/updateMasterNote/{characterId}")
    public ResponseEntity<CharacterDto> updateMasterNoteById(@PathVariable Long characterId, @RequestBody String masterNote) {
        characterService.updateMasterNoteById(characterId, masterNote);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/updatePersonalNote/{characterId}")
    public ResponseEntity<CharacterDto> updatePersonalNoteById(@PathVariable Long characterId, @RequestBody String personalNote) {
        characterService.updatePersonalNoteById(characterId, personalNote);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/updateRumors/{characterId}")
    public ResponseEntity<CharacterDto> updateRumorsById(@PathVariable Long characterId, @RequestBody String rumors) {
        characterService.updateRumorsById(characterId, rumors);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/updateRace/{characterId}/{race}")
    public ResponseEntity<CharacterDto> updateRaceById(@PathVariable Long characterId, @PathVariable Race race) {
        characterService.updateRaceById(characterId, race);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/updateDescription/{characterId}")
    public ResponseEntity<CharacterDto> updateDescription(@PathVariable Long characterId, @RequestBody CharacterDescriptionDao characterDescription) {
        characterService.updateDescriptionById(characterId, characterDescription);
        return ResponseEntity.ok().build();
    }
}

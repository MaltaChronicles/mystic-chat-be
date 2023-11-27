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
        CharacterDto characterDto = characterService.updateNameById(characterId, name);
        return ResponseEntity.ok(characterDto);
    }

    @PatchMapping("/updateIdentity/{characterId}/{identity}")
    public ResponseEntity<CharacterDto> updateIdentityById(@PathVariable Long characterId, @PathVariable @Pattern(regexp = "^[A-Za-z]+$") String identity) {
        CharacterDto characterDto = characterService.updateIdentityById(characterId, identity);
        return ResponseEntity.ok(characterDto);
    }

    @PatchMapping("/updateOrigin/{characterId}/{origin}")
    public ResponseEntity<CharacterDto> updateOriginById(@PathVariable Long characterId, @PathVariable Origin origin) {
        CharacterDto characterDto = characterService.updateOriginById(characterId, origin);
        return ResponseEntity.ok(characterDto);
    }

    @PatchMapping("/updateTheme/{characterId}/{theme}")
    public ResponseEntity<CharacterDto> updateThemeById(@PathVariable Long characterId, @PathVariable Theme theme) {
        CharacterDto characterDto = characterService.updateThemeById(characterId, theme);
        return ResponseEntity.ok(characterDto);
    }

    @PatchMapping("/updateStandardOfLiving/{characterId}/{standardOfLiving}")
    public ResponseEntity<CharacterDto> updateStandardOfLivingById(@PathVariable Long characterId, @PathVariable StandardOfLiving standardOfLiving) {
        CharacterDto characterDto = characterService.updateStandardOfLivingById(characterId, standardOfLiving);
        return ResponseEntity.ok(characterDto);
    }

    @PatchMapping("/updateJob/{characterId}/{job}")
    public ResponseEntity<CharacterDto> updateJobById(@PathVariable Long characterId, @PathVariable Job job) {
        CharacterDto characterDto = characterService.updateJobById(characterId, job);
        return ResponseEntity.ok(characterDto);
    }

    @PatchMapping("/updateMasterNote/{characterId}")
    public ResponseEntity<CharacterDto> updateMasterNoteById(@PathVariable Long characterId, @RequestBody String masterNote) {
        CharacterDto characterDto = characterService.updateMasterNoteById(characterId, masterNote);
        return ResponseEntity.ok(characterDto);
    }

    @PatchMapping("/updatePersonalNote/{characterId}")
    public ResponseEntity<CharacterDto> updatePersonalNoteById(@PathVariable Long characterId, @RequestBody String personalNote) {
        CharacterDto characterDto = characterService.updatePersonalNoteById(characterId, personalNote);
        return ResponseEntity.ok(characterDto);
    }

    @PatchMapping("/updateRumors/{characterId}")
    public ResponseEntity<CharacterDto> updateRumorsById(@PathVariable Long characterId, @RequestBody String rumors) {
        CharacterDto characterDto = characterService.updateRumorsById(characterId, rumors);
        return ResponseEntity.ok(characterDto);
    }

    @PatchMapping("/updateRace/{characterId}/{race}")
    public ResponseEntity<CharacterDto> updateRaceById(@PathVariable Long characterId, @PathVariable Race race) {
        CharacterDto characterDto = characterService.updateRaceById(characterId, race);
        return ResponseEntity.ok(characterDto);
    }

    @PatchMapping("/updateDescription/{characterId}")
    public ResponseEntity<CharacterDto> updateDescription(@PathVariable Long characterId, @RequestBody CharacterDescriptionDao characterDescription) {
        CharacterDto characterDto = characterService.updateDescriptionById(characterId, characterDescription);
        return ResponseEntity.ok(characterDto);
    }
}

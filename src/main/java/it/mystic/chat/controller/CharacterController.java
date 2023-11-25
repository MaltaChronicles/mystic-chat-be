package it.mystic.chat.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.mystic.chat.exception.ValidationException;
import it.mystic.chat.model.dao.CharacterDao;
import it.mystic.chat.model.dto.CharacterDto;
import it.mystic.chat.service.CharacterService;
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

}

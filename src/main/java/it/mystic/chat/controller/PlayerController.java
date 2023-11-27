package it.mystic.chat.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.mystic.chat.exception.GenericException;
import it.mystic.chat.exception.ValidationException;
import it.mystic.chat.model.dao.PlayerDao;
import it.mystic.chat.model.dto.PlayerDto;
import it.mystic.chat.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/off/player")
@Tag(name = "PLAYER")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @PostMapping("/create")
    public ResponseEntity<Object> createPlayer(@RequestBody PlayerDao playerDao) {
        try {
            PlayerDto playerDto = playerService.create(playerDao);
            return ResponseEntity.ok(playerDto);
        } catch (ValidationException e) {
            return ResponseEntity.badRequest().body(e.getViolations());
        }
    }

    @GetMapping("/getById/{playerId}")
    public ResponseEntity<PlayerDto> getPlayerById(@PathVariable Long playerId) {
        PlayerDto playerDto = playerService.readById(playerId);
        return ResponseEntity.ok(playerDto);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PlayerDto>> getPlayerById() {
        List<PlayerDto> playerDtoList = playerService.readAll();
        return ResponseEntity.ok(playerDtoList);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updatePlayer(@RequestBody PlayerDao playerDao) {
        try {
            PlayerDto playerDto = playerService.update(playerDao);
            return ResponseEntity.ok(playerDto);
        } catch (ValidationException e) {
            return ResponseEntity.badRequest().body(e.getViolations());
        }
    }

    @DeleteMapping("/deleteById/{playerId}")
    public ResponseEntity<Object> deletePlayerById(@PathVariable Long playerId) {
        playerService.deleteById(playerId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/addCharacter/{playerId}")
    public ResponseEntity<Object> addCharacter(@PathVariable Long playerId, @RequestBody Long characterId) {
        try {
            try {
                PlayerDto playerDto = playerService.addCharacter(playerId, characterId);
                return ResponseEntity.ok(playerDto);
            } catch (GenericException e) {
                return ResponseEntity.badRequest().body(e);
            }
        } catch (ValidationException e) {
            return ResponseEntity.badRequest().body(e.getViolations());
        }
    }

}

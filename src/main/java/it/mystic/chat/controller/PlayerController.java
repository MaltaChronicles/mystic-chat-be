package it.mystic.chat.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.mystic.chat.exception.GenericException;
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
    public ResponseEntity<PlayerDto> createPlayer(@RequestBody PlayerDao playerDao) {
        PlayerDto playerDto = playerService.create(playerDao);
        return ResponseEntity.ok(playerDto);
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
    public ResponseEntity<Void> updatePlayer(@RequestBody PlayerDao playerDao) {
        playerService.update(playerDao);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteById/{playerId}")
    public ResponseEntity<Void> deletePlayerById(@PathVariable Long playerId) {
        playerService.deleteById(playerId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/addCharacter/{playerId}")
    public ResponseEntity<PlayerDto> addCharacter(@PathVariable Long playerId, @RequestBody Long characterId) throws GenericException {
        PlayerDto playerDto = playerService.addCharacter(playerId, characterId);
        return ResponseEntity.ok().build();
    }

}

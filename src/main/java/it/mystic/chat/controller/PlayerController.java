package it.mystic.chat.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.mystic.chat.exception.GenericException;
import it.mystic.chat.model.dao.PlayerDao;
import it.mystic.chat.model.dto.Player;
import it.mystic.chat.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/off/player")
@Tag(name = "PLAYER")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @PostMapping("/create")
    public ResponseEntity<Player> createPlayer(@RequestBody PlayerDao playerDao) {
        Player player = playerService.create(playerDao);
        return ResponseEntity.ok(player);
    }

    @GetMapping("/getById/{playerId}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Long playerId) {
        Player player = playerService.getById(playerId);
        return ResponseEntity.ok(player);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Map<Long, String>> getPlayerById() {
        Map<Long, String> playerList = playerService.getAll();
        return ResponseEntity.ok(playerList);
    }

    @GetMapping("/getAllLikeUsername/{username}")
    public ResponseEntity<Map<Long, String>> getAllLikeUsername(@PathVariable String username) {
        Map<Long, String> playerList = playerService.getAllLikeUsername(username);
        return ResponseEntity.ok(playerList);
    }

    @PatchMapping("/updateEmail/{playerId}")
    public ResponseEntity<Void> updateEmail(@PathVariable Long playerId, @RequestBody String email) {
        playerService.updateEmail(playerId, email);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/updatePassword/{playerId}")
    public ResponseEntity<Void> updatePassword(@PathVariable Long playerId, @RequestBody String password) {
        playerService.updatePassword(playerId, password);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteById/{playerId}")
    public ResponseEntity<Void> deletePlayerById(@PathVariable Long playerId) {
        playerService.deleteById(playerId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/addCharacter/{playerId}")
    public ResponseEntity<Player> addCharacter(@PathVariable Long playerId, @RequestBody Long characterId) throws GenericException {
        Player player = playerService.addCharacter(playerId, characterId);
        return ResponseEntity.ok().build();
    }

}

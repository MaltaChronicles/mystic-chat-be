package it.mystic.chat.controller.player;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.mystic.chat.exception.GenericException;
import it.mystic.chat.model.dao.PlayerDao;
import it.mystic.chat.model.response.EssentialData;
import it.mystic.chat.model.response.player.PlayerResponse;
import it.mystic.chat.service.player.PlayerService;
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
    public ResponseEntity<PlayerResponse> createPlayer(@RequestBody PlayerDao playerDao) {
        PlayerResponse response = playerService.create(playerDao);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getById/{playerId}")
    public ResponseEntity<PlayerResponse> getPlayerById(@PathVariable Long playerId) {
        PlayerResponse response = playerService.getById(playerId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<EssentialData>> getPlayerById() {
        List<EssentialData> playerList = playerService.getAll();
        return ResponseEntity.ok(playerList);
    }

    @GetMapping("/getAllLikeUsername/{username}")
    public ResponseEntity<List<EssentialData>> getAllLikeUsername(@PathVariable String username) {
        List<EssentialData> playerList = playerService.getAllLikeUsername(username);
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

    @PatchMapping("/addCharacter/{playerId}/{characterId}")
    public ResponseEntity<Void> addCharacter(@PathVariable Long playerId, @PathVariable Long characterId) throws GenericException {
        playerService.addCharacter(playerId, characterId);
        return ResponseEntity.ok().build();
    }

}

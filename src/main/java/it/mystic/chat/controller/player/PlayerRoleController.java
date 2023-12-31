package it.mystic.chat.controller.player;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.mystic.chat.model.enums.Role;
import it.mystic.chat.model.response.EssentialData;
import it.mystic.chat.service.player.PlayerRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/off/role")
@Tag(name = "ROLE")
public class PlayerRoleController {
    @Autowired
    private PlayerRoleService playerRoleService;

    @PostMapping("/add/{playerId}/{role}")
    public ResponseEntity<Void> addRole(@PathVariable Long playerId, @PathVariable Role role) {
        playerRoleService.addRole(playerId, role);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/changeBoss/{playerId}/{role}")
    public ResponseEntity<Void> updateRole(@PathVariable Long playerId, @PathVariable Role role) {
        playerRoleService.changeBoss(playerId, role);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/remove/{playerId}/{role}")
    public ResponseEntity<Void> removeRole(@PathVariable Long playerId, @PathVariable Role role) {
        playerRoleService.removeRole(playerId, role);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getPlayerByRole/{role}")
    public ResponseEntity<List<EssentialData>> getPlayerByRole(@PathVariable Role role) {
        List<EssentialData> playerList = playerRoleService.getPlayerByRole(role);
        return ResponseEntity.ok(playerList);
    }

}

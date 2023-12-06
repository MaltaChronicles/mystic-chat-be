package it.mystic.chat.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.mystic.chat.model.dao.AbilityDao;
import it.mystic.chat.model.dto.Ability;
import it.mystic.chat.model.dto.Medal;
import it.mystic.chat.model.enums.Class;
import it.mystic.chat.service.AbilityService;
import it.mystic.chat.service.MedalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/off/medal")
@Tag(name = "MEDAL")
public class MedalController {
    @Autowired
    private MedalService medalService;

    @PostMapping("/create")
    public ResponseEntity<Medal> create(@RequestBody String name) {
        Medal medal = medalService.create(name);
        return ResponseEntity.ok(medal);
    }

    @PatchMapping("/updateName/{medalId}")
    public ResponseEntity<Void> update(@PathVariable Long medalId, @RequestBody String name) {
        medalService.update(medalId, name);
        return ResponseEntity.ok().build();
    }

    @PatchMapping(value = "/uploadImage/{medalId}", consumes = "multipart/form-data")
    public ResponseEntity<Void> uploadImage(@PathVariable Long medalId, @RequestParam("file") MultipartFile file) throws IOException {
        medalService.uploadImage(medalId, file);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/getById/{medalId}")
    public ResponseEntity<Medal> getById(@PathVariable Long medalId) {
        Medal medal = medalService.getById(medalId);
        return ResponseEntity.ok(medal);
    }

    @DeleteMapping(value = "/delete/{medalId}")
    public ResponseEntity<Void> delete(@PathVariable Long medalId) {
        medalService.delete(medalId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping(value = "/giveToPlayer/{medalId}/{playerId}")
    public ResponseEntity<Void> giveToPlayer(@PathVariable Long medalId, @PathVariable Long playerId) {
        medalService.giveToPlayer(medalId, playerId);
        return ResponseEntity.ok().build();
    }
}
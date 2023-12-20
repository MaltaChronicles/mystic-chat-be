package it.mystic.chat.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.mystic.chat.model.dao.GuildDao;
import it.mystic.chat.model.response.GuildResponse;
import it.mystic.chat.service.GuildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/on/guild")
@Tag(name = "GUILD")
public class GuildController {
    @Autowired
    private GuildService guildService;

    @PostMapping("/create")
    public ResponseEntity<GuildResponse> create(@RequestBody GuildDao guildDao) {
        GuildResponse response = guildService.create(guildDao);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/{guildId}")
    public ResponseEntity<Void> update(@PathVariable Long guildId, @RequestBody GuildDao guildDao) {
        guildService.update(guildId, guildDao);
        return ResponseEntity.ok().build();
    }

    @PatchMapping(value = "/uploadImage/{guildId}", consumes = "multipart/form-data")
    public ResponseEntity<Void> uploadImage(@PathVariable Long guildId, @RequestParam("file") MultipartFile file) throws IOException {
        guildService.uploadImage(guildId, file);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/getById/{guildId}")
    public ResponseEntity<GuildResponse> getById(@PathVariable Long guildId) {
        GuildResponse response = guildService.getById(guildId);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/delete/{guildId}")
    public ResponseEntity<Void> delete(@PathVariable Long guildId) {
        guildService.delete(guildId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/addGuilder/{guildId}/{characterId}")
    public ResponseEntity<Void> addGuilder(@PathVariable Long guildId, @PathVariable Long characterId) {
        guildService.addGuilder(guildId, characterId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/removeGuilder/{characterId}")
    public ResponseEntity<Void> removeGuilder(@PathVariable Long characterId) {
        guildService.removeGuilder(characterId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/increaseRank/{characterId}")
    public ResponseEntity<Void> increaseRank(@PathVariable Long characterId) {
        guildService.increaseRank(characterId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/decreaseRank/{characterId}")
    public ResponseEntity<Void> decreaseRank(@PathVariable Long characterId) {
        guildService.decreaseRank(characterId);
        return ResponseEntity.ok().build();
    }
}

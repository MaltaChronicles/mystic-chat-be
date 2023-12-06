package it.mystic.chat.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.mystic.chat.model.dao.AbilityDao;
import it.mystic.chat.model.dto.Ability;
import it.mystic.chat.model.enums.Class;
import it.mystic.chat.service.AbilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/on/ability")
@Tag(name = "ABILITY")
public class AbilityController {
    @Autowired
    private AbilityService abilityService;

    @PostMapping("/create")
    public ResponseEntity<Ability> create(@RequestBody AbilityDao abilityDao) {
        Ability ability = abilityService.create(abilityDao);
        return ResponseEntity.ok(ability);
    }

    @PutMapping("/upload/{abilityId}")
    public ResponseEntity<Void> update(@PathVariable Long abilityId, @RequestBody AbilityDao abilityDao) {
        abilityService.update(abilityId, abilityDao);
        return ResponseEntity.ok().build();
    }

    @PatchMapping(value = "/uploadImage/{abilityId}", consumes = "multipart/form-data")
    public ResponseEntity<Void> uploadImage(@PathVariable Long abilityId, @RequestParam("file") MultipartFile file) throws IOException {
        abilityService.uploadImage(abilityId, file);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/getById/{abilityId}")
    public ResponseEntity<Ability> getById(@PathVariable Long abilityId) {
        Ability ability = abilityService.getById(abilityId);
        return ResponseEntity.ok(ability);
    }

    @DeleteMapping(value = "/delete/{abilityId}")
    public ResponseEntity<Void> delete(@PathVariable Long abilityId) {
        abilityService.delete(abilityId);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/getByClass/{abilityClass}")
    public ResponseEntity<List<Ability>> getByClass(@PathVariable Class abilityClass) {
        List<Ability> abilityList = abilityService.getByClass(abilityClass);
        return ResponseEntity.ok(abilityList);
    }
}

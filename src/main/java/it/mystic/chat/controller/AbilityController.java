package it.mystic.chat.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.mystic.chat.model.dao.AbilityDao;
import it.mystic.chat.model.enums.Class;
import it.mystic.chat.model.response.AbilityResponse;
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
    public ResponseEntity<AbilityResponse> create(@RequestBody AbilityDao abilityDao) {
        AbilityResponse response = abilityService.create(abilityDao);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/{abilityId}")
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
    public ResponseEntity<AbilityResponse> getById(@PathVariable Long abilityId) {
        AbilityResponse response = abilityService.getById(abilityId);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/delete/{abilityId}")
    public ResponseEntity<Void> delete(@PathVariable Long abilityId) {
        abilityService.delete(abilityId);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/getByClass/{abilityClass}")
    public ResponseEntity<List<AbilityResponse>> getByClass(@PathVariable Class abilityClass) {
        List<AbilityResponse> responseList = abilityService.getByClass(abilityClass);
        return ResponseEntity.ok(responseList);
    }
}

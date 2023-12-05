package it.mystic.chat.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.mystic.chat.model.dao.ObjectDao;
import it.mystic.chat.model.dto.Object;
import it.mystic.chat.model.enums.ObjectType;
import it.mystic.chat.service.ObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/on/object")
@Tag(name = "OBJECT")
public class ObjectController {
    @Autowired
    private ObjectService objectService;

    @PostMapping(value = "/create")
    public ResponseEntity<Object> create(@RequestBody ObjectDao objectDao) {
        Object object = objectService.create(objectDao);
        return ResponseEntity.ok(object);
    }

    @PutMapping("/update/{objectId}")
    public ResponseEntity<Void> update(@RequestBody ObjectDao objectDao, @PathVariable Long objectId) throws IOException {
        objectService.update(objectDao, objectId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{objectId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long objectId) {
        objectService.deleteById(objectId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getById/{objectId}")
    public ResponseEntity<Object> getById(@PathVariable Long objectId) {
        Object object = objectService.getById(objectId);
        return ResponseEntity.ok(object);
    }

    @GetMapping("/getMarketByType/{objectType}")
    public ResponseEntity<List<Object>> getMarketByType(@PathVariable ObjectType objectType) {
        List<Object> objectList = objectService.getMarketByType(objectType);
        return ResponseEntity.ok(objectList);
    }

    @PatchMapping(value = "/uploadImage/{objectId}", consumes = "multipart/form-data")
    public ResponseEntity<Void> uploadImage(@PathVariable Long objectId, @RequestParam("file") MultipartFile file) throws IOException {
        objectService.uploadImage(objectId, file);
        return ResponseEntity.ok().build();
    }

}

package it.mystic.chat.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.mystic.chat.model.dao.ObjectDao;
import it.mystic.chat.model.dao.RoleDao;
import it.mystic.chat.model.dto.ObjectDto;
import it.mystic.chat.model.dto.PlayerRoleDto;
import it.mystic.chat.service.ObjectService;
import it.mystic.chat.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/on/object")
@Tag(name = "OBJECT")
public class ObjectController {
    @Autowired
    private ObjectService objectService;

    @PostMapping("/create")
    public ResponseEntity<ObjectDto> createObject(@RequestBody ObjectDao objectDao) {
        ObjectDto objectDto = objectService.create(objectDao);
        return ResponseEntity.ok(objectDto);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateObject(@RequestBody ObjectDao objectDao) {
        objectService.update(objectDao);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteById/{objectId}")
    public ResponseEntity<Void> deleteObjectById(@PathVariable Long objectId) {
        objectService.deleteById(objectId);
        return ResponseEntity.ok().build();
    }

}

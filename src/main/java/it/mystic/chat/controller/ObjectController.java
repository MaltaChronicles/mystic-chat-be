package it.mystic.chat.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.mystic.chat.model.dao.ObjectDao;
import it.mystic.chat.model.dao.RoleDao;
import it.mystic.chat.model.dto.Object;
import it.mystic.chat.model.dto.PlayerRole;
import it.mystic.chat.model.enums.ObjectType;
import it.mystic.chat.service.ObjectService;
import it.mystic.chat.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/on/object")
@Tag(name = "OBJECT")
public class ObjectController {
    @Autowired
    private ObjectService objectService;

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody ObjectDao objectDao) {
        Object object = objectService.create(objectDao);
        return ResponseEntity.ok(object);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> update(@RequestBody ObjectDao objectDao) {
        objectService.update(objectDao);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteById/{objectId}")
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

}

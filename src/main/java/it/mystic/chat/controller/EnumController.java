package it.mystic.chat.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.mystic.chat.model.enums.*;
import it.mystic.chat.model.enums.Class;
import it.mystic.chat.service.EnumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/config/enum")
@Tag(name = "ENUM")
public class EnumController {

    @Autowired
    private EnumService enumService;

    @GetMapping("/getClasses")
    public ResponseEntity<List<String>> getClasses() {
        return ResponseEntity.ok(enumService.getClasses());
    }

    @GetMapping("/getColors")
    public ResponseEntity<List<String>> getColors() {
        return ResponseEntity.ok(enumService.getColors());
    }

    @GetMapping("/getOrigins")
    public ResponseEntity<List<String>> getOrigins() {
        return ResponseEntity.ok(enumService.getOrigins());
    }

    @GetMapping("/getThemes")
    public ResponseEntity<List<String>> getThemes() {
        return ResponseEntity.ok(enumService.getThemes());
    }

    @GetMapping("/getObjectTypes")
    public ResponseEntity<List<String>> getObjectTypes() {
        return ResponseEntity.ok(enumService.getObjectTypes());
    }

    @GetMapping("/getObjectRanks")
    public ResponseEntity<List<String>> getObjectRanks() {
        return ResponseEntity.ok(enumService.getObjectRanks());
    }

    @GetMapping("/getDiceValues")
    public ResponseEntity<List<String>> getDiceValues() {
        return ResponseEntity.ok(enumService.getDiceValues());
    }

    @GetMapping("/getFeatures")
    public ResponseEntity<List<String>> getFeatures() {
        return ResponseEntity.ok(enumService.getFeatures());
    }
}

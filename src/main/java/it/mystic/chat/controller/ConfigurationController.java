package it.mystic.chat.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.mystic.chat.service.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/config")
@Tag(name = "CONFIGURATION")
public class ConfigurationController {

    @Autowired
    ConfigurationService configurationService;

    @GetMapping("/getAll")
    public ResponseEntity<Map<String, String>> getAll() {
        Map<String, String> configurations = configurationService.getAll();
        return ResponseEntity.ok(configurations);
    }

    @GetMapping("/getValueByName/{name}")
    public ResponseEntity<String> getValueByName(@PathVariable String name) {
        String configurationValue = configurationService.getValueByName(name);
        return ResponseEntity.ok(configurationValue);
    }
}

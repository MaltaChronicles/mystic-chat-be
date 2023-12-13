package it.mystic.chat.controller.location;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.mystic.chat.model.dao.LocationDao;
import it.mystic.chat.model.response.location.LocationResponse;
import it.mystic.chat.service.location.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/on/location")
@Tag(name = "LOCATION")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @PostMapping("/create")
    public ResponseEntity<LocationResponse> create(@RequestBody LocationDao locationDao) {
        LocationResponse response = locationService.create(locationDao);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/{locationId}")
    public ResponseEntity<Void> update(@PathVariable Long locationId, @RequestBody LocationDao locationDao) {
        locationService.update(locationId, locationDao);
        return ResponseEntity.ok().build();
    }

    @PatchMapping(value = "/uploadImage/{locationId}", consumes = "multipart/form-data")
    public ResponseEntity<Void> uploadImage(@PathVariable Long locationId, @RequestParam("file") MultipartFile file) throws IOException {
        locationService.uploadImage(locationId, file);
        return ResponseEntity.ok().build();
    }

    @PatchMapping(value = "/uploadBackgroundImage/{locationId}", consumes = "multipart/form-data")
    public ResponseEntity<Void> uploadBackgroundImage(@PathVariable Long locationId, @RequestParam("file") MultipartFile file) throws IOException {
        locationService.uploadBackgroundImage(locationId, file);
        return ResponseEntity.ok().build();
    }

    @PatchMapping(value = "/uploadAmbientMusic/{locationId}", consumes = "multipart/form-data")
    public ResponseEntity<Void> uploadAmbientMusic(@PathVariable Long locationId, @RequestParam("file") MultipartFile file) throws IOException {
        locationService.uploadAmbientMusic(locationId, file);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/getById/{locationId}")
    public ResponseEntity<LocationResponse> getById(@PathVariable Long locationId) {
        LocationResponse response = locationService.getById(locationId);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/delete/{locationId}")
    public ResponseEntity<Void> delete(@PathVariable Long locationId) {
        locationService.delete(locationId);
        return ResponseEntity.ok().build();
    }
}

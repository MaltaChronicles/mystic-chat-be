package it.mystic.chat.controller.location;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.mystic.chat.model.dao.location.LocationPosterDao;
import it.mystic.chat.model.response.location.LocationPosterResponse;
import it.mystic.chat.service.location.LocationPosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/on/location/poster")
@Tag(name = "LOCATION POSTER")
public class LocationPosterController {
    @Autowired
    private LocationPosterService locationPosterService;

    @PostMapping("/create/{locationId}/{characterId}")
    public ResponseEntity<LocationPosterResponse> create(@PathVariable Long characterId, @PathVariable Long locationId, @RequestBody LocationPosterDao locationPosterDao) {
        LocationPosterResponse response = locationPosterService.create(characterId, locationId, locationPosterDao);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/getById/{locationId}/{characterId}/{uuid}")
    public ResponseEntity<LocationPosterResponse> getById(@PathVariable Long locationId, @PathVariable Long characterId, @PathVariable UUID uuid) {
        LocationPosterResponse response = locationPosterService.getById(characterId, locationId, uuid);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/getByLocation/{locationId}")
    public ResponseEntity<List<LocationPosterResponse>> getByLocation(@PathVariable Long locationId) {
        List<LocationPosterResponse> responseList = locationPosterService.getByLocation(locationId);
        return ResponseEntity.ok(responseList);
    }

    @DeleteMapping(value = "/delete/{locationId}/{characterId}/{uuid}")
    public ResponseEntity<Void> delete(@PathVariable Long locationId, @PathVariable Long characterId, @PathVariable UUID uuid) {
        locationPosterService.delete(locationId, characterId, uuid);
        return ResponseEntity.ok().build();
    }
}

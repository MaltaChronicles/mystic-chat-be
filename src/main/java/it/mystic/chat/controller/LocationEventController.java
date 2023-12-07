package it.mystic.chat.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.mystic.chat.model.dao.LocationEventDao;
import it.mystic.chat.model.response.LocationEventResponse;
import it.mystic.chat.service.LocationEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/on/location/event")
@Tag(name = "LOCATION EVENT")
public class LocationEventController {
    @Autowired
    private LocationEventService locationEventService;

    @PostMapping("/addEvent/{locationId}")
    public ResponseEntity<Void> addEvent(@PathVariable Long locationId, @RequestBody LocationEventDao locationEventDao) {
        locationEventService.addEvent(locationId, locationEventDao);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{locationId}")
    public ResponseEntity<Void> update(@PathVariable Long locationId, @RequestBody LocationEventDao locationEventDao,
                                       @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {
        locationEventService.update(locationId, date, locationEventDao);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{locationId}")
    public ResponseEntity<Void> delete(@PathVariable Long locationId, @RequestBody LocationEventDao locationEventDao,
                                       @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {
        locationEventService.delete(locationId, date, locationEventDao);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getAllByLocation/{locationId}")
    public ResponseEntity<List<LocationEventResponse>> readChat(@PathVariable Long locationId) {
        List<LocationEventResponse> responseList = locationEventService.getAllByLocation(locationId);
        return ResponseEntity.ok(responseList);
    }
}

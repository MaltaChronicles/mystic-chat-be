package it.mystic.chat.controller.location;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.mystic.chat.model.dao.LocationMessageDao;
import it.mystic.chat.model.response.location.LocationMessageResponse;
import it.mystic.chat.service.location.LocationMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/on/location/message")
@Tag(name = "LOCATION MESSAGE")
public class LocationMessageController {
    @Autowired
    private LocationMessageService locationMessageService;

    @PostMapping("/send")
    public ResponseEntity<Void> send(@RequestBody LocationMessageDao locationMessageDao) {
        locationMessageService.send(locationMessageDao);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/sendMaster")
    public ResponseEntity<Void> sendMaster(@RequestBody LocationMessageDao locationMessageDao) {
        locationMessageService.sendMaster(locationMessageDao);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/readChat/{locationId}")
    public ResponseEntity<List<LocationMessageResponse>> readChat(@PathVariable Long locationId) {
        List<LocationMessageResponse> responseList = locationMessageService.readChat(locationId);
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/readChatBetween/{locationId}")
    public ResponseEntity<List<LocationMessageResponse>> readChat(@PathVariable Long locationId,
                                                                  @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
                                                                  @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        List<LocationMessageResponse> responseList = locationMessageService.readChatBetween(locationId, startDate, endDate);
        return ResponseEntity.ok(responseList);
    }
}

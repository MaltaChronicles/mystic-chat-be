package it.mystic.chat.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.mystic.chat.model.dao.LocationDao;
import it.mystic.chat.model.dao.LocationMessageDao;
import it.mystic.chat.model.dto.Location;
import it.mystic.chat.model.dto.LocationMessage;
import it.mystic.chat.service.LocationMessageService;
import it.mystic.chat.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
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
    public ResponseEntity<List<LocationMessage>> readChat(@PathVariable Long locationId) {
        List<LocationMessage> locationMessageList = locationMessageService.readChat(locationId);
        return ResponseEntity.ok(locationMessageList);
    }

    @GetMapping("/readChatBetween/{locationId}")
    public ResponseEntity<List<LocationMessage>> readChat(@PathVariable Long locationId,
                                                          @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
                                                          @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        List<LocationMessage> locationMessageList = locationMessageService.readChatBetween(locationId, startDate, endDate);
        return ResponseEntity.ok(locationMessageList);
    }
}

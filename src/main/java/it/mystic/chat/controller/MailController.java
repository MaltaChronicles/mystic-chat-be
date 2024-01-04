package it.mystic.chat.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.mystic.chat.model.response.MailResponse;
import it.mystic.chat.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/on/mail")
@Tag(name = "MAIL")
public class MailController {
    @Autowired
    private MailService mailService;

    @PostMapping("/create/{senderId}/{recipientId}")
    public ResponseEntity<MailResponse> send(@PathVariable Long senderId, @PathVariable Long recipientId, @RequestBody String body) {
        MailResponse response = mailService.send(senderId, recipientId, body);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/getSend/{characterId}")
    public ResponseEntity<List<MailResponse>> getSend(@PathVariable Long characterId) {
        List<MailResponse> responseList = mailService.getSend(characterId);
        return ResponseEntity.ok(responseList);
    }

    @GetMapping(value = "/getRead/{characterId}")
    public ResponseEntity<List<MailResponse>> getRead(@PathVariable Long characterId) {
        List<MailResponse> responseList = mailService.getRead(characterId);
        return ResponseEntity.ok(responseList);
    }

    @GetMapping(value = "/getToRead/{characterId}")
    public ResponseEntity<List<MailResponse>> getToRead(@PathVariable Long characterId) {
        List<MailResponse> responseList = mailService.getToRead(characterId);
        return ResponseEntity.ok(responseList);
    }

    @PatchMapping("/setIsRead/{senderId}/{recipientId}")
    public ResponseEntity<Void> setIsRead(@PathVariable Long senderId, @PathVariable Long recipientId,
                                          @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {
        mailService.setIsRead(senderId, recipientId, date);
        return ResponseEntity.ok().build();
    }

}

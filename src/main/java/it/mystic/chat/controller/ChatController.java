package it.mystic.chat.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.mystic.chat.model.response.chat.ChatMemberResponse;
import it.mystic.chat.model.response.chat.ChatMessageResponse;
import it.mystic.chat.model.response.chat.ChatResponse;
import it.mystic.chat.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/off/chat")
@Tag(name = "CHAT")
public class ChatController {
    @Autowired
    private ChatService chatService;

    @PostMapping("/create/{playerId}")
    public ResponseEntity<ChatResponse> create(@PathVariable Long playerId, @RequestBody String title) {
        ChatResponse response = chatService.create(playerId, title);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/{chatId}")
    public ResponseEntity<Void> update(@PathVariable UUID chatId, @RequestBody String title) {
        chatService.update(chatId, title);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/getMessages/{chatId}")
    public ResponseEntity<List<ChatMessageResponse>> getMessages(@PathVariable UUID chatId) {
        List<ChatMessageResponse> responseList = chatService.getMessages(chatId);
        return ResponseEntity.ok(responseList);
    }

    @GetMapping(value = "/getMembers/{chatId}")
    public ResponseEntity<List<ChatMemberResponse>> getMembers(@PathVariable UUID chatId) {
        List<ChatMemberResponse> responseList = chatService.getMembers(chatId);
        return ResponseEntity.ok(responseList);
    }

    @DeleteMapping(value = "/delete/{chatId}")
    public ResponseEntity<Void> delete(@PathVariable UUID chatId) {
        chatService.delete(chatId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/addPlayer/{chatId}/{playerId}")
    public ResponseEntity<Void> addPlayer(@PathVariable UUID chatId, @PathVariable Long playerId) {
        chatService.addPlayer(chatId, playerId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/removePlayer/{chatId}/{playerId}")
    public ResponseEntity<Void> removePlayer(@PathVariable UUID chatId, @PathVariable Long playerId) {
        chatService.removePlayer(chatId, playerId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/makeAdmin/{chatId}/{playerId}")
    public ResponseEntity<Void> makeAdmin(@PathVariable UUID chatId, @PathVariable Long playerId) {
        chatService.makeAdmin(chatId, playerId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/unmakeAdmin/{chatId}/{playerId}")
    public ResponseEntity<Void> unmakeAdmin(@PathVariable UUID chatId, @PathVariable Long playerId) {
        chatService.unmakeAdmin(chatId, playerId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/sendMessage/{chatId}/{playerId}")
    public ResponseEntity<ChatMessageResponse> sendMessage(@PathVariable UUID chatId, @PathVariable Long playerId, @RequestBody String body) {
        ChatMessageResponse response = chatService.sendMessage(chatId, playerId, body);
        return ResponseEntity.ok(response);
    }
}

package it.mystic.chat.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.mystic.chat.model.dao.BoardAnswerDao;
import it.mystic.chat.model.dao.BoardDao;
import it.mystic.chat.model.dao.BoardDiscussionDao;
import it.mystic.chat.model.enums.BoardType;
import it.mystic.chat.model.response.board.BoardAnswerResponse;
import it.mystic.chat.model.response.board.BoardDiscussionResponse;
import it.mystic.chat.model.response.board.BoardResponse;
import it.mystic.chat.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/off/board")
@Tag(name = "BOARD")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @PostMapping("/create")
    public ResponseEntity<BoardResponse> create(@RequestBody BoardDao boardDao) {
        BoardResponse response = boardService.create(boardDao);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/{boardId}")
    public ResponseEntity<Void> update(@PathVariable Long boardId, @RequestBody BoardDao boardDao) {
        boardService.update(boardId, boardDao);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/getBoardsByType/{type}")
    public ResponseEntity<List<BoardResponse>> getBoardsByType(@PathVariable BoardType type) {
        List<BoardResponse> responseList = boardService.getBoardsByType(type);
        return ResponseEntity.ok(responseList);
    }

    @GetMapping(value = "/getDiscussionByBoardId/{boardId}")
    public ResponseEntity<List<BoardDiscussionResponse>> getDiscussionByBoardId(@PathVariable Long boardId) {
        List<BoardDiscussionResponse> responseList = boardService.getDiscussionByBoardId(boardId);
        return ResponseEntity.ok(responseList);
    }

    @DeleteMapping(value = "/delete/{boardId}")
    public ResponseEntity<Void> delete(@PathVariable Long boardId) {
        boardService.delete(boardId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/addDiscussion/{boardId}/{playerId}")
    public ResponseEntity<BoardDiscussionResponse> addDiscussion(@PathVariable Long boardId, @PathVariable Long playerId, @RequestBody BoardDiscussionDao boardDiscussionDao) {
        BoardDiscussionResponse response = boardService.addDiscussion(boardId, playerId, boardDiscussionDao);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/openDiscussion/{boardId}/{playerId}/{uuid}")
    public ResponseEntity<List<BoardAnswerResponse>> openDiscussion(@PathVariable Long boardId, @PathVariable Long playerId, @PathVariable UUID uuid) {
        List<BoardAnswerResponse> response = boardService.openDiscussion(boardId, playerId, uuid);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/changeIsOpen/{boardId}/{playerId}/{uuid}")
    public ResponseEntity<Void> changeIsOpen(@PathVariable Long boardId, @PathVariable Long playerId, @PathVariable UUID uuid) {
        boardService.changeIsOpen(boardId, playerId, uuid);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/changeIsPin/{boardId}/{playerId}")
    public ResponseEntity<Void> changeIsPin(@PathVariable Long boardId, @PathVariable Long playerId, @PathVariable UUID uuid) {
        boardService.changeIsPin(boardId, playerId, uuid);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/addAnswer/{boardId}/{openPlayerId}/{uuid}")
    public ResponseEntity<BoardAnswerResponse> createAnswer(@PathVariable Long boardId, @PathVariable Long openPlayerId, @PathVariable UUID uuid, @RequestBody BoardAnswerDao boardAnswerDao) {
        BoardAnswerResponse response = boardService.createAnswer(boardId, openPlayerId, uuid, boardAnswerDao);
        return ResponseEntity.ok(response);
    }
}

package it.mystic.chat.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.mystic.chat.model.dao.text.TextDao;
import it.mystic.chat.model.dao.text.TextParagraphDao;
import it.mystic.chat.model.enums.TextType;
import it.mystic.chat.model.response.EssentialData;
import it.mystic.chat.model.response.TextResponse;
import it.mystic.chat.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/off/text")
@Tag(name = "TEXT")
public class TextController {
    @Autowired
    private TextService textService;

    @PostMapping("/create")
    public ResponseEntity<TextResponse> create(@RequestBody TextDao textDao) {
        TextResponse response = textService.create(textDao);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/{textId}")
    public ResponseEntity<Void> update(@PathVariable Long textId, @RequestBody TextDao textDao) {
        textService.update(textId, textDao);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/getByType/{type}")
    public ResponseEntity<List<EssentialData>> getByType(@PathVariable TextType type) {
        List<EssentialData> responseList = textService.getByType(type);
        return ResponseEntity.ok(responseList);
    }

    @GetMapping(value = "/getById/{textId}")
    public ResponseEntity<TextResponse> getById(@PathVariable Long textId) {
        TextResponse response = textService.getById(textId);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/getParagraphById/{paragraphId}")
    public ResponseEntity<String> getParagraphById(@PathVariable Long paragraphId) {
        String response = textService.getParagraphById(paragraphId);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/delete/{textId}")
    public ResponseEntity<Void> delete(@PathVariable Long textId) {
        textService.delete(textId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/addParagraph/{textId}")
    public ResponseEntity<Void> addParagraph(@PathVariable Long textId, @RequestBody TextParagraphDao textParagraphDao) {
        textService.addParagraph(textId, textParagraphDao);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/updateParagraph/{paragraphId}")
    public ResponseEntity<Void> updateParagraph(@PathVariable Long paragraphId, @RequestBody TextParagraphDao textParagraphDao) {
        textService.updateParagraph(paragraphId, textParagraphDao);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/removeParagraph/{paragraphId}")
    public ResponseEntity<Void> removeParagraph(@PathVariable Long paragraphId) {
        textService.removeParagraph(paragraphId);
        return ResponseEntity.ok().build();
    }
}

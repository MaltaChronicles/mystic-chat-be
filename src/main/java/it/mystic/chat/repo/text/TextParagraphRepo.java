package it.mystic.chat.repo.text;

import it.mystic.chat.model.dto.text.TextParagraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TextParagraphRepo extends JpaRepository<TextParagraph, Long> {
}

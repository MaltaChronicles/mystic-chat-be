package it.mystic.chat.repo;

import it.mystic.chat.model.dto.Text;
import it.mystic.chat.model.dto.TextParagraph;
import it.mystic.chat.model.enums.TextType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TextParagraphRepo extends JpaRepository<TextParagraph, Long> {
}

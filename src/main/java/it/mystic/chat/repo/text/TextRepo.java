package it.mystic.chat.repo.text;

import it.mystic.chat.model.dto.text.Text;
import it.mystic.chat.model.enums.TextType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TextRepo extends JpaRepository<Text, Long> {
    List<Text> getByType(TextType type);
}

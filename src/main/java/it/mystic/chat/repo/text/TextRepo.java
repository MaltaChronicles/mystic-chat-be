package it.mystic.chat.repo.text;

import it.mystic.chat.model.dto.text.Text;
import it.mystic.chat.model.enums.TextType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TextRepo extends JpaRepository<Text, Long> {
    List<Text> getByType(TextType type);
}

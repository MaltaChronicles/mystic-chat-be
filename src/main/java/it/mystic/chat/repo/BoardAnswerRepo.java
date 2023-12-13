package it.mystic.chat.repo;

import it.mystic.chat.model.dto.BoardAnswer;
import it.mystic.chat.model.dto.BoardDiscussion;
import it.mystic.chat.model.dto.pk.BoardAnswerPk;
import it.mystic.chat.model.dto.pk.BoardDiscussionPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardAnswerRepo extends JpaRepository<BoardAnswer, BoardAnswerPk> {
}

package it.mystic.chat.repo.board;

import it.mystic.chat.model.dto.board.BoardAnswer;
import it.mystic.chat.model.dto.pk.BoardAnswerPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardAnswerRepo extends JpaRepository<BoardAnswer, BoardAnswerPk> {
}

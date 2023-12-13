package it.mystic.chat.repo.board;

import it.mystic.chat.model.dto.board.Board;
import it.mystic.chat.model.enums.BoardType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepo extends JpaRepository<Board, Long> {
    List<Board> getByType(BoardType type);
}

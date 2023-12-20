package it.mystic.chat.repo.board;

import it.mystic.chat.model.dto.board.BoardDiscussion;
import it.mystic.chat.model.dto.pk.BoardDiscussionPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardDiscussionRepo extends JpaRepository<BoardDiscussion, BoardDiscussionPk> {
}

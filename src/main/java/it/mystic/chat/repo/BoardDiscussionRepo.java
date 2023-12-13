package it.mystic.chat.repo;

import it.mystic.chat.model.dto.BoardDiscussion;
import it.mystic.chat.model.dto.pk.BoardDiscussionPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardDiscussionRepo extends JpaRepository<BoardDiscussion, BoardDiscussionPk> {
}

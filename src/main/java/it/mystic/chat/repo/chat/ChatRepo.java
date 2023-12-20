package it.mystic.chat.repo.chat;

import it.mystic.chat.model.dto.chat.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepo extends JpaRepository<Chat, String> {
}

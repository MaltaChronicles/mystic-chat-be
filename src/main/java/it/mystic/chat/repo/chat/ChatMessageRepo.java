package it.mystic.chat.repo.chat;

import it.mystic.chat.model.dto.chat.ChatMessage;
import it.mystic.chat.model.dto.pk.ChatMessagePk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ChatMessageRepo extends JpaRepository<ChatMessage, ChatMessagePk> {
    List<ChatMessage> findByIdDateBetween(Date startDate, Date endDate);
}

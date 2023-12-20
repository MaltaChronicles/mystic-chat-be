package it.mystic.chat.repo;

import it.mystic.chat.model.dto.Mail;
import it.mystic.chat.model.dto.pk.MailPk;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MailRepo extends JpaRepository<Mail, MailPk> {
}

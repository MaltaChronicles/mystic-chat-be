package it.mystic.chat.service;

import it.mystic.chat.mapper.MailMapper;
import it.mystic.chat.model.dto.Mail;
import it.mystic.chat.model.dto.character.Character;
import it.mystic.chat.model.dto.pk.MailPk;
import it.mystic.chat.model.response.MailResponse;
import it.mystic.chat.repo.MailRepo;
import it.mystic.chat.repo.character.CharacterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static it.mystic.chat.util.DateUtil.convertLocalDateTimeToDate;

@Service
public class MailService {

    @Autowired
    private MailRepo mailRepo;
    @Autowired
    private CharacterRepo characterRepo;

    @Autowired
    private MailMapper mailMapper;

    public MailResponse send(Long senderId, Long recipientId, String body) {
        Character sender = characterRepo.getReferenceById(senderId);
        Character recipient = characterRepo.getReferenceById(recipientId);
        Mail mail = mailMapper.daoToDto(sender, recipient, body);
        return mailMapper.dtoToResponse(mailRepo.save(mail));
    }

    public List<MailResponse> getSend(Long characterId) {
        Character character = characterRepo.getReferenceById(characterId);
        return mailMapper.mailListToResponseList(character.getMailSent());
    }

    public List<MailResponse> getRead(Long characterId) {
        Character character = characterRepo.getReferenceById(characterId);
        return mailMapper.mailListToResponseListAndFilterByIsRead(character.getMailReceived(), true);
    }

    public List<MailResponse> getToRead(Long characterId) {
        Character character = characterRepo.getReferenceById(characterId);
        return mailMapper.mailListToResponseListAndFilterByIsRead(character.getMailReceived(), false);
    }

    public void setIsRead(Long senderId, Long recipientId, LocalDateTime date) {
        Character sender = characterRepo.getReferenceById(senderId);
        Character recipient = characterRepo.getReferenceById(recipientId);

        Mail mail = mailRepo.getReferenceById(new MailPk(sender, recipient, convertLocalDateTimeToDate(date)));
        mail.setIsRead(true);

        mailRepo.save(mail);
    }
}

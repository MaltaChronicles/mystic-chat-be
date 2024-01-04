package it.mystic.chat.mapper;

import it.mystic.chat.model.dto.Mail;
import it.mystic.chat.model.dto.character.Character;
import it.mystic.chat.model.dto.pk.MailPk;
import it.mystic.chat.model.response.EssentialData;
import it.mystic.chat.model.response.MailResponse;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Component
public class MailMapper {

    public Mail daoToDto(Character sender, Character recipient, String body) {
        if (Objects.isNull(sender) || Objects.isNull(recipient) || Objects.isNull(body))
            return null;
        return new Mail(
                new MailPk(
                        sender,
                        recipient,
                        new Date()
                ),
                body,
                false
        );
    }

    public MailResponse dtoToResponse(Mail mail) {
        if (Objects.isNull(mail))
            return null;
        return new MailResponse(
                new EssentialData(
                        mail.getId().getSender().getCharacterId(),
                        mail.getId().getSender().getName()
                ),
                new EssentialData(
                        mail.getId().getRecipient().getCharacterId(),
                        mail.getId().getRecipient().getName()
                ),
                mail.getId().getDate(),
                mail.getBody(),
                mail.getIsRead()
        );
    }

    public List<MailResponse> mailListToResponseList(List<Mail> mailList) {
        if (Objects.isNull(mailList))
            return null;
        return mailList.stream().map(this::dtoToResponse).toList();
    }

    public List<MailResponse> mailListToResponseListAndFilterByIsRead(List<Mail> mailList, Boolean isRead) {
        if (Objects.isNull(mailList))
            return null;
        return mailList.stream().filter(mail -> {
            return Objects.equals(mail.getIsRead(), isRead);
        }).map(this::dtoToResponse).toList();
    }

}

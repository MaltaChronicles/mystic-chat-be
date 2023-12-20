package it.mystic.chat.model.response;

import java.util.Date;

public record MailResponse(
        EssentialData sender,
        EssentialData recipient,
        Date date,
        String body,
        Boolean isRead

) {
}

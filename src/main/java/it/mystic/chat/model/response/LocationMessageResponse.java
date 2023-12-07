package it.mystic.chat.model.response;

import it.mystic.chat.model.enums.MessageType;

import java.util.Date;

public record LocationMessageResponse(
        String sender,

        Date data,

        MessageType messageType,

        String tag,

        String body,

        String imageLink
) {
}

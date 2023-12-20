package it.mystic.chat.model.response.chat;

import it.mystic.chat.model.response.EssentialData;

import java.util.Date;

public record ChatMessageResponse(
        EssentialData player,
        Date date,
        String body
) {
}

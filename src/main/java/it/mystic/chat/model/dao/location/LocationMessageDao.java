package it.mystic.chat.model.dao.location;

public record LocationMessageDao(
        Long locationId,
        String sender,
        String tag,
        String body,
        String imageLink
) {}

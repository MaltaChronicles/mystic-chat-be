package it.mystic.chat.model.response.location;

import java.util.Date;

public record LocationPosterResponse(
        Long characterId,
        Long locationId,
        String uuid,
        String title,
        String body,
        Date date,
        Boolean isPin
) {
}

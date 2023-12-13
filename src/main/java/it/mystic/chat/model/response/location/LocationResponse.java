package it.mystic.chat.model.response.location;

public record LocationResponse(
        Long locationId,

        String name,

        String description,

        String imageUrl,

        String backgroundUrl,

        String ambientUrl
) {
}

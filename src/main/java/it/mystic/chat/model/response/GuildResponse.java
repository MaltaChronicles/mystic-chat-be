package it.mystic.chat.model.response;

import it.mystic.chat.model.response.character.CharacterGuildResponse;

import java.util.List;


public record GuildResponse(
        Long guildId,
        String name,
        String imageUrl,
        String description,
        List<CharacterGuildResponse> guilders
) {
}

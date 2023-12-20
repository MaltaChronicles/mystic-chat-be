package it.mystic.chat.model.response.character;

import it.mystic.chat.model.enums.GuildRank;

public record CharacterGuildResponse(
        Long characterId,
        String name,
        GuildRank rank
) {
}

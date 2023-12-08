package it.mystic.chat.model.response;

import it.mystic.chat.model.enums.GuildRank;

public record GuildListResponse(
    Long characterId,
    String name,
    GuildRank rank
) {}

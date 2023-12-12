package it.mystic.chat.model.response;

import java.util.List;


public record GuildResponse (
    Long guildId,
    String name,
    String imageUrl,
    String description,
    List<GuildListResponse> guilders
){}

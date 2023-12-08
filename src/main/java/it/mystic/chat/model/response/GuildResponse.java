package it.mystic.chat.model.response;

import it.mystic.chat.model.dto.GuildList;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringExclude;

import java.util.List;


public record GuildResponse (
    Long guildId,
    String name,
    String imageUrl,
    String description,
    List<GuildListResponse> guilders
){}

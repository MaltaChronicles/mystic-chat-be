package it.mystic.chat.model.dto.pk;

import it.mystic.chat.model.dto.Ability;
import it.mystic.chat.model.dto.Character;
import it.mystic.chat.model.dto.Guild;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuildListPk implements Serializable {
    @ManyToOne
    @JoinColumn(name = "character_id")
    Character character;

    @ManyToOne
    @JoinColumn(name = "guild_id")
    Guild guild;
}

package it.mystic.chat.model.dto.character;

import it.mystic.chat.model.dto.Guild;
import it.mystic.chat.model.enums.GuildRank;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
@ToString
public class CharacterGuild {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "character_id")
    @Id
    Character character;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "guild_id")
    Guild guild;

    @Column
    GuildRank rank;

    @Column(nullable = false)
    Date dateOfEntry;

    public CharacterGuild(Character character) {
        this.character = character;
        dateOfEntry = new Date();
    }
}

package it.mystic.chat.model.dto;

import it.mystic.chat.model.dto.pk.GuildListPk;
import it.mystic.chat.model.enums.GuildRank;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class GuildList {

    @EmbeddedId
    GuildListPk id;

    @Column
    GuildRank rank;

    @Column
    Date dateOfEntry;

}

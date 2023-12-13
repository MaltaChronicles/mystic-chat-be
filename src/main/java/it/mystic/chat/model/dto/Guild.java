package it.mystic.chat.model.dto;

import it.mystic.chat.model.dto.character.CharacterGuild;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringExclude;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Guild {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long guildId;
    @Column
    String name;
    @Column
    String imageUrl;
    @Column
    String description;


    @OneToMany(mappedBy = "guild", cascade = CascadeType.ALL)
    @ToStringExclude
    List<CharacterGuild> guilders;

}

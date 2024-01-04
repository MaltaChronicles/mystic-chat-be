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
    @Column(updatable = false)
    Long guildId;
    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    String imageUrl;
    @Column(nullable = false)
    String description;


    @OneToMany(mappedBy = "guild", cascade = CascadeType.ALL)
    @ToStringExclude
    List<CharacterGuild> guilders;

}

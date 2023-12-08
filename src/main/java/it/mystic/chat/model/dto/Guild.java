package it.mystic.chat.model.dto;

import it.mystic.chat.model.enums.AbilityType;
import it.mystic.chat.model.enums.Class;
import it.mystic.chat.model.enums.DurationType;
import it.mystic.chat.model.enums.TargetType;
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


    @OneToMany(mappedBy = "id.guild", cascade = CascadeType.ALL)
    @ToStringExclude
    List<GuildList> guilders;

}

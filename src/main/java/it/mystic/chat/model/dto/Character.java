package it.mystic.chat.model.dto;

import it.mystic.chat.model.enums.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.commons.lang3.builder.ToStringExclude;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "character_root")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long characterId;
    @Column
    String name;
    @Column
    String identity;
    @Column
    Origin origin;
    @Column
    Theme theme;
    @Column
    StandardOfLiving standardOfLiving;
    @Column
    Job job;
    @Column
    Race race;
    @Column
    String masterNote;
    @Column
    String personalNote;
    @Column
    String rumors;

    @OneToOne(mappedBy = "character", cascade = CascadeType.ALL)
    @ToStringExclude
    CharacterStats status;

    @OneToOne(mappedBy = "character", cascade = CascadeType.ALL)
    @ToStringExclude
    CharacterDescription description;

    @OneToOne(mappedBy = "character", cascade = CascadeType.ALL)
    @ToStringExclude
    CharacterEquipment equipment;

    @OneToMany(mappedBy = "id.character", cascade = CascadeType.ALL)
    @ToStringExclude
    List<CharacterInventory> inventory;

    @OneToMany(mappedBy = "id.character", cascade = CascadeType.ALL)
    @ToStringExclude
    List<CharacterAbilityThree> abilityThree;

    @OneToOne(mappedBy = "id.character", cascade = CascadeType.ALL)
    @ToStringExclude
    GuildList guild;


    //TODO Aggiungere Talenti
}

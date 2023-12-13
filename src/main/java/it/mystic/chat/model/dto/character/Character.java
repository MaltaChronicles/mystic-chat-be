package it.mystic.chat.model.dto.character;

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
@ToString
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
    @Column(length = 16000000)
    String masterNote;
    @Column(length = 16000000)
    String personalNote;
    @Column(length = 16000000)
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

    @OneToOne(mappedBy = "character", cascade = CascadeType.ALL)
    @ToStringExclude
    CharacterGuild guild;

    public Character(String name, String identity, Origin origin, Theme theme, StandardOfLiving standardOfLiving, Job job, Race race) {
        this.name = name;
        this.identity = identity;
        this.origin = origin;
        this.theme = theme;
        this.standardOfLiving = standardOfLiving;
        this.job = job;
        this.race = race;
    }

    //TODO Aggiungere Talenti
}

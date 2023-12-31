package it.mystic.chat.model.dto.character;

import it.mystic.chat.model.dto.Mail;
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
    @Column(updatable = false)
    Long characterId;
    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    String identity;
    @Column(nullable = false)
    Origin origin;
    @Column(nullable = false)
    Theme theme;
    @Column(nullable = false)
    StandardOfLiving standardOfLiving;
    @Column(nullable = false)
    Job job;
    @Column(nullable = false)
    Race race;
    @Column(nullable = false)
    Divinity divinity;
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

    @OneToMany(mappedBy = "id.sender", cascade = CascadeType.ALL)
    @ToStringExclude
    List<Mail> mailSent;

    @OneToMany(mappedBy = "id.recipient", cascade = CascadeType.ALL)
    @ToStringExclude
    List<Mail> mailReceived;


    public Character(String name, String identity, Origin origin, Theme theme, StandardOfLiving standardOfLiving, Job job, Race race, Divinity divinity) {
        //Se rimosso non funziona la creazione del personaggio
        this.name = name;
        this.identity = identity;
        this.origin = origin;
        this.theme = theme;
        this.standardOfLiving = standardOfLiving;
        this.job = job;
        this.race = race;
        this.divinity = divinity;
    }

    //TODO Aggiungere Talenti
}
